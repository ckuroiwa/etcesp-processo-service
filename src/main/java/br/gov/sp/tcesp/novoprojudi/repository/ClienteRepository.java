package br.gov.sp.tcesp.novoprojudi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.tcesp.novoprojudi.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}
