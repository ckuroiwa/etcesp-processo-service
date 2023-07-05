package br.gov.sp.tcesp.novoprojudi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@Entity
@Table(name = "tipo_acao")
public class TipoAcao implements Serializable {

	private static final long serialVersionUID = 5429927531883174192L;

	@Id
	@Column(name = "codtipoacao")
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy="increment")
	private Long codtipoacao;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "cod_tipo_acao")
	private Long codTipoAcao;
	
	@Column(name = "tipo")
	private Long tipo;
	
	@Column(name = "indicador_agravo_instrumento")
	private Long indicadorAgravoInstrumento;
	
	@Column(name = "dataexclusao")
	private Date dataExclusao;
	
	@Column(name = "codnatureza") 
	private Integer codNatureza;
	
	@Column(name = "codtipoacaopenal")
	private Integer codTipoAcaoPenal;
	
	@Column(name = "codtipoclasse")
	private Integer codTipoClasse;
	
	@Column(name = "indicador_competencia_turma")
	private Boolean indicadorCompetenciaTurma;
	
	@Column(name = "cod_fase_processual")
	private Integer codFaseProcessual;
	
	@Column(name = "filhounico")
	private Boolean filhoUnico = false;
	
	@Column(name = "filhounicoporexercicio")
	private Boolean filhoUnicoPorExercicio = false;
	
	@Column(name = "autuardevolver")
	private Boolean autuarDevolver = false;
	
	@Column(name = "indacompanhamentoexecucao")
	private Integer indAcompanhamentoExecucao = 0;
	
	@Column(name = "competenciajulgamento")
	private Integer competenciaJulgamento;
	
	@Column(name = "indsigiloso")
	private Integer indSigiloso = 0;
	
	@Column(name = "indpermiteautosproprios")
	private Boolean indPermiteAutosProprios = false;
	
	@Column(name = "indpermitefilhos")
	private Boolean indPermiteFilhos = true;
	
	@Column(name = "indpermiterefinicial")
	private Integer indPermiteRefInicial = 0;
	
	@Column(name = "indpiloto")
	private Boolean indPiloto = false;
	
	@Column(name = "indpermiterecursoacao")
	private Integer indPermiteRecursoAcao = 3;
	
	@OneToOne(optional=true, fetch = FetchType.EAGER)
	@JoinColumn(name = "seqCategoria")
	@NotFound(action = NotFoundAction.IGNORE)
    private CnjClasseCategoria cnjClasseCategoria;

	public Long getCodtipoacao() {
		return codtipoacao;
	}

	public void setCodtipoacao(Long codtipoacao) {
		this.codtipoacao = codtipoacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getCodTipoAcao() {
		return codTipoAcao;
	}

	public void setCodTipoAcao(Long codTipoAcao) {
		this.codTipoAcao = codTipoAcao;
	}

	public Long getTipo() {
		return tipo;
	}

	public void setTipo(Long tipo) {
		this.tipo = tipo;
	}

	public Long getIndicadorAgravoInstrumento() {
		return indicadorAgravoInstrumento;
	}

	public void setIndicadorAgravoInstrumento(Long indicadorAgravoInstrumento) {
		this.indicadorAgravoInstrumento = indicadorAgravoInstrumento;
	}

	public Date getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(Date dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

	public Integer getCodNatureza() {
		return codNatureza;
	}

	public void setCodNatureza(Integer codNatureza) {
		this.codNatureza = codNatureza;
	}

	public Integer getCodTipoAcaoPenal() {
		return codTipoAcaoPenal;
	}

	public void setCodTipoAcaoPenal(Integer codTipoAcaoPenal) {
		this.codTipoAcaoPenal = codTipoAcaoPenal;
	}

	public Integer getCodTipoClasse() {
		return codTipoClasse;
	}

	public void setCodTipoClasse(Integer codTipoClasse) {
		this.codTipoClasse = codTipoClasse;
	}

	public Boolean getIndicadorCompetenciaTurma() {
		return indicadorCompetenciaTurma;
	}

	public void setIndicadorCompetenciaTurma(Boolean indicadorCompetenciaTurma) {
		this.indicadorCompetenciaTurma = indicadorCompetenciaTurma;
	}

	public Integer getCodFaseProcessual() {
		return codFaseProcessual;
	}

	public void setCodFaseProcessual(Integer codFaseProcessual) {
		this.codFaseProcessual = codFaseProcessual;
	}

	public Boolean getFilhoUnico() {
		return filhoUnico;
	}

	public void setFilhoUnico(Boolean filhoUnico) {
		this.filhoUnico = filhoUnico;
	}

	public Boolean getFilhoUnicoPorExercicio() {
		return filhoUnicoPorExercicio;
	}

	public void setFilhoUnicoPorExercicio(Boolean filhoUnicoPorExercicio) {
		this.filhoUnicoPorExercicio = filhoUnicoPorExercicio;
	}

	public Boolean getAutuarDevolver() {
		return autuarDevolver;
	}

	public void setAutuarDevolver(Boolean autuarDevolver) {
		this.autuarDevolver = autuarDevolver;
	}

	public Integer getIndAcompanhamentoExecucao() {
		return indAcompanhamentoExecucao;
	}

	public void setIndAcompanhamentoExecucao(Integer indAcompanhamentoExecucao) {
		this.indAcompanhamentoExecucao = indAcompanhamentoExecucao;
	}

	public Integer getCompetenciaJulgamento() {
		return competenciaJulgamento;
	}

	public void setCompetenciaJulgamento(Integer competenciaJulgamento) {
		this.competenciaJulgamento = competenciaJulgamento;
	}

	public Integer getIndSigiloso() {
		return indSigiloso;
	}

	public void setIndSigiloso(Integer indSigiloso) {
		this.indSigiloso = indSigiloso;
	}

	public Boolean getIndPermiteAutosProprios() {
		return indPermiteAutosProprios;
	}

	public void setIndPermiteAutosProprios(Boolean indPermiteAutosProprios) {
		this.indPermiteAutosProprios = indPermiteAutosProprios;
	}

	public Boolean getIndPermiteFilhos() {
		return indPermiteFilhos;
	}

	public void setIndPermiteFilhos(Boolean indPermiteFilhos) {
		this.indPermiteFilhos = indPermiteFilhos;
	}

	public Integer getIndPermiteRefInicial() {
		return indPermiteRefInicial;
	}

	public void setIndPermiteRefInicial(Integer indPermiteRefInicial) {
		this.indPermiteRefInicial = indPermiteRefInicial;
	}

	public Boolean getIndPiloto() {
		return indPiloto;
	}

	public void setIndPiloto(Boolean indPiloto) {
		this.indPiloto = indPiloto;
	}

	public Integer getIndPermiteRecursoAcao() {
		return indPermiteRecursoAcao;
	}

	public void setIndPermiteRecursoAcao(Integer indPermiteRecursoAcao) {
		this.indPermiteRecursoAcao = indPermiteRecursoAcao;
	}

	public CnjClasseCategoria getCnjClasseCategoria() {
		return cnjClasseCategoria;
	}

	public void setCnjClasseCategoria(CnjClasseCategoria cnjClasseCategoria) {
		this.cnjClasseCategoria = cnjClasseCategoria;
	}

	    	
}