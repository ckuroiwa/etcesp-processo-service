package br.gov.sp.tcesp.novoprojudi.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "processo")
public class Processo implements Serializable {

	private static final long serialVersionUID = -5216009468784427886L;

	@Id
	@Column(name = "numeroprocesso")
	private Long numeroProcesso;
	
	@Column(name = "numprocessodependente")
	private Long numProcessoDependente;
	
	@Column(name = "tipoacao")
	private BigInteger tipoAcao;
	
	@Column(name = "copiade")
	private BigInteger copiaDe;
	
	@Column(name = "cod_vara")
	private BigInteger codVara;
	
	@Column(name = "valoracao")
	private Double valoracao;
	
	@Column(name = "exercicio")
	private BigInteger exercicio;
	
	@Column(name = "datarecebimento")
	private Date dataRecebimento;
	
	@Transient
	private Long numeroProcessoReferenciado;
	
	@Transient
	private String procComRecTipoAcao;

	@Transient
	private String valorAcaoIni;
	
	@Transient
	private String valorAcaoFim;
	
	@Transient
	private Date dataAutuacaoIni;
	
	@Transient
	private Date dataAutuacaoFim;
	
	public String getProcComRecTipoAcao() {
		return procComRecTipoAcao;
	}

	public void setProcComRecTipoAcao(String procComRecTipoAcao) {
		this.procComRecTipoAcao = procComRecTipoAcao;
	}

	public Processo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    public Processo(Long numeroProcesso, Long numProcessoDependente, BigInteger tipoAcao) {
	    this.numeroProcesso = numeroProcesso;
	    this.numProcessoDependente = numProcessoDependente;
	    this.tipoAcao = tipoAcao;
	}

	public Long getNumeroProcesso() {
		return numeroProcesso;
	}

	public void setNumeroProcesso(Long numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

	public Long getNumProcessoDependente() {
		return numProcessoDependente;
	}

	public void setNumProcessoDependente(Long numProcessoDependente) {
		this.numProcessoDependente = numProcessoDependente;
	}

	
	public BigInteger getCopiaDe() {
		return copiaDe;
	}

	public void setCopiaDe(BigInteger copiaDe) {
		this.copiaDe = copiaDe;
	}

	public BigInteger getTipoAcao() {
		return tipoAcao;
	}

	public void setTipoAcao(BigInteger tipoAcao) {
		this.tipoAcao = tipoAcao;
	}
	
	public Long getNumeroProcessoReferenciado() {
		return numeroProcessoReferenciado;
	}

	public void setNumeroProcessoReferenciado(Long numeroProcessoReferenciado) {
		this.numeroProcessoReferenciado = numeroProcessoReferenciado;
	}

	public BigInteger getCodVara() {
		return codVara;
	}

	public void setCodVara(BigInteger codVara) {
		this.codVara = codVara;
	}
	
	public Double getValoracao() {
		return valoracao;
	}

	public void setValoracao(Double valoracao) {
		this.valoracao = valoracao;
	}


	public String getValorAcaoIni() {
		return valorAcaoIni;
	}

	public void setValorAcaoIni(String valorAcaoIni) {
		this.valorAcaoIni = valorAcaoIni;
	}

	public String getValorAcaoFim() {
		return valorAcaoFim;
	}

	public void setValorAcaoFim(String valorAcaoFim) {
		this.valorAcaoFim = valorAcaoFim;
	}

	public Date getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(Date dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public Date getDataAutuacaoIni() {
		return dataAutuacaoIni;
	}

	public void setDataAutuacaoIni(Date dataAutuacaoIni) {
		this.dataAutuacaoIni = dataAutuacaoIni;
	}

	public Date getDataAutuacaoFim() {
		return dataAutuacaoFim;
	}

	public void setDataAutuacaoFim(Date dataAutuacaoFim) {
		this.dataAutuacaoFim = dataAutuacaoFim;
	}

	public BigInteger getExercicio() {
		return exercicio;
	}

	public void setExercicio(BigInteger exercicio) {
		this.exercicio = exercicio;
	}

	
    
}