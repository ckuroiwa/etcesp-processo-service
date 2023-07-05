package br.gov.sp.tcesp.novoprojudi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.tcesp.novoprojudi.model.Cliente;
import br.gov.sp.tcesp.novoprojudi.repository.ClienteRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
public class ClienteController {

	 @Autowired
	  private ClienteRepository clienteRepository;
	
	 @GetMapping("/cliente")
	 public List<Cliente> findAllCliente(){
	    return clienteRepository.findAll();
	 }
	 
	 @GetMapping("/cliente/buscaCliente/{id}")
	  public ResponseEntity<Cliente> getClienteById(@PathVariable  Long id) {
	    Optional<Cliente> clienteData = clienteRepository.findById(id);
	    
	    if (clienteData.isPresent()) {
	      return new ResponseEntity<>(clienteData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	 
	 @PostMapping("/cliente/add")
	    public Cliente createProduct( @RequestBody Cliente cliente) {
	        return clienteRepository.save(cliente);
	    }
	 
	 @DeleteMapping("/cliente/delete/{id}")
	    public ResponseEntity<String> deleteTask(@PathVariable Long id){
	        boolean exist = clienteRepository.existsById(id);
	        if(exist){
	        	clienteRepository.deleteById(id);
	            return new ResponseEntity<>("Cliente apagado", HttpStatus.OK);
	        }
	        return new ResponseEntity<>("Cliente não existe", HttpStatus.BAD_REQUEST);
	    }
	 
	 @PutMapping("/cliente/update/{id}")
	  public ResponseEntity<String> updateTask(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
		   boolean exist = clienteRepository.existsById(id);
	        if(exist){
	            Cliente clienteAlter = clienteRepository.getById(id);
	           
	            clienteAlter.setNome(cliente.getNome());
	            clienteAlter.setCpfCpnj(cliente.getCpfCpnj());
	            clienteAlter.setDataNascimento(cliente.getDataNascimento());
	            clienteAlter.setEmail(cliente.getEmail());
	            clienteAlter.setTelefone(cliente.getTelefone());
	            clienteAlter.setTipoLogradouro(cliente.getTipoLogradouro());
	            clienteAlter.setLogradouro(cliente.getLogradouro());
	            clienteAlter.setNumero(cliente.getNumero());
	            clienteAlter.setComplemento(cliente.getComplemento());
	            clienteAlter.setCidade(cliente.getCidade());
	            clienteAlter.setEstado(cliente.getEstado());
	            clienteAlter.setCep(cliente.getCep());
	            clienteRepository.save(clienteAlter);
	            return new ResponseEntity<>("Cliente alterado", HttpStatus.OK);
	        }
	        return new ResponseEntity<>("Cliente não existe", HttpStatus.BAD_REQUEST);
	  }
	 
}
