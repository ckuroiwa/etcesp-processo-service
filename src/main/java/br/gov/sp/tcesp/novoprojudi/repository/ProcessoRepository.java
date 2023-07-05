package br.gov.sp.tcesp.novoprojudi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import br.gov.sp.tcesp.novoprojudi.model.Processo;

@Service
public interface ProcessoRepository extends JpaRepository<Processo, Long> {
	  @Query(value = "SELECT * FROM processo where numeroProcesso= :numeroProcesso", 
			  countQuery = "SELECT count(*) from processo where numeroProcesso= :numeroProcesso",
			  nativeQuery = true)
	  Page<Processo> findByNumeroProcesso(@Param("numeroProcesso") Long numeroProcesso, Pageable pageable);
		
	  @Query(value = "SELECT * FROM processo p ",
             countQuery = "SELECT count(*) from processo ",
             nativeQuery = true)
      Page<Processo> findPagination(Pageable pageable);
	  
}
	  
