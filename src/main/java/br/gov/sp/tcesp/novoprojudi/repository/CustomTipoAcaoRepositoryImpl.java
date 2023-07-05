package br.gov.sp.tcesp.novoprojudi.repository;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.gov.sp.tcesp.novoprojudi.model.CnjClasseCategoria;
import br.gov.sp.tcesp.novoprojudi.model.GrupoMateriaGabinete;
import br.gov.sp.tcesp.novoprojudi.model.GrupoMateriaGabineteTipoAcao;
import br.gov.sp.tcesp.novoprojudi.model.TipoAcao;


@Repository
public class CustomTipoAcaoRepositoryImpl implements CustomTipoAcaoRepository {
	
	@Autowired
	private EntityManager entityManager;

	public List<TipoAcao> listarRecursos1() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<TipoAcao> criteriaQuery = criteriaBuilder.createQuery(TipoAcao.class);
		Root<GrupoMateriaGabineteTipoAcao> fromGrupoMateriaGabineteTipoAcao = criteriaQuery.from(GrupoMateriaGabineteTipoAcao.class);

		Join<GrupoMateriaGabineteTipoAcao, TipoAcao> grupoMateriaGabinetetipoAcaoJoin =  fromGrupoMateriaGabineteTipoAcao.join("tipoAcao");
		Join<TipoAcao, CnjClasseCategoria>           tipoAcaoJoin                     =  grupoMateriaGabinetetipoAcaoJoin.join("cnjClasseCategoria");
		Join<GrupoMateriaGabineteTipoAcao, GrupoMateriaGabinete> grupoMateriaGabineteJoin = fromGrupoMateriaGabineteTipoAcao.join("grupoMateriaGabinete"); 
		
		criteriaQuery.where( criteriaBuilder.and(criteriaBuilder.isNotNull(tipoAcaoJoin.get("seqCategoriaPai"))),
				             criteriaBuilder.and(grupoMateriaGabineteJoin.get("codgrupomateria").in(5, 6)),
				             criteriaBuilder.and(criteriaBuilder.equal(grupoMateriaGabinetetipoAcaoJoin.get("indicadorCompetenciaTurma"), 1))
				           );
		
		criteriaQuery.select(grupoMateriaGabinetetipoAcaoJoin);
		criteriaQuery.orderBy(criteriaBuilder.asc(grupoMateriaGabinetetipoAcaoJoin.get("descricao")));
		return entityManager.createQuery(criteriaQuery).getResultList();
		
		
	}
	
	
	public List<TipoAcao> listarRecursos() {
		List<GrupoMateriaGabinete> grupoMateriaGabinetes = new ArrayList<GrupoMateriaGabinete>();
		
		GrupoMateriaGabinete grupoMateriaGabinete = new GrupoMateriaGabinete();
		grupoMateriaGabinete.setCodgrupomateria(new Long(5));
		grupoMateriaGabinetes.add(grupoMateriaGabinete);
		grupoMateriaGabinete = new GrupoMateriaGabinete();
		grupoMateriaGabinete.setCodgrupomateria(new Long(6));
		grupoMateriaGabinetes.add(grupoMateriaGabinete);
		
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		Long competenciaTurma = (long) 1;
		CriteriaQuery<TipoAcao> criteriaQuery = builder.createQuery(TipoAcao.class);

		Root<GrupoMateriaGabineteTipoAcao> grupoMateriaGabineteTipoAcaoRoot = criteriaQuery.from(GrupoMateriaGabineteTipoAcao.class);
		Join<GrupoMateriaGabineteTipoAcao, GrupoMateriaGabinete> grupomateriaJoin = grupoMateriaGabineteTipoAcaoRoot.join("grupoMateriaGabinete");
		Join<GrupoMateriaGabineteTipoAcao, TipoAcao> tipoAcaoJoin = grupoMateriaGabineteTipoAcaoRoot.join("tipoAcao");
		Join<TipoAcao, CnjClasseCategoria> cnjClasseCategoriaJoin = tipoAcaoJoin.join("cnjClasseCategoria");

		List<Long> codigosGrupoMateria = grupoMateriaGabinetes.stream().map(GrupoMateriaGabinete::getCodgrupomateria).collect(Collectors.toList());

		criteriaQuery.select(tipoAcaoJoin);
		criteriaQuery.where(builder.isNotNull(cnjClasseCategoriaJoin.get("seqCategoriaPai")),
				grupomateriaJoin.get("codgrupomateria").in(codigosGrupoMateria),
				builder.equal(tipoAcaoJoin.get("indicadorCompetenciaTurma"), competenciaTurma));
		criteriaQuery.orderBy(builder.asc(tipoAcaoJoin.get("descricao")));

		return entityManager.createQuery(criteriaQuery).getResultList();
	}
	
}
