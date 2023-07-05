package br.gov.sp.tcesp.novoprojudi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.tcesp.novoprojudi.model.TipoAcao;
import br.gov.sp.tcesp.novoprojudi.repository.CustomTipoAcaoRepository;
import br.gov.sp.tcesp.novoprojudi.service.TipoAcaoService;

@Service
public class TipoAcaoServiceImpl  implements TipoAcaoService {
	
	@Autowired
	private CustomTipoAcaoRepository customTipoAcaoRepository;

	@Override
	public List<TipoAcao> listarRecursos() {
		return customTipoAcaoRepository.listarRecursos();
	}
	
	
}