package br.gov.sp.tcesp.novoprojudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.tcesp.novoprojudi.model.TipoAcao;
import br.gov.sp.tcesp.novoprojudi.repository.TipoAcaoRepository;
import br.gov.sp.tcesp.novoprojudi.service.TipoAcaoService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
public class TipoAcaoController {

	  @Autowired
	  TipoAcaoService tipoAcaoService;
	  
	  @Autowired
	  private TipoAcaoRepository tipoAcaoRepository;
	  
	  @GetMapping("/tipoAcao")
	  public List<TipoAcao> findAllTipoAcao(){
	     return tipoAcaoRepository.findAll();
	  }
	  
	  @GetMapping("/tipoAcao/listarRecursos")
	  private List<TipoAcao> listarRecursos() {
		  return tipoAcaoService.listarRecursos();
	  }
	  
	  
}
