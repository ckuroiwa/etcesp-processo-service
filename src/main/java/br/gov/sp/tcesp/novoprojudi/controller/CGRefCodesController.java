package br.gov.sp.tcesp.novoprojudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.tcesp.novoprojudi.model.CGRefCodes;
import br.gov.sp.tcesp.novoprojudi.repository.CGRefCodesRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
public class CGRefCodesController {
	  @Autowired
	  private CGRefCodesRepository cGRefCodesRepository;
	
	  @GetMapping("/cgrefcodes")
	  public List<CGRefCodes> findAllcGRefCodes(){
	     return cGRefCodesRepository.findAll();
	  }
	  
	  @GetMapping("/cgrefcodes/findDomain/{table}")
	  public List<CGRefCodes> findDomain(@PathVariable("table") String table) {
	  List<CGRefCodes> processoData = cGRefCodesRepository.findDomain(table);
	  return  processoData;
	  }
}