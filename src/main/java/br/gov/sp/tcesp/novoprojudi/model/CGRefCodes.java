package br.gov.sp.tcesp.novoprojudi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cg_ref_codes")
public class CGRefCodes implements Serializable {

	private static final long serialVersionUID = 61218848542235551L;

	@Id
	@Column(name = "rvLowValue")
	private String id;
	
	@Column(name = "rvMeaning")
	private String descricao;
	
	@Column(name = "rvHighValue")
	private String alt;
	
	@Column(name = "rvAbbreviation")
	private String getDescricaoAlt;
	
	@Column(name = "rvDomain")
	private String domain;
	
	public CGRefCodes() {
		super();
		
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
    
	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getAlt() {
		return alt;
	}


	public void setAlt(String alt) {
		this.alt = alt;
	}


	public String getDescricaoAlt() {
		return getDescricaoAlt;
	}


	public void setDescricaoAlt(String getDescricaoAlt) {
		this.getDescricaoAlt = getDescricaoAlt;
	}


	public String getDomain() {
		return domain;
	}


	public void setDomain(String domain) {
		this.domain = domain;
	}
	
}