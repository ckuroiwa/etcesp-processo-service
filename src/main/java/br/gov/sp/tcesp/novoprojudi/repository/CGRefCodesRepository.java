package br.gov.sp.tcesp.novoprojudi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.gov.sp.tcesp.novoprojudi.model.CGRefCodes;

public interface CGRefCodesRepository extends JpaRepository<CGRefCodes, Long> {

	@Query(value = "SELECT * FROM cg_ref_codes c WHERE c.rv_domain = ?1", nativeQuery = true)
	List<CGRefCodes> findDomain(@Param("table") String table);
		
}
