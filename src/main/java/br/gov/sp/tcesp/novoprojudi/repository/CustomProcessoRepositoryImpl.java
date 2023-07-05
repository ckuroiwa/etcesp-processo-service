package br.gov.sp.tcesp.novoprojudi.repository;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import br.gov.sp.tcesp.novoprojudi.model.Processo;
import br.gov.sp.tcesp.novoprojudi.model.ProcessoReferencia;
import br.gov.sp.tcesp.novoprojudi.model.ProcessoRelacionamento;
import br.gov.sp.tcesp.novoprojudi.model.TipoAcao;
import br.gov.sp.tcesp.novoprojudi.util.DiaHoraEventos;


@Repository
public class CustomProcessoRepositoryImpl implements CustomProcessoRepository {
	
	@Autowired
	private EntityManager entityManager;


	
	@Override
	public List<Processo> listAllProcessos(Processo processo) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Processo> criteriaQuery = criteriaBuilder.createQuery(Processo.class);
		Root<Processo> root = criteriaQuery.from(Processo.class);
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		clausuraWhere(processo, criteriaBuilder, root, predicates, criteriaQuery);
		criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
		
		return entityManager.createQuery(criteriaQuery).getResultList();

	}
	
	@Override
	public Page<Processo> listAllProcessosPage(Processo processo, Pageable pageable){
		//List<Processo> listaProcesso = listAllProcessos(processo, pageable.getOffset(), pageable.getPageSize());
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Processo> criteriaQuery = criteriaBuilder.createQuery(Processo.class);
		Root<Processo> root = criteriaQuery.from(Processo.class);
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		clausuraWhere(processo, criteriaBuilder, root, predicates, criteriaQuery);
		criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
	
		int pageOffset = (int) pageable.getOffset();
		int qtLimit = pageable.getPageSize();
		
		List<Processo> result = entityManager.createQuery(criteriaQuery) 
				.setFirstResult(pageOffset)
                .setMaxResults(qtLimit)
                .getResultList();
		

		CriteriaQuery<Long> cq = criteriaBuilder.createQuery(Long.class);
		cq.select(criteriaBuilder.count(cq.from(Processo.class)));
		cq.where(predicates.toArray(new Predicate[predicates.size()]));
		Long qtTotal = entityManager.createQuery(cq).getSingleResult();
		
		Page<Processo> pages = new PageImpl<Processo>(result, pageable, qtTotal);
	        
	    return pages;
	        
	}

	private void clausuraWhere(Processo processo, CriteriaBuilder criteriaBuilder, Root<Processo> root,	List<Predicate> predicates, CriteriaQuery<Processo> criteriaQuery) {
			
			predicates.add(criteriaBuilder.isNotNull(root.get("codVara")));
		 	
			if(processo.getNumeroProcesso() != null && processo.getNumeroProcesso() > 0) {
				predicates.add(criteriaBuilder.equal(root.get("numeroProcesso"), processo.getNumeroProcesso()));
			}
			
			
			if(processo.getNumeroProcessoReferenciado() != null && processo.getNumeroProcessoReferenciado() > 0) {
				Subquery<ProcessoReferencia> subqueryPR = criteriaQuery.subquery(ProcessoReferencia.class);
				Root<ProcessoReferencia> subqueryRootPR = subqueryPR.from(ProcessoReferencia.class);
				subqueryPR.select(subqueryRootPR.get("numeroProcesso")).where
				(
						criteriaBuilder.and
						(
						criteriaBuilder.equal(subqueryRootPR.get("refNum"), processo.getNumeroProcessoReferenciado()),
						criteriaBuilder.isNull(subqueryRootPR.get("dataFim"))
						)
				);

				predicates.add(criteriaBuilder.in(root.get("numeroProcesso")).value(subqueryPR));
			}
			
		    if(processo.getCopiaDe() != null && processo.getCopiaDe().longValue() > 0) {
				predicates.add(criteriaBuilder.equal(root.get("copiaDe"), processo.getCopiaDe()));
			}
				
			if(processo.getTipoAcao() != null && processo.getTipoAcao().intValue() >= 0) {
				Subquery<TipoAcao> subqueryTA = criteriaQuery.subquery(TipoAcao.class);
				Root<TipoAcao> subqueryRootTA = subqueryTA.from(TipoAcao.class);
				subqueryTA.select(subqueryRootTA.get("codTipoAcao")).where 
				(
						criteriaBuilder.equal(subqueryRootTA.get("tipo"), processo.getTipoAcao())
				);
				predicates.add(criteriaBuilder.in(root.get("tipoAcao")).value(subqueryTA));
			}
			
            if(processo.getExercicio() != null) {
				predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("exercicio"), processo.getExercicio()));
            }

            DiaHoraEventos datahorarioInicial = (processo.getDataAutuacaoIni() != null) ? new DiaHoraEventos(processo.getDataAutuacaoIni()) : null;
            DiaHoraEventos datahorarioFinal   = (processo.getDataAutuacaoFim() != null) ? new DiaHoraEventos(processo.getDataAutuacaoFim()) : null;
            
            if(processo.getDataAutuacaoIni() != null) {
            	System.out.println(datahorarioInicial.getDataHoraInicial().toString());
				predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("dataRecebimento"), datahorarioInicial.getDataHoraInicial()));
            }
			
			if(processo.getDataAutuacaoFim() != null) {
				System.out.println(datahorarioInicial.getDataHoraFinal().toString());
				predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("dataRecebimento"), datahorarioFinal.getDataHoraFinal()));
			}
			
			if (processo.getValorAcaoIni() != null && !processo.getValorAcaoIni().equals("")){
				predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("valoracao"), processo.getValorAcaoIni() ));
			};
			
			if (processo.getValorAcaoFim() != null && !processo.getValorAcaoFim().equals("")){
				predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("valoracao"), processo.getValorAcaoFim() ));
			};
			
			if (processo.getProcComRecTipoAcao() != null && !processo.getProcComRecTipoAcao().equals("")){
				// convert String to array of String
				String[] elements = processo.getProcComRecTipoAcao().split(",");
		  
		        // Convert String array to List of String
		        // This List is unmodifiable
		        List<String> listString = Arrays.asList(elements);
		        

                List<BigInteger> listBigInteger = listString.stream()
                                .map(BigInteger::new) 
                                .collect(Collectors.toList());
		        
				CriteriaQuery<Processo> query = criteriaBuilder.createQuery(Processo.class);
				Root<Processo> processoRoot = query.from(Processo.class);
				
				Subquery<Long> subquery = query.subquery(Long.class);
				Root<ProcessoRelacionamento> processoRelacionamentoRoot = subquery.from(ProcessoRelacionamento.class);
				Join<ProcessoRelacionamento, Processo> processoJoin          = processoRelacionamentoRoot.join("processoRelacionado");
				Join<ProcessoRelacionamento, Processo> processoJoinPrincipal = processoRelacionamentoRoot.join("processoPrincipal");
				subquery.select(processoJoin.get("numeroProcesso")).where(
						criteriaBuilder.and(
							criteriaBuilder.in(root.get("tipoAcao")).value(listBigInteger),	
							criteriaBuilder.equal (processoRelacionamentoRoot.get("tiporelacao"), 2L), 
							criteriaBuilder.isNull(processoRelacionamentoRoot.get("fim"))
						)
				);
				
				predicates.add(criteriaBuilder.and 
				       (
				        criteriaBuilder.in(root.get("numeroProcesso")).value(subquery)
				       )
				);
			}				
	}

}
