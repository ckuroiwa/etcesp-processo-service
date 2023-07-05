package br.gov.sp.tcesp.novoprojudi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.gov.sp.tcesp.novoprojudi.model.Processo;

public interface CustomProcessoRepository {

	List<Processo> listAllProcessos(Processo processo);
	
	Page<Processo> listAllProcessosPage(Processo processo, Pageable pageable);

}
