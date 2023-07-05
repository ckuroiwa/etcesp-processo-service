package br.gov.sp.tcesp.novoprojudi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.gov.sp.tcesp.novoprojudi.model.Processo;
import br.gov.sp.tcesp.novoprojudi.model.ProcessoRelacionamento;
import br.gov.sp.tcesp.novoprojudi.repository.ProcessoRepository;
import br.gov.sp.tcesp.novoprojudi.service.ProcessoService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
public class ProcessoController {

  @Autowired
  ProcessoRepository processoRepository;

  @Autowired
  private ProcessoService processoService;

  
  private Sort.Direction getSortDirection(String direction) {
    if (direction.equals("asc")) {
      return Sort.Direction.ASC;
    } else if (direction.equals("desc")) {
      return Sort.Direction.DESC;
    }

    return Sort.Direction.ASC;
  }

  @GetMapping("/processo/processosFilter")
  public ResponseEntity<Map<String, Object>> getAllProcessosFilterPage(
      @RequestParam(required = false) Long numeroProcesso,
      @RequestParam(required = false) Long numProcessoDependente,
      @RequestParam(required = false) Long tipoAcao,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "3") int size,
      @RequestParam(defaultValue = "numeroProcesso, desc") String[] sort) {

    try {
      List<Order> orders = new ArrayList<Order>();

      if (sort[0].contains(",")) {
        // will sort more than 2 fields
        // sortOrder="field, direction"
        for (String sortOrder : sort) {
          String[] _sort = sortOrder.split(",");
          orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
        }
      } else {
        orders.add(new Order(getSortDirection(sort[1]), sort[0]));
      }

      List<Processo> processos = new ArrayList<Processo>();
      
      Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));

      Page<Processo> pageProcs;
      if (numeroProcesso == null)
         pageProcs = processoRepository.findPagination(pagingSort);
      else
        pageProcs = processoRepository.findByNumeroProcesso(numeroProcesso, pagingSort);
        
      processos = pageProcs.getContent();

      Map<String, Object> response = new HashMap<>();
      response.put("processos", processos);
      response.put("currentPage", pageProcs.getNumber());
      response.put("totalItems", pageProcs.getTotalElements());
      response.put("totalPages", pageProcs.getTotalPages());

      return new ResponseEntity<>(response, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  
  @GetMapping("/processo/buscaProcesso/{numeroProcesso}")
  public ResponseEntity<Processo> getProcessoById(@PathVariable("numeroProcesso") Long numeroProcesso) {
    Optional<Processo> processoData = processoRepository.findById(numeroProcesso);

    if (processoData.isPresent()) {
      return new ResponseEntity<>(processoData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  
	@GetMapping("/processo/listAll")
	private List<Processo> listAll(
			@RequestParam(required = false) Processo processo){
		return processoService.listAllProcessos(processo);
	}

	@PostMapping("/processo/listAllProcessosPage")
	private Page<Processo> listAllPage(
			@RequestParam(name = "processo", required = false) String jsonProcesso,
			@RequestParam(name = "page", required = false) int page,
			@RequestParam(name = "size", required = false) int size) throws StreamReadException, DatabindException, IOException
	{
		
		byte[] jsonData = jsonProcesso.getBytes();

        ObjectMapper mapper = new ObjectMapper();
        Processo processo = mapper.readValue(jsonData, Processo.class);
		  
		List<Order> orders = new ArrayList<Order>();
		Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));
		
		return processoService.listAllProcessosPage(processo, pagingSort);
	}
	
//  @GetMapping("/sortedProcessos")
//  public ResponseEntity<List<Processo>> getAllProcessos(@RequestParam(defaultValue = "numeroProcesso, desc") String[] sort) {
//
//    try {
//      List<Order> orders = new ArrayList<Order>();
//
//      if (sort[0].contains(",")) {
//        // will sort more than 2 fields
//        // sortOrder="field, direction"
//        for (String sortOrder : sort) {
//          String[] _sort = sortOrder.split(",");
//          orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
//        }
//      } else {
//        // sort=[field, direction]
//        orders.add(new Order(getSortDirection(sort[1]), sort[0]));
//      }
//
//      List<Processo> processos = processoRepository.findAll(Sort.by(orders));
//
//      if (processos.isEmpty()) {
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//      }
//
//      return new ResponseEntity<>(processos, HttpStatus.OK);
//    } catch (Exception e) {
//      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//  }
  
//  @GetMapping("/processos")
//  public ResponseEntity<Map<String, Object>> getAllProcessosPage(
//      @RequestParam(required = false) Long numeroProcesso,
//      @RequestParam(defaultValue = "0") int page,
//      @RequestParam(defaultValue = "3") int size,
//      @RequestParam(defaultValue = "numeroProcesso, desc") String[] sort) {
//
//    try {
//      List<Order> orders = new ArrayList<Order>();
//
//      if (sort[0].contains(",")) {
//        // will sort more than 2 fields
//        // sortOrder="field, direction"
//        for (String sortOrder : sort) {
//          String[] _sort = sortOrder.split(",");
//          orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
//        }
//      } else {
//        // sort=[field, direction]
//        orders.add(new Order(getSortDirection(sort[1]), sort[0]));
//      }
//
//      List<Processo> processos = new ArrayList<Processo>();
//      
//      Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));
//
//      Page<Processo> pageProcs;
//      if (numeroProcesso == null)
//        pageProcs = processoRepository.findAll(pagingSort);
//      else
//      	//processos = processoRepository.findPagination(page, size);
//        pageProcs = (Page<Processo>) processoRepository.findPagination(/*page, size, */pagingSort);  //findAll(pagingSort); //processoRepository.findByProcessoContaining(numeroProcesso, pagingSort);
//
//      processos = pageProcs.getContent();
//
//      Map<String, Object> response = new HashMap<>();
//      response.put("processos", processos);
//      response.put("currentPage", pageProcs.getNumber());
//      response.put("totalItems", pageProcs.getTotalElements());
//      response.put("totalPages", pageProcs.getTotalPages());
//
//      return new ResponseEntity<>(response, HttpStatus.OK);
//    } catch (Exception e) {
//      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//  }
  

//  @GetMapping("/processos")
//  public ResponseEntity<Map<String, Object>> getAllProcessosPage(
//      @RequestParam(required = false) Long numeroProcesso,
//      @RequestParam(defaultValue = "0") int page,
//      @RequestParam(defaultValue = "3") int size,
//      @RequestParam(defaultValue = "numeroProcesso, desc") String[] sort) {
//
//    try {
//      List<Order> orders = new ArrayList<Order>();
//
//      if (sort[0].contains(",")) {
//        // will sort more than 2 fields
//        // sortOrder="field, direction"
//        for (String sortOrder : sort) {
//          String[] _sort = sortOrder.split(",");
//          orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
//        }
//      } else {
//        // sort=[field, direction]
//        orders.add(new Order(getSortDirection(sort[1]), sort[0]));
//      }
//
//      List<Processo> processos = new ArrayList<Processo>();
//      Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));
//
//      Page<Processo> pageProcs;
//      if (numeroProcesso == null)
//        pageProcs = processoRepository.findAll(pagingSort);
//      else
//        pageProcs = processoRepository.findAll(pagingSort); //processoRepository.findByProcessoContaining(numeroProcesso, pagingSort);
//
//      processos = pageProcs.getContent();
//
//      Map<String, Object> response = new HashMap<>();
//      response.put("processos", processos);
//      response.put("currentPage", pageProcs.getNumber());
//      response.put("totalItems", pageProcs.getTotalElements());
//      response.put("totalPages", pageProcs.getTotalPages());
//
//      return new ResponseEntity<>(response, HttpStatus.OK);
//    } catch (Exception e) {
//      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//  }

//  @GetMapping("/processos/published")
//  public ResponseEntity<Map<String, Object>> findByPublished(
//      @RequestParam(defaultValue = "0") int page,
//      @RequestParam(defaultValue = "3") int size) {
//    
//    try {
//      List<Processo> processos = new ArrayList<Processo>();
//      Pageable paging = PageRequest.of(page, size);
//
//      Page<Processo> pageProcs = processoRepository.findByProcesso(true, paging);
//      processos = pageProcs.getContent();
//
//      Map<String, Object> response = new HashMap<>();
//      response.put("processos", processos);
//      response.put("currentPage", pageProcs.getNumber());
//      response.put("totalItems", pageProcs.getTotalElements());
//      response.put("totalPages", pageProcs.getTotalPages());
//
//      return new ResponseEntity<>(response, HttpStatus.OK);
//    } catch (Exception e) {
//      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//  }

//  @PostMapping("/processos")
//  public ResponseEntity<Processo> createProcesso(@RequestBody Processo processo) {
//    try {
//      Processo _processo = processoRepository.save(new Processo(processo.getNumeroProcesso(), processo.getNumProcessoDependente(), processo.getTipoAcao()));
//      return new ResponseEntity<>(_processo, HttpStatus.CREATED);
//    } catch (Exception e) {
//      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//  }

//  @PutMapping("/processos/{numeroProcesso}")
//  public ResponseEntity<Processo> updateProcesso(@PathVariable("numeroProcesso") Long numeroProcesso, @RequestBody Processo processo) {
//    Optional<Processo> processoData = processoRepository.findById(numeroProcesso);
//
//    if (processoData.isPresent()) {
//      Processo _processo = processoData.get();
//      _processo.setNumeroProcesso(_processo.getNumeroProcesso());
//      _processo.setNumProcessoDependente(_processo.getNumProcessoDependente());
//      _processo.setTipoAcao(_processo.getTipoAcao());
//      return new ResponseEntity<>(processoRepository.save(_processo), HttpStatus.OK);
//    } else {
//      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//  }

//  @DeleteMapping("/processos/{numeroProcesso}")
//  public ResponseEntity<HttpStatus> deleteProcesso(@PathVariable("numeroProcesso") Long numeroProcesso) {
//    try {
//      processoRepository.deleteById(numeroProcesso);
//      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    } catch (Exception e) {
//      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//  }

//  @DeleteMapping("/processos")
//  public ResponseEntity<HttpStatus> deleteAllProcessos() {
//    try {
//      processoRepository.deleteAll();
//      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    } catch (Exception e) {
//      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//    }
  
     
  }
