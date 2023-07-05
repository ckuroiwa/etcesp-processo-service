package br.gov.sp.tcesp.novoprojudi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by p-ckuroiwa on 07/05/2023.
 */

@Entity
@Table(name = "grupo_materia_gabinete_tipo_acao")
public class GrupoMateriaGabineteTipoAcao implements Serializable {

    private static final long serialVersionUID = 2673930679464267973L;
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "datainclusao")
    private Date datainclusao;
    
	@Column(name = "dataexclusao")
    private Date dataexclusao;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codgrupomateria")
    private GrupoMateriaGabinete grupoMateriaGabinete;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codtipoacao")
    private TipoAcao tipoAcao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatainclusao() {
		return datainclusao;
	}

	public void setDatainclusao(Date datainclusao) {
		this.datainclusao = datainclusao;
	}

	public Date getDataexclusao() {
		return dataexclusao;
	}

	public void setDataexclusao(Date dataexclusao) {
		this.dataexclusao = dataexclusao;
	}

	public GrupoMateriaGabinete getGrupoMateriaGabinete() {
		return grupoMateriaGabinete;
	}

	public void setGrupoMateriaGabinete(GrupoMateriaGabinete grupoMateriaGabinete) {
		this.grupoMateriaGabinete = grupoMateriaGabinete;
	}

	public TipoAcao getTipoAcao() {
		return tipoAcao;
	}

	public void setTipoAcao(TipoAcao tipoAcao) {
		this.tipoAcao = tipoAcao;
	}
	
	
	
}    