package br.gov.sp.tcesp.novoprojudi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "processo_situacao")
public class ProcessoSituacao implements Serializable {

	private static final long serialVersionUID = 7956973889990488731L;

	@Id
	@Column(name = "numeroProcesso")
	private Long numeroProcesso;
	
	@Column(name = "sobrestado", nullable = true)
	private Long sobrestado;
	
	@Column(name = "arquivado", nullable = true)
	private Boolean arquivado;
	
	@Column(name = "recurso", nullable = true)
	private Boolean recurso;
	
	@Column(name = "recursoAtivo", nullable = true)
	private Boolean recursoAtivo;
	
	@Column(name = "recursoArquivado", nullable = true)
	private Boolean recursoArquivado;
	
	@Column(name = "conclusao", nullable = true)
	private Long conclusao;
	
	@Column(name = "vistas", nullable = true)
	private Integer vistas;
	
	@Column(name = "gabinete", nullable = true)
	private Boolean gabinete;
	
	@Column(name = "colegiado", nullable = true)
	private Integer colegiado;
	
	@Column(name = "setor", nullable = true)
	private Integer setor;
	
	@Column(name = "setorRecurso", nullable = true)
	private Integer setorRecurso;

	@OneToOne
	@JoinColumn(name = "numeroProcesso")
	Processo processo;

	public Long getNumeroProcesso() {
		return numeroProcesso;
	}

	public void setNumeroProcesso(Long numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

	public Long getSobrestado() {
		return sobrestado;
	}

	public void setSobrestado(Long sobrestado) {
		this.sobrestado = sobrestado;
	}

	public Boolean getArquivado() {
		return arquivado;
	}

	public void setArquivado(Boolean arquivado) {
		this.arquivado = arquivado;
	}

	public Boolean getRecurso() {
		return recurso;
	}

	public void setRecurso(Boolean recurso) {
		this.recurso = recurso;
	}

	public Boolean getRecursoAtivo() {
		return recursoAtivo;
	}

	public void setRecursoAtivo(Boolean recursoAtivo) {
		this.recursoAtivo = recursoAtivo;
	}

	public Boolean getRecursoArquivado() {
		return recursoArquivado;
	}

	public void setRecursoArquivado(Boolean recursoArquivado) {
		this.recursoArquivado = recursoArquivado;
	}

	public Long getConclusao() {
		return conclusao;
	}

	public void setConclusao(Long conclusao) {
		this.conclusao = conclusao;
	}

	public Integer getVistas() {
		return vistas;
	}

	public void setVistas(Integer vistas) {
		this.vistas = vistas;
	}

	public Boolean getGabinete() {
		return gabinete;
	}

	public void setGabinete(Boolean gabinete) {
		this.gabinete = gabinete;
	}

	public Integer getColegiado() {
		return colegiado;
	}

	public void setColegiado(Integer colegiado) {
		this.colegiado = colegiado;
	}

	public Integer getSetor() {
		return setor;
	}

	public void setSetor(Integer setor) {
		this.setor = setor;
	}

	public Integer getSetorRecurso() {
		return setorRecurso;
	}

	public void setSetorRecurso(Integer setorRecurso) {
		this.setorRecurso = setorRecurso;
	}

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	/*@ManyToOne
	@JoinColumn(name = "sobrestado")
	SuspensaoProcesso suspensaoProcesso;

	@ManyToOne
	@JoinColumn(name = "conclusao")
	Conclusao conclusao;

	@ManyToOne
	@JoinColumn(name = "vistas")
	VistasMP vistasMP;

	@ManyToOne
	@JoinColumn(name = "colegiado")
	Recurso recurso;

	@ManyToOne
	@JoinColumn(name = "setor")
	Setor setor;

	@ManyToOne
	@JoinColumn(name = "setorRecurso")
	Setor setorRecurso;*/
	
	
}
