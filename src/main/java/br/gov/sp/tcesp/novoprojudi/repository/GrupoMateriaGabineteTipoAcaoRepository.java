package br.gov.sp.tcesp.novoprojudi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.gov.sp.tcesp.novoprojudi.model.GrupoMateriaGabineteTipoAcao;


@Service
public interface GrupoMateriaGabineteTipoAcaoRepository extends JpaRepository<GrupoMateriaGabineteTipoAcao, Long> {

}
