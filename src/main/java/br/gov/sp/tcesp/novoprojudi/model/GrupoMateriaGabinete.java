package br.gov.sp.tcesp.novoprojudi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grupo_materia_gabinete")
public class GrupoMateriaGabinete implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6272395129446415400L;

	@Id
	@Column(name = "codgrupomateria")
	private Long codgrupomateria;
	
	@Column(name = "codvara")
	private Integer codvara;
    
	@Column(name = "descricao")
	private String descricao;
    
	@Column(name = "datainclusao")
	private Date dataInclusao;
    
	@Column(name = "dataexclusao")
	private Date dataExclusao;

	public Long getCodgrupomateria() {
		return codgrupomateria;
	}

	public void setCodgrupomateria(Long codgrupomateria) {
		this.codgrupomateria = codgrupomateria;
	}

	public Integer getCodvara() {
		return codvara;
	}

	public void setCodvara(Integer codvara) {
		this.codvara = codvara;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Date getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(Date dataExclusao) {
		this.dataExclusao = dataExclusao;
	}
    
	
	
}    