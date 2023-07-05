package br.gov.sp.tcesp.novoprojudi.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.gov.sp.tcesp.novoprojudi.model.TipoAcao;
import br.gov.sp.tcesp.novoprojudi.repository.TipoAcaoRepository;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver {
	
	
	private TipoAcaoRepository tipoAcaoRepository;
	

	@Autowired
	public Query(TipoAcaoRepository tipoAcaoRepository) {
		this.tipoAcaoRepository = tipoAcaoRepository;
		
	}

	public Iterable<TipoAcao> findAllTipoAcaoQL() {
		return tipoAcaoRepository.findAll();
	}

	public Long countTipoAcaoQL() {
		return tipoAcaoRepository.count();
	}
	

}
