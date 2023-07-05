package br.gov.sp.tcesp.novoprojudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.tcesp.novoprojudi.model.GrupoMateriaGabineteTipoAcao;
import br.gov.sp.tcesp.novoprojudi.repository.GrupoMateriaGabineteTipoAcaoRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
public class GrupoMateriaGabineteTipoAcaoController {

	  
	  @Autowired
	  private GrupoMateriaGabineteTipoAcaoRepository grupoMateriaGabineteTipoAcaoRepository;
	  
	  @GetMapping("/grupoMateriaGabineteTipoAcao")
	  public List<GrupoMateriaGabineteTipoAcao> findAllTipoAcao(){
	     return grupoMateriaGabineteTipoAcaoRepository.findAll();
	  }
	  
	  
}
