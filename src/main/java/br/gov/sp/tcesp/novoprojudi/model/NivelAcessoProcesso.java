package br.gov.sp.tcesp.novoprojudi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nivel_acesso_processo")
public class NivelAcessoProcesso implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6307236717465542345L;

	@Id
	@Column(name = "idNivelAcesso")
    private Integer idNivelAcesso;
	
	@Column(name = "indAtivo")
    private Integer indAtivo;
    
	@Column(name = "dscNivelAcesso")
    private String dscNivelAcesso;
    
	@Column(name = "dscAltNivelAcesso")
    private String dscAltNivelAcesso;
    
	@Column(name = "txtObs")
    private String txtObs;
    
	@Column(name = "numOrdenacao")
    private Integer numOrdenacao;
	
	@Column(name = "indOptFlags")
	private Integer indOptFlags;
	
	@Column(name = "indRelatorSetLst")
    private Integer indRelatorSetLst;
    
	@Column(name = "indRelatorSetVer")
    private Integer indRelatorSetVer;
    
	@Column(name = "indRelatorSetDld")
    private Integer indRelatorSetDld;
    
	@Column(name = "indRelatorGabLst")
    private Integer indRelatorGabLst;
    
	@Column(name = "indRelatorGabVer")
    private Integer indRelatorGabVer;
    
	@Column(name = "indRelatorGabDld")
    private Integer indRelatorGabDld;
    
	@Column(name = "indOutroGabLst")
    private Integer indOutroGabLst;
    
	@Column(name = "indOutroGabVer")
    private Integer indOutroGabVer;
    
	@Column(name = "indOutroGabDld")
    private Integer indOutroGabDld;
    
	@Column(name = "indInternoCargaLst")
    private Integer indInternoCargaLst;
    
	@Column(name = "indInternoCargaVer")
    private Integer indInternoCargaVer;
    
	@Column(name = "indInternoCargaDld")
    private Integer indInternoCargaDld;
    
	@Column(name = "indInternoLst")
    private Integer indInternoLst;
    
	@Column(name = "indInternoVer")
    private Integer indInternoVer;
    
	@Column(name = "indInternoDld")
    private Integer indInternoDld;
    
	@Column(name = "indUsrVistasLst")
    private Integer indUsrVistasLst;
    
	@Column(name = "indUsrVistasVer")
    private Integer indUsrVistasVer;
    
	@Column(name = "indUsrVistasDld")
    private Integer indUsrVistasDld;
    
	@Column(name = "indParteAutoraLst")
    private Integer indParteAutoraLst;
    
	@Column(name = "indParteAutoraVer")
    private Integer indParteAutoraVer;
    
	@Column(name = "indParteAutoraDld")
    private Integer indParteAutoraDld;
    
	@Column(name = "indParteAutoraMov")
    private Integer indParteAutoraMov;
    
	@Column(name = "indParteProcLst")
    private Integer indParteProcLst;
    
	@Column(name = "indParteProcVer")
    private Integer indParteProcVer;
    
	@Column(name = "indParteProcDld")
    private Integer indParteProcDld;
    
	@Column(name = "indParteProcMov")
    private Integer indParteProcMov;
    
	@Column(name = "indParteGeralLst")
    private Integer indParteGeralLst;
    
	@Column(name = "indParteGeralVer")
    private Integer indParteGeralVer;
    
	@Column(name = "indParteGeralDld")
    private Integer indParteGeralDld;
    
	@Column(name = "indParteGeralMov")
    private Integer indParteGeralMov;
    
	@Column(name = "indParteVistaLst")
    private Integer indParteVistaLst;
    
	@Column(name = "indParteVistaVer")
    private Integer indParteVistaVer;
    
	@Column(name = "indParteVistaDld")
    private Integer indParteVistaDld;
    
	@Column(name = "indAdvParteAutLst")
    private Integer indAdvParteAutLst;
    
	@Column(name = "indAdvParteAutVer")
    private Integer indAdvParteAutVer;
    
	@Column(name = "indAdvParteAutDld")
    private Integer indAdvParteAutDld;
    
	@Column(name = "indAdvParteAutMov")
    private Integer indAdvParteAutMov;
    
	@Column(name = "indAdvProcLst")
    private Integer indAdvProcLst;
    
	@Column(name = "indAdvProcVer")
    private Integer indAdvProcVer;
    
	@Column(name = "indAdvProcDld")
    private Integer indAdvProcDld;
    
	@Column(name = "indAdvProcMov")
    private Integer indAdvProcMov;
    
	@Column(name = "indAdvGeralLst")
    private Integer indAdvGeralLst;
    
	@Column(name = "indAdvGeralVer")
    private Integer indAdvGeralVer;
    
	@Column(name = "indAdvGeralDld")
    private Integer indAdvGeralDld;
    
	@Column(name = "indAdvGeralMov")
    private Integer indAdvGeralMov;
    
	@Column(name = "indAdvVistaLst")
    private Integer indAdvVistaLst;
    
	@Column(name = "indAdvVistaVer")
    private Integer indAdvVistaVer;
    
	@Column(name = "indAdvVistaDld")
    private Integer indAdvVistaDld;
    
	@Column(name = "indPopulacaoLst")
    private Integer indPopulacaoLst;
    
	@Column(name = "indPopulacaoVer")
    private Integer indPopulacaoVer;
    
	@Column(name = "indPopulacaoDld")
    private Integer indPopulacaoDld;
    
	@Column(name = "indSisIntegracao")
    private Integer indSisIntegracao;
    
	@Column(name = "indSisValidacao")
    private Integer indSisValidacao;
    
	@Column(name = "indSisIndexacao")
    private Integer indSisIndexacao;
    
	@Column(name = "indSisCopiaDigital")
    private Integer indSisCopiaDigital;
    
	@Column(name = "indSisDwnldToken")
    private Integer indSisDwnldToken;
    
	@Column(name = "indSisWs")
    private Integer indSisWs;
    
	@Column(name = "indSisWsMp")
    private Integer indSisWsMp;
	
	public Integer getIdNivelAcesso() {
		return idNivelAcesso;
	}
	public void setIdNivelAcesso(Integer idNivelAcesso) {
		this.idNivelAcesso = idNivelAcesso;
	}
	public Integer getIndAtivo() {
		return indAtivo;
	}
	public void setIndAtivo(Integer indAtivo) {
		this.indAtivo = indAtivo;
	}
	public String getDscNivelAcesso() {
		return dscNivelAcesso;
	}
	public void setDscNivelAcesso(String dscNivelAcesso) {
		this.dscNivelAcesso = dscNivelAcesso;
	}
	public String getDscAltNivelAcesso() {
		return dscAltNivelAcesso;
	}
	public void setDscAltNivelAcesso(String dscAltNivelAcesso) {
		this.dscAltNivelAcesso = dscAltNivelAcesso;
	}
	public String getTxtObs() {
		return txtObs;
	}
	public void setTxtObs(String txtObs) {
		this.txtObs = txtObs;
	}
	public Integer getNumOrdenacao() {
		return numOrdenacao;
	}
	public void setNumOrdenacao(Integer numOrdenacao) {
		this.numOrdenacao = numOrdenacao;
	}
	public Integer getIndOptFlags() {
		return indOptFlags;
	}
	public void setIndOptFlags(Integer indOptFlags) {
		this.indOptFlags = indOptFlags;
	}
	public Integer getIndRelatorSetLst() {
		return indRelatorSetLst;
	}
	public void setIndRelatorSetLst(Integer indRelatorSetLst) {
		this.indRelatorSetLst = indRelatorSetLst;
	}
	public Integer getIndRelatorSetVer() {
		return indRelatorSetVer;
	}
	public void setIndRelatorSetVer(Integer indRelatorSetVer) {
		this.indRelatorSetVer = indRelatorSetVer;
	}
	public Integer getIndRelatorSetDld() {
		return indRelatorSetDld;
	}
	public void setIndRelatorSetDld(Integer indRelatorSetDld) {
		this.indRelatorSetDld = indRelatorSetDld;
	}
	public Integer getIndRelatorGabLst() {
		return indRelatorGabLst;
	}
	public void setIndRelatorGabLst(Integer indRelatorGabLst) {
		this.indRelatorGabLst = indRelatorGabLst;
	}
	public Integer getIndRelatorGabVer() {
		return indRelatorGabVer;
	}
	public void setIndRelatorGabVer(Integer indRelatorGabVer) {
		this.indRelatorGabVer = indRelatorGabVer;
	}
	public Integer getIndRelatorGabDld() {
		return indRelatorGabDld;
	}
	public void setIndRelatorGabDld(Integer indRelatorGabDld) {
		this.indRelatorGabDld = indRelatorGabDld;
	}
	public Integer getIndOutroGabLst() {
		return indOutroGabLst;
	}
	public void setIndOutroGabLst(Integer indOutroGabLst) {
		this.indOutroGabLst = indOutroGabLst;
	}
	public Integer getIndOutroGabVer() {
		return indOutroGabVer;
	}
	public void setIndOutroGabVer(Integer indOutroGabVer) {
		this.indOutroGabVer = indOutroGabVer;
	}
	public Integer getIndOutroGabDld() {
		return indOutroGabDld;
	}
	public void setIndOutroGabDld(Integer indOutroGabDld) {
		this.indOutroGabDld = indOutroGabDld;
	}
	public Integer getIndInternoCargaLst() {
		return indInternoCargaLst;
	}
	public void setIndInternoCargaLst(Integer indInternoCargaLst) {
		this.indInternoCargaLst = indInternoCargaLst;
	}
	public Integer getIndInternoCargaVer() {
		return indInternoCargaVer;
	}
	public void setIndInternoCargaVer(Integer indInternoCargaVer) {
		this.indInternoCargaVer = indInternoCargaVer;
	}
	public Integer getIndInternoCargaDld() {
		return indInternoCargaDld;
	}
	public void setIndInternoCargaDld(Integer indInternoCargaDld) {
		this.indInternoCargaDld = indInternoCargaDld;
	}
	public Integer getIndInternoLst() {
		return indInternoLst;
	}
	public void setIndInternoLst(Integer indInternoLst) {
		this.indInternoLst = indInternoLst;
	}
	public Integer getIndInternoVer() {
		return indInternoVer;
	}
	public void setIndInternoVer(Integer indInternoVer) {
		this.indInternoVer = indInternoVer;
	}
	public Integer getIndInternoDld() {
		return indInternoDld;
	}
	public void setIndInternoDld(Integer indInternoDld) {
		this.indInternoDld = indInternoDld;
	}
	public Integer getIndUsrVistasLst() {
		return indUsrVistasLst;
	}
	public void setIndUsrVistasLst(Integer indUsrVistasLst) {
		this.indUsrVistasLst = indUsrVistasLst;
	}
	public Integer getIndUsrVistasVer() {
		return indUsrVistasVer;
	}
	public void setIndUsrVistasVer(Integer indUsrVistasVer) {
		this.indUsrVistasVer = indUsrVistasVer;
	}
	public Integer getIndUsrVistasDld() {
		return indUsrVistasDld;
	}
	public void setIndUsrVistasDld(Integer indUsrVistasDld) {
		this.indUsrVistasDld = indUsrVistasDld;
	}
	public Integer getIndParteAutoraLst() {
		return indParteAutoraLst;
	}
	public void setIndParteAutoraLst(Integer indParteAutoraLst) {
		this.indParteAutoraLst = indParteAutoraLst;
	}
	public Integer getIndParteAutoraVer() {
		return indParteAutoraVer;
	}
	public void setIndParteAutoraVer(Integer indParteAutoraVer) {
		this.indParteAutoraVer = indParteAutoraVer;
	}
	public Integer getIndParteAutoraDld() {
		return indParteAutoraDld;
	}
	public void setIndParteAutoraDld(Integer indParteAutoraDld) {
		this.indParteAutoraDld = indParteAutoraDld;
	}
	public Integer getIndParteAutoraMov() {
		return indParteAutoraMov;
	}
	public void setIndParteAutoraMov(Integer indParteAutoraMov) {
		this.indParteAutoraMov = indParteAutoraMov;
	}
	public Integer getIndParteProcLst() {
		return indParteProcLst;
	}
	public void setIndParteProcLst(Integer indParteProcLst) {
		this.indParteProcLst = indParteProcLst;
	}
	public Integer getIndParteProcVer() {
		return indParteProcVer;
	}
	public void setIndParteProcVer(Integer indParteProcVer) {
		this.indParteProcVer = indParteProcVer;
	}
	public Integer getIndParteProcDld() {
		return indParteProcDld;
	}
	public void setIndParteProcDld(Integer indParteProcDld) {
		this.indParteProcDld = indParteProcDld;
	}
	public Integer getIndParteProcMov() {
		return indParteProcMov;
	}
	public void setIndParteProcMov(Integer indParteProcMov) {
		this.indParteProcMov = indParteProcMov;
	}
	public Integer getIndParteGeralLst() {
		return indParteGeralLst;
	}
	public void setIndParteGeralLst(Integer indParteGeralLst) {
		this.indParteGeralLst = indParteGeralLst;
	}
	public Integer getIndParteGeralVer() {
		return indParteGeralVer;
	}
	public void setIndParteGeralVer(Integer indParteGeralVer) {
		this.indParteGeralVer = indParteGeralVer;
	}
	public Integer getIndParteGeralDld() {
		return indParteGeralDld;
	}
	public void setIndParteGeralDld(Integer indParteGeralDld) {
		this.indParteGeralDld = indParteGeralDld;
	}
	public Integer getIndParteGeralMov() {
		return indParteGeralMov;
	}
	public void setIndParteGeralMov(Integer indParteGeralMov) {
		this.indParteGeralMov = indParteGeralMov;
	}
	public Integer getIndParteVistaLst() {
		return indParteVistaLst;
	}
	public void setIndParteVistaLst(Integer indParteVistaLst) {
		this.indParteVistaLst = indParteVistaLst;
	}
	public Integer getIndParteVistaVer() {
		return indParteVistaVer;
	}
	public void setIndParteVistaVer(Integer indParteVistaVer) {
		this.indParteVistaVer = indParteVistaVer;
	}
	public Integer getIndParteVistaDld() {
		return indParteVistaDld;
	}
	public void setIndParteVistaDld(Integer indParteVistaDld) {
		this.indParteVistaDld = indParteVistaDld;
	}
	public Integer getIndAdvParteAutLst() {
		return indAdvParteAutLst;
	}
	public void setIndAdvParteAutLst(Integer indAdvParteAutLst) {
		this.indAdvParteAutLst = indAdvParteAutLst;
	}
	public Integer getIndAdvParteAutVer() {
		return indAdvParteAutVer;
	}
	public void setIndAdvParteAutVer(Integer indAdvParteAutVer) {
		this.indAdvParteAutVer = indAdvParteAutVer;
	}
	public Integer getIndAdvParteAutDld() {
		return indAdvParteAutDld;
	}
	public void setIndAdvParteAutDld(Integer indAdvParteAutDld) {
		this.indAdvParteAutDld = indAdvParteAutDld;
	}
	public Integer getIndAdvParteAutMov() {
		return indAdvParteAutMov;
	}
	public void setIndAdvParteAutMov(Integer indAdvParteAutMov) {
		this.indAdvParteAutMov = indAdvParteAutMov;
	}
	public Integer getIndAdvProcLst() {
		return indAdvProcLst;
	}
	public void setIndAdvProcLst(Integer indAdvProcLst) {
		this.indAdvProcLst = indAdvProcLst;
	}
	public Integer getIndAdvProcVer() {
		return indAdvProcVer;
	}
	public void setIndAdvProcVer(Integer indAdvProcVer) {
		this.indAdvProcVer = indAdvProcVer;
	}
	public Integer getIndAdvProcDld() {
		return indAdvProcDld;
	}
	public void setIndAdvProcDld(Integer indAdvProcDld) {
		this.indAdvProcDld = indAdvProcDld;
	}
	public Integer getIndAdvProcMov() {
		return indAdvProcMov;
	}
	public void setIndAdvProcMov(Integer indAdvProcMov) {
		this.indAdvProcMov = indAdvProcMov;
	}
	public Integer getIndAdvGeralLst() {
		return indAdvGeralLst;
	}
	public void setIndAdvGeralLst(Integer indAdvGeralLst) {
		this.indAdvGeralLst = indAdvGeralLst;
	}
	public Integer getIndAdvGeralVer() {
		return indAdvGeralVer;
	}
	public void setIndAdvGeralVer(Integer indAdvGeralVer) {
		this.indAdvGeralVer = indAdvGeralVer;
	}
	public Integer getIndAdvGeralDld() {
		return indAdvGeralDld;
	}
	public void setIndAdvGeralDld(Integer indAdvGeralDld) {
		this.indAdvGeralDld = indAdvGeralDld;
	}
	public Integer getIndAdvGeralMov() {
		return indAdvGeralMov;
	}
	public void setIndAdvGeralMov(Integer indAdvGeralMov) {
		this.indAdvGeralMov = indAdvGeralMov;
	}
	public Integer getIndAdvVistaLst() {
		return indAdvVistaLst;
	}
	public void setIndAdvVistaLst(Integer indAdvVistaLst) {
		this.indAdvVistaLst = indAdvVistaLst;
	}
	public Integer getIndAdvVistaVer() {
		return indAdvVistaVer;
	}
	public void setIndAdvVistaVer(Integer indAdvVistaVer) {
		this.indAdvVistaVer = indAdvVistaVer;
	}
	public Integer getIndAdvVistaDld() {
		return indAdvVistaDld;
	}
	public void setIndAdvVistaDld(Integer indAdvVistaDld) {
		this.indAdvVistaDld = indAdvVistaDld;
	}
	public Integer getIndPopulacaoLst() {
		return indPopulacaoLst;
	}
	public void setIndPopulacaoLst(Integer indPopulacaoLst) {
		this.indPopulacaoLst = indPopulacaoLst;
	}
	public Integer getIndPopulacaoVer() {
		return indPopulacaoVer;
	}
	public void setIndPopulacaoVer(Integer indPopulacaoVer) {
		this.indPopulacaoVer = indPopulacaoVer;
	}
	public Integer getIndPopulacaoDld() {
		return indPopulacaoDld;
	}
	public void setIndPopulacaoDld(Integer indPopulacaoDld) {
		this.indPopulacaoDld = indPopulacaoDld;
	}
	public Integer getIndSisIntegracao() {
		return indSisIntegracao;
	}
	public void setIndSisIntegracao(Integer indSisIntegracao) {
		this.indSisIntegracao = indSisIntegracao;
	}
	public Integer getIndSisValidacao() {
		return indSisValidacao;
	}
	public void setIndSisValidacao(Integer indSisValidacao) {
		this.indSisValidacao = indSisValidacao;
	}
	public Integer getIndSisIndexacao() {
		return indSisIndexacao;
	}
	public void setIndSisIndexacao(Integer indSisIndexacao) {
		this.indSisIndexacao = indSisIndexacao;
	}
	public Integer getIndSisCopiaDigital() {
		return indSisCopiaDigital;
	}
	public void setIndSisCopiaDigital(Integer indSisCopiaDigital) {
		this.indSisCopiaDigital = indSisCopiaDigital;
	}
	public Integer getIndSisDwnldToken() {
		return indSisDwnldToken;
	}
	public void setIndSisDwnldToken(Integer indSisDwnldToken) {
		this.indSisDwnldToken = indSisDwnldToken;
	}
	public Integer getIndSisWs() {
		return indSisWs;
	}
	public void setIndSisWs(Integer indSisWs) {
		this.indSisWs = indSisWs;
	}
	public Integer getIndSisWsMp() {
		return indSisWsMp;
	}
	public void setIndSisWsMp(Integer indSisWsMp) {
		this.indSisWsMp = indSisWsMp;
	}
    
    
}
