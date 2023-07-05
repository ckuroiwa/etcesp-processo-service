package br.gov.sp.tcesp.novoprojudi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.gov.sp.tcesp.novoprojudi.model.Processo;
import br.gov.sp.tcesp.novoprojudi.repository.CustomProcessoRepository;
import br.gov.sp.tcesp.novoprojudi.service.ProcessoService;


@Service
public class ProcessoServiceImpl implements ProcessoService{
	
	@Autowired
	private CustomProcessoRepository customProcessoRepository;

	@Override
	public List<Processo> listAllProcessos(Processo processo) {
		// TODO Auto-generated method stub
		return customProcessoRepository.listAllProcessos(processo);
	}

	public Page<Processo> listAllProcessosPage(Processo processo, Pageable pageable) {
		return customProcessoRepository.listAllProcessosPage(processo, pageable);
	}
	
}
