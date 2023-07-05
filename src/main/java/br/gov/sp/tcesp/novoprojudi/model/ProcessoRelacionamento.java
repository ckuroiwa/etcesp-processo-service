package br.gov.sp.tcesp.novoprojudi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "processo_relacionamento")
public class ProcessoRelacionamento implements Serializable {

	    private static final long serialVersionUID = 2975252898315965956L;

	    @Id 
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Long id;
	 
	    @Column(name = "principal", insertable = false, updatable = false)
	    private Long principal;
	 
	    @Column(name = "relacionado", insertable = false, updatable = false)
	    private Long relacionado;
	 
	    @Column(name = "tiporelacao")
	    private Integer tiporelacao;
	 
	    @Column(name = "inicio")
	    private Date inicio;
	 
	    @Column(name = "fim")
	    private Date fim;
	 
	    @Column(name = "loginini")
	    private String loginini;
	 
	    @Column(name = "loginfim")
	    private String loginfim;
	 
	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "principal", referencedColumnName = "numeroprocesso")
	    private Processo processoPrincipal;
	 
	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "relacionado", referencedColumnName = "numeroprocesso")
	    private Processo processoRelacionado;

	    /*@ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "loginIni", referencedColumnName = "login")
	    private Logon logonIni;*/
	 
	    /*@ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "loginFim", referencedColumnName = "login")
	    private Logon logonFim;*/
	 
	    /*@ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "tipoRelacao", referencedColumnName = "id")
	    private ProcessoTipoRelacionamento processoTipoRelacionamento;*/

	    public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getPrincipal() {
			return principal;
		}

		public void setPrincipal(Long principal) {
			this.principal = principal;
		}

		public Long getRelacionado() {
			return relacionado;
		}

		public void setRelacionado(Long relacionado) {
			this.relacionado = relacionado;
		}

		public Integer getTiporelacao() {
			return tiporelacao;
		}

		public void setTiporelacao(Integer tiporelacao) {
			this.tiporelacao = tiporelacao;
		}

		public Date getInicio() {
			return inicio;
		}

		public void setInicio(Date inicio) {
			this.inicio = inicio;
		}

		public Date getFim() {
			return fim;
		}

		public void setFim(Date fim) {
			this.fim = fim;
		}


		public String getLoginini() {
			return loginini;
		}

		public void setLoginini(String loginini) {
			this.loginini = loginini;
		}

		public String getLoginfim() {
			return loginfim;
		}

		public void setLoginfim(String loginfim) {
			this.loginfim = loginfim;
		}

		public Processo getProcessoPrincipal() {
			return processoPrincipal;
		}

		public void setProcessoPrincipal(Processo processoPrincipal) {
			this.processoPrincipal = processoPrincipal;
		}

		public Processo getProcessoRelacionado() {
			return processoRelacionado;
		}

		public void setProcessoRelacionado(Processo processoRelacionado) {
			this.processoRelacionado = processoRelacionado;
		}
	 
	    
}
