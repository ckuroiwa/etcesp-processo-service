package br.gov.sp.tcesp.novoprojudi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cnj_classe_categoria")
public class CnjClasseCategoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6097470515965075388L;

	@Id
	@Column(name = "SEQ_CATEGORIA")
	private Long seqCategoria;
	
	@Column(name = "DESC_CATEGORIA")
	private String descCategoria;
	
	@Column(name = "SEQ_CATEGORIA_PAI")
    private Integer seqCategoriaPai;
	
	@Column(name = "IS_ATIVO")
    private String isAtivo;
	
	public Long getSeqCategoria() {
		return seqCategoria;
	}
	public void setSeqCategoria(Long seqCategoria) {
		this.seqCategoria = seqCategoria;
	}
	public String getDescCategoria() {
		return descCategoria;
	}
	public void setDescCategoria(String descCategoria) {
		this.descCategoria = descCategoria;
	}
	public Integer getSeqCategoriaPai() {
		return seqCategoriaPai;
	}
	public void setSeqCategoriaPai(Integer seqCategoriaPai) {
		this.seqCategoriaPai = seqCategoriaPai;
	}
	public String getIsAtivo() {
		return isAtivo;
	}
	public void setIsAtivo(String isAtivo) {
		this.isAtivo = isAtivo;
	}
    
    
}
