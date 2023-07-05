package br.gov.sp.tcesp.novoprojudi.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "processo_referencia")
public class ProcessoReferencia implements Serializable {

	private static final long serialVersionUID = -4299294344912543912L;

	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "numero_processo")
	private Long numeroProcesso;
	
	@Column(name = "ref_num")
	private BigInteger refNum;

	@Column(name = "ref_txt")
	private String refTxt;
	
	@Column(name = "ref_txt_retorno")
	private String refTxtRetorno;

	@Column(name = "login")
	private String login;
    
	@Column(name = "data_inicio")
	private Date dataInicio;
    
	@Column(name = "data_fim")
	private Date dataFim;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNumeroProcesso() {
		return numeroProcesso;
	}

	public void setNumeroProcesso(Long numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

	public BigInteger getRefNum() {
		return refNum;
	}

	public void setRefNum(BigInteger refNum) {
		this.refNum = refNum;
	}

	public String getRefTxt() {
		return refTxt;
	}

	public void setRefTxt(String refTxt) {
		this.refTxt = refTxt;
	}

	public String getRefTxtRetorno() {
		return refTxtRetorno;
	}

	public void setRefTxtRetorno(String refTxtRetorno) {
		this.refTxtRetorno = refTxtRetorno;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	
}