package br.gov.sp.tcesp.novoprojudi.util; 

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

//import org.apache.torque.TorqueException;

//import projudi.beans.PautaHorariosIF;
//import projudi.service.ParametrosDataService;

/**
 * Esta classe contém métodos para manipulação, construção visualização,
 * ou representação de datas para os eventos que podem ocorrer no PROJUDI
 *
 * @author Leandro de Lima Lira
 * @author André Luis Cavalcanti Moreira
 *
 */

public class DiaHoraEventos implements Comparable {

	private GregorianCalendar calenGreg;

	private Integer dia;
	private Integer mes;
	private Integer ano;
	private Integer hora;
	private Integer minuto;
	private Integer segundo;
	// Obs: se a variável dataFaixaStr estiver definida, ex: MES_INI(-1), ela
	// terá precedência sobre os valores iniciais acima
	private String dataFaixaStr = null;
	private Boolean isDataFaixaStrModificado = true;

	/**
	 * Cria um DiaHoraEventos com a hora atual
	 *
	 */
	public DiaHoraEventos() {
		this.calenGreg = new GregorianCalendar();
		atualizarAtributos();
	}

	/**
	 * Cria um DiaHoraEventos com a hora fornecida
	 * @param date a hora relativa
	 */
	public DiaHoraEventos(Date date) {
		this.calenGreg = new GregorianCalendar();
		this.setData(date);
		atualizarAtributos();
	}

	/**
	 * Verifica se dataFaixaStr (variáveis, ex: "MES_INI(-1)") foi alterado e em caso 
	 * afirmativo, tenta fazer o parse dele, redefinindo as propriedades
	 * de acordo com a data informada
	 */
	private void parseDataFaixaStr(Date dataBase) {
		if(isDataFaixaStrModificado) {
			this.isDataFaixaStrModificado = false;
			if (dataFaixaStr!=null && !dataFaixaStr.trim().isEmpty()) {
				DiaHoraEventos diaTemp = null; //ParametrosDataService.parser(dataFaixaStr, dataBase);
				if(diaTemp!=null) {
					this.setData(diaTemp.getDate());
					atualizarAtributos();
				} 
			} 
		}
	}

	/**
	 * Verifica se dataFaixaStr (variáveis, ex: "MES_INI(-1)") foi alterado e em caso 
	 * afirmativo, tenta fazer o parse dele, redefinindo as propriedades
	 * de acordo com a data atual do objeto
	 */
	private void parseDataFaixaStr() {
		parseDataFaixaStr(new Date(this.calenGreg.getTimeInMillis()));
	}

	/**
	 * Faz o parse de dataFaixaStr (variáveis, ex: "MES_INI(-1)") utilizando a 
	 * DATA BASE ATUAL (new Date())
	 */
	private void parseDataFaixaStrDataBaseAgora() {
		parseDataFaixaStr(null);
	}

	/*
	 * Método utilizado para atualizar os atributos desta classe (ano, mes, dia,
	 * hora, minuto e segundo), sempre que os objetos de data forem atualizados.
	 * @author Renato Marotta = TJMG
	 */
	private void atualizarAtributos() {

		this.ano = this.calenGreg.get(GregorianCalendar.YEAR);
		this.mes = this.calenGreg.get(GregorianCalendar.MONTH) + 1;
		this.dia = this.calenGreg.get(GregorianCalendar.DAY_OF_MONTH);
		this.hora = this.calenGreg.get(GregorianCalendar.HOUR_OF_DAY);
		this.minuto = this.calenGreg.get(GregorianCalendar.MINUTE);
		this.segundo = this.calenGreg.get(GregorianCalendar.SECOND);

	}

	/**
	 * Altera a hora deste DiaHoraEventos
	 * @param data a hora relativa
	 */
	public void setData(Date data) {
		this.calenGreg.setTime(data);
		atualizarAtributos();
	}

	/**
	 * Pega o número de milissegundos decorridos desde 1º de janeiro de 1970
	 * às 00:00:00 até a hora que este DiaHoraEventos representa
	 *
	 * @return o valor em milissegundos
	 */
	public long getMilis() {
		parseDataFaixaStr();
		return this.calenGreg.getTimeInMillis();
	}

	/**
	 * Converte o TEMPO passado para o formato de horas, minutos e segundos no
	 * formato HH:MM:SS
	 * @param tempoMilisegundos tempo em milisegundos (nao importando a data atual)
	 * @return tempo formatado HH:MM:SS
	 */
	public static String formataTempoHoraMinutosSegundos(long tempoMilisegundos){
		long tempoSegundos = tempoMilisegundos / 1000;
		long tempoMinutos = tempoMilisegundos / 60000;

		return String.format("%02d:%02d:%02d", tempoMinutos / 60, tempoMinutos % 60, tempoSegundos % 60);
	}

	/**
	 * Converte uma data para uma representação em String no formato "1ª de janeiro de 1970 às 00:00"
	 * @param date a data a ser convertida
	 * @return uma String com a representação
	 */
	public static String converteFormatoMinutos(Date date) {
		DiaHoraEventos diaTemp = new DiaHoraEventos();
		diaTemp.setData(date);
		return diaTemp.diaHoraMinutos();
	}

	/**
	 * Converte uma data para uma representação em String no formato "01/01/1970 às 00:00"
	 * @param date a data a ser convertida
	 * @return uma String com a representação
	 */
	public static String converteFormatoMinutosCurto(Date date) {
		DiaHoraEventos diaTemp = new DiaHoraEventos();
		diaTemp.setData(date);
		return diaTemp.diaHorario();
	}

	/**
	 * Converte uma data para uma representação em String no formato "1ª de janeiro de 1970 às 00:00:00"
	 * @param date a data a ser convertida
	 * @return uma String com a representação
	 */
	public static String converteFormatoSegundos(Date date) {
		DiaHoraEventos diaTemp = new DiaHoraEventos();
		diaTemp.setData(date);
		return diaTemp.diaHoraSegundos();
	}

	/**
	 * Converte uma data para uma representação em String no formato "1ª de janeiro de 1970"
	 * @param date a data a ser convertida
	 * @return uma String com a representação
	 */
	public static String converteFormatoDataNacional(Date date) {
		DiaHoraEventos diaTemp = new DiaHoraEventos();
		diaTemp.setData(date);
		return diaTemp.dataNacional();
	}

	/**
	 * Converte uma data para uma representação em String no formato "01/01/1970"
	 * @param date a data a ser convertida
	 * @return uma String com a representação
	 */
	public static String converteFormatoDataNacionalCurto(Date date) {
		if(date!=null){
			DiaHoraEventos diaTemp = new DiaHoraEventos();
			diaTemp.setData(date);
			return diaTemp.dataNacionalCurto();
		} else{
			return "";
		}

	}

	/**
	 * Criado por Viviane dia 06/05/2008 para converter uma data para 
	 * formato "01/01/1970"
	 * @param date a data a ser convertida
	 * @return uma String com a representação
	 */
	public static String converteFormatoDataNacionalMedio(Date date) {
		if(date == null)
			return "";
		DiaHoraEventos diaTemp = new DiaHoraEventos();
		diaTemp.setData(date);
		return diaTemp.getDataPadrao();
	}

	/**
	 * Criado para converter uma data para 
	 * formato "01/01/1970 11:22"
	 * @param date a data a ser convertida
	 * @return uma String com a representação
	 */
	public static String converteFormatoDataHoraNacional(Date date) {
		if(date == null)
			return "";
		DiaHoraEventos diaTemp = new DiaHoraEventos();
		diaTemp.setData(date);
		return diaTemp.getDataHoraPadrao();
	}

	/**
	 * Criado por Viviane dia 06/05/2007
	 * Converte a data deste DiaHoraEventos para uma representação em String no formato "01/01/1970"
	 * @return uma String com a representação
	 * @deprecated Recomendo utilizar o método getDataPadrao()
	 */
	public String dataNacionalMedio() {
		return DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale("pt", "BR")).format(this.getDate());
	}

	/**
	 * Converte a data deste DiaHoraEventos para uma representação em String no formato "01/01/1970"
	 * @return uma String com a representação
	 * Recomendo utilizar o método getDataPadrao()
	 */
	public String dataNacionalCurto() {
		return DateFormat.getDateInstance(DateFormat.SHORT, new Locale("pt", "BR")).format(this.getDate());
	}

	/**
	 * Converte a data deste DiaHoraEventos para uma representação em String no formato "1ª de janeiro de 1970"
	 * @return uma String com a representação
	 * Recomendo utilizar o método getDataExtenso()
	 */
	public String dataNacional() {
		return DateFormat.getDateInstance(DateFormat.LONG, new Locale("pt", "BR")).format(this.getDate());
	}

	/**
	 * Converte a data deste DiaHoraEventos para uma representação em String no formato "1ª de janeiro de 1970 às 00:00:00"
	 * @return uma String com a representação
	 */
	public String diaHoraSegundos() {
		return DateFormat.getDateInstance(DateFormat.LONG, new Locale("pt", "BR")).format(this.getDate()) + " às " + DateFormat.getTimeInstance(DateFormat.MEDIUM, new Locale("pt", "BR")).format(this.getDate());
	}

	/**
	 * Converte a data deste DiaHoraEventos para uma representação em String no formato "1ª de janeiro de 1970 às 00:00"
	 * @return uma String com a representação
	 */
	public String diaHoraMinutos() {
		return DateFormat.getDateInstance(DateFormat.LONG, new Locale("pt", "BR")).format(this.getDate()) + " às " + DateFormat.getTimeInstance(DateFormat.SHORT, new Locale("pt", "BR")).format(this.getDate());
	}

	public String getDiaHoraMinutos() {
		return diaHoraMinutos();
	}

	/**
	 * Converte a data deste DiaHoraEventos para uma representação em String no formato "01/01/1970 às 00:00"
	 * @return uma String com a representação
	 */
	public String diaHorario() {
		return DateFormat.getDateInstance(DateFormat.SHORT, new Locale("pt", "BR")).format(this.getDate()) + " às " + DateFormat.getTimeInstance(DateFormat.SHORT, new Locale("pt", "BR")).format(this.getDate());
	}

	/**
	 * Pega o ano deste DiaHoraEventos
	 * @return o ano
	 */
	public int getAno() {
		parseDataFaixaStr();
		return this.calenGreg.get(GregorianCalendar.YEAR);
	}

	/**
	 * Atualiza o ano deste DiaHoraEventos
	 * @param novoAno
	 */
	public void setAno(int novoAno) {
		this.calenGreg.set(GregorianCalendar.YEAR, novoAno);
		this.ano = novoAno;
	}

	/**
	 * Atualiza o mês deste DiaHoraEventos
	 * @param novoMes
	 */
	public void setMes(int novoMes) {
		this.calenGreg.set(GregorianCalendar.MONTH, --novoMes);
		this.mes = novoMes;
	}

	/**
	 * Pega o mês deste DiaHoraEventos
	 * @return o mês
	 */
	public int getMes() {
		parseDataFaixaStr();
		return this.calenGreg.get(GregorianCalendar.MONTH) + 1;
	}

	/**
	 * Pega o dia deste DiaHoraEventos
	 * @return o dia
	 */
	public int getDia() {
		parseDataFaixaStr();
		return this.calenGreg.get(GregorianCalendar.DAY_OF_MONTH);
	}

	/**
	 * Atualiza o dia deste DiaHoraEventos
	 * @param novoDia
	 */
	public void setDia(int novoDia) {
		this.calenGreg.set(GregorianCalendar.DAY_OF_MONTH, novoDia);
		this.dia = novoDia;
	}

	/**
	 * Pega a hora deste DiaHoraEventos
	 * @return a hora
	 */
	public int getHora() {
		parseDataFaixaStr();
		return this.calenGreg.get(GregorianCalendar.HOUR_OF_DAY);
	}

	/**
	 * Atualiza a hora deste DiaHoraEventos
	 * @param novaHora
	 */
	public void setHora(int novaHora) {
		this.calenGreg.set(GregorianCalendar.HOUR_OF_DAY, novaHora);
		this.hora = novaHora;
	}

	/**
	 * Pega os minutos deste DiaHoraEventos
	 * @return os minutos
	 */
	public int getMinutos() {
		parseDataFaixaStr();
		return this.calenGreg.get(GregorianCalendar.MINUTE);
	}

	/**
	 * Atualiza os minutos deste DiaHoraEventos
	 * @param novoMinuto
	 */
	public void setMinuto(int novoMinuto) {
		this.calenGreg.set(GregorianCalendar.MINUTE, novoMinuto);
		this.minuto = novoMinuto;
	}

	/**
	 * Pega os segundos deste DiaHoraEventos
	 * @return os segundos
	 */
	public int getSegundo() {
		parseDataFaixaStr();
		return this.calenGreg.get(GregorianCalendar.SECOND);
	}

	/**
	 * Atualiza os segundos deste DiaHoraEventos
	 * @param novoSegundo
	 */
	public void setSegundo(int novoSegundo) {
		this.calenGreg.set(GregorianCalendar.SECOND, novoSegundo);
		this.segundo = novoSegundo;
	}

	/**
	 * Atualiza os misissegundos deste DiaHoraEventos
	 * @param minissegundos
	 */
	public void setMiliSegundos(int minissegundos) {
		this.calenGreg.set(GregorianCalendar.MILLISECOND, minissegundos);
	}

	/**
	 * Pega o calendário associado a este DiaHoraEventos
	 * @return um Calendário Gregoriano
	 */
	public GregorianCalendar getCalenGreg() {
		parseDataFaixaStr();
		return calenGreg;
	}

	/**
	 * Pega a data associada a este DiaHoraEventos
	 * @return
	 */
	public Date getDate() {
		parseDataFaixaStr();
		return new Date(this.getMilis());
	}

	/**
	 * Adiciona minutos à data associada a este DiaHoraEventos
	 * @param minutosAAcrescentar a quantidade de minutos a ser acrescentada
	 */
	public void addMinutos(int minutosAAcrescentar) {
		this.calenGreg.add(GregorianCalendar.MINUTE, minutosAAcrescentar);
		atualizarAtributos();
	}

	/**
	 * Adiciona milisegundos à data associada a este DiaHoraEventos
	 * @param milisegundosAAcrescentar a quantidade de milisegundos a ser acrescentada
	 */
	public void addMilisegundos(int milisegundosAAcrescentar) {
		this.calenGreg.add(GregorianCalendar.MILLISECOND, milisegundosAAcrescentar);
		atualizarAtributos();
	}

	/**
	 * Adiciona dias à data associada a este DiaHoraEventos
	 * @param diasAAcrescentar a quantidade de dias a ser acrescentada
	 */
	public void addDias(int diasAAcrescentar) {
		this.calenGreg.add(GregorianCalendar.DATE, diasAAcrescentar);
		atualizarAtributos();
	}

	/**
	 * Adiciona meses à data associada a este DiaHoraEventos
	 * @param mesesAAcrescentar a quantidade de meses a ser acrescentada
	 */
	public DiaHoraEventos addMeses(int mesesAAcrescentar) {
		this.calenGreg.add(GregorianCalendar.MONTH, mesesAAcrescentar);
		atualizarAtributos();
		return this;
	}

	/**
	 * Subtrai dias à data associada a este DiaHoraEventos
	 * @param diasASubtrair a quantidade de dias a ser subtraida
	 */
	public void subDias(int diasASubtrair) {
		this.calenGreg.add(GregorianCalendar.DATE, -diasASubtrair);
		atualizarAtributos();
	}

	/**
	 * Verifica se uma data é deste mês
	 * @param data a data a ser verificada
	 * @return true se a data é deste mês
	 */
	public static boolean ehDoMesAtual(Date data) {
		DiaHoraEventos hoje = new DiaHoraEventos(new Date());
		DiaHoraEventos teste = new DiaHoraEventos(data);
		return (hoje.getMes() == teste.getMes()) && (hoje.getAno() == teste.getAno());
	}

	/**
	 * Retornar se a data passada como parâmetro é do mesmo dia (ano, mes e dia)
	 * @param data É a data que se quer comparar
	 * @return true se for do mesmo dia, false caso contrário
	 */
	public boolean ehDoMesmoDia(DiaHoraEventos data) {
		return (this.getDia() == data.getDia()) && (this.getMes() == data.getMes()) && (this.getAno() == data.getAno());
	}

	/**
	 * Retornar se a data passada como parâmetro é do mesmo dia (ano, mes e dia)
	 * e mesma hora (hora, minuto)
	 * @param data É a data que se quer comparar
	 * @return true se for do mesmo dia, hora e minuto false caso contrário
	 */
	public boolean ehDaMesmaHoraMinuto(DiaHoraEventos data) {
		return (this.getDia() == data.getDia()) && (this.getMes() == data.getMes()) && (this.getAno() == data.getAno())
		&& (this.getHora() == data.getHora()) && (this.getMinutos() == data.getMinutos());
	}

	/**
	 * Verifica se este DiaHoraEventos representa uma data posterior à passada como parâmetro
	 * @param termoFinal a data para comparação
	 * @return true caso seja posterior
	 */
	public boolean ehMaior(DiaHoraEventos termoFinal) {
		GregorianCalendar este = (GregorianCalendar) this.getCalenGreg().clone();
		GregorianCalendar tfinal = (GregorianCalendar) termoFinal.getCalenGreg().clone();
		este.set(GregorianCalendar.HOUR_OF_DAY, 0);
		este.set(GregorianCalendar.MINUTE, 0);
		este.set(GregorianCalendar.SECOND, 0);
		este.set(GregorianCalendar.MILLISECOND, 0);
		tfinal.set(GregorianCalendar.HOUR_OF_DAY, 0);
		tfinal.set(GregorianCalendar.MINUTE, 0);
		tfinal.set(GregorianCalendar.SECOND, 0);
		tfinal.set(GregorianCalendar.MILLISECOND, 0);
		return este.getTimeInMillis() > tfinal.getTimeInMillis();
	}

	/**
	 * Pega um DiaHoraEventos representando uma data que corresponde ao primeiro horário de hoje.
	 * Por exemplo, o primeiro horário da data 01/01/1970 às 15:30:01 é 01/01/1970 às 00:00:00
	 * @return um DiaHoraEventos com a representação
	 */
	public static DiaHoraEventos getDataInicioDiaHoje() {
		DiaHoraEventos data = new DiaHoraEventos(new Date());
		data.setHora(0);
		data.setMinuto(0);
		data.setSegundo(0);
		data.setMiliSegundos(0);
		return data;
	}

	/**
	 * Pega um DiaHoraEventos representando uma data que corresponde ao último horário de hoje.
	 * Por exemplo, o primeiro horário da data 01/01/1970 às 15:30:01 é 01/01/1970 às 23:59:59,999
	 * @return um DiaHoraEventos com a representação
	 */
	public static DiaHoraEventos getDataFimDiaHoje() {
		DiaHoraEventos data = new DiaHoraEventos(new Date());
		data.setHora(23);
		data.setMinuto(59);
		data.setSegundo(59);
		data.setMiliSegundos(999);
		return data;
	}

	/**
	 * Pega um DiaHoraEventos representando uma data que corresponde ao início desta semana.
	 * Primeiro dia da semana e primeiro horário desse dia
	 * @see #getDataInicioDiaHoje()
	 * @return um DiaHoraEventos com a representação
	 */
	public static DiaHoraEventos getDataInicioSemana() {
		DiaHoraEventos data = new DiaHoraEventos();
		//Vamos diminuir a data até encontrar um domindo
		while ((data.getCalenGreg().get(GregorianCalendar.DAY_OF_WEEK)) != GregorianCalendar.SUNDAY) {
			data.getCalenGreg().add(GregorianCalendar.DAY_OF_MONTH, -1);
		}
		data.setHora(0);
		data.setMinuto(0);
		data.setSegundo(0);
		data.setMiliSegundos(0);
		return data;
	}

	/**
	 * Pega um DiaHoraEventos representando uma data que corresponde ao fim desta semana.
	 * Último dia da semana e último horário desse dia
	 * @see #getDataFimDiaHoje()
	 * @return um DiaHoraEventos com a representação
	 */
	public static DiaHoraEventos getDataFimSemana() {
		DiaHoraEventos data = new DiaHoraEventos();
		//Vamos diminuir a data até encontrar um domindo
		while ((data.getCalenGreg().get(GregorianCalendar.DAY_OF_WEEK)) != GregorianCalendar.SATURDAY) {
			data.getCalenGreg().add(GregorianCalendar.DAY_OF_MONTH, +1);
		}
		data.setHora(23);
		data.setMinuto(59);
		data.setSegundo(59);
		data.setMiliSegundos(999);
		return data;
	}

	/**
	 * Pega um DiaHoraEventos representando uma data que corresponde ao início deste mês.
	 * Primeiro dia do mês e primeiro horário desse dia
	 * @see #getDataInicioDiaHoje()
	 * @return um DiaHoraEventos com a representação
	 */
	public static DiaHoraEventos getDataInicioMes() {
		GregorianCalendar c = new GregorianCalendar();
		c.set(GregorianCalendar.DAY_OF_MONTH, 1);

		DiaHoraEventos data = new DiaHoraEventos(c.getTime());

		data.setHora(0);
		data.setMinuto(0);
		data.setSegundo(0);
		data.setMiliSegundos(0);
		return data;
	}

	/**
	 * Pega um DiaHoraEventos representando uma data que corresponde ao fim deste mês.
	 * Último dia do mês e último horário desse dia
	 * @see #getDataFimDiaHoje()
	 * @return um DiaHoraEventos com a representação
	 */
	public static DiaHoraEventos getDataFimMes() {
		GregorianCalendar c = new GregorianCalendar();
		c.add(GregorianCalendar.MONTH, 1);
		c.set(GregorianCalendar.DAY_OF_MONTH, 1);
		c.add(GregorianCalendar.DATE, -1);

		DiaHoraEventos data = new DiaHoraEventos(c.getTime());

		data.setHora(23);
		data.setMinuto(59);
		data.setSegundo(59);
		data.setMiliSegundos(999);
		return data;
	}

	/**
	 * Pega um DiaHoraEventos representando uma data que corresponde ao início deste ano.
	 * Primeiro dia do ano e primeiro horário desse dia
	 * @see #getDataInicioDiaHoje()
	 * @return um DiaHoraEventos com a representação
	 */
	public static DiaHoraEventos getDataInicioAno() {
		DiaHoraEventos data = new DiaHoraEventos();
		data.setDia(1);
		data.setMes(1);
		data.setHora(0);
		data.setMinuto(0);
		data.setSegundo(0);
		data.setMiliSegundos(0);
		return data;
	}

	/**
	 * Pega um DiaHoraEventos representando uma data que corresponde ao fim deste ano.
	 * Último dia do ano e último horário desse dia
	 * @see #getDataFimDiaHoje()
	 * @return um DiaHoraEventos com a representação
	 */
	public static DiaHoraEventos getDataFimAno() {
		DiaHoraEventos data = new DiaHoraEventos();
		data.setDia(31);
		data.setMes(12);
		data.setHora(23);
		data.setMinuto(59);
		data.setSegundo(59);
		data.setMiliSegundos(999);
		return data;
	}

	/**
	 * Pega um DiaHoraEventos com uma representação de uma data que é o início do dia posterior ao dia que representa este DiaHoraEventos
	 * @return um DiaHoraEventos com a representação
	 */
	public Date getDataHoraFinal() {
		DiaHoraEventos diaHoraEventos = new DiaHoraEventos(this.getDate());
		diaHoraEventos.addDias(0);
		diaHoraEventos.setHora(23);
		diaHoraEventos.setMinuto(59);
		diaHoraEventos.setSegundo(59);
		diaHoraEventos.setMiliSegundos(999);
		return diaHoraEventos.getDate();
	}

	/**
	 * Pega um DiaHoraEventos com uma representação de uma data que é o início do dia atual ao dia que representa este DiaHoraEventos
	 * @return um DiaHoraEventos com a representação
	 */
	public Date getDataHoraInicial() {
		DiaHoraEventos diaHoraEventos = new DiaHoraEventos(this.getDate());
		diaHoraEventos.addDias(0);
		diaHoraEventos.setHora(0);
		diaHoraEventos.setMinuto(0);
		diaHoraEventos.setSegundo(0);
		diaHoraEventos.setMiliSegundos(0);
		return diaHoraEventos.getDate();
	}

	/**
	 * Pega um DiaHoraEventos com uma representação de uma data que é o início do dia posterior ao dia que representa este DiaHoraEventos
	 * @return um DiaHoraEventos com a representação
	 */
	public DiaHoraEventos getDataFimDia() {
		DiaHoraEventos diaHoraEventos = new DiaHoraEventos(this.getDate());
		diaHoraEventos.addDias(0);
		diaHoraEventos.setHora(23);
		diaHoraEventos.setMinuto(59);
		diaHoraEventos.setSegundo(59);
		diaHoraEventos.setMiliSegundos(999);
		return diaHoraEventos;
	}

	/**
	 * Pega um DiaHoraEventos com uma representação de uma data que é o início do dia atual ao dia que representa este DiaHoraEventos
	 * @return um DiaHoraEventos com a representação
	 */
	public DiaHoraEventos getDataInicioDia() {
		DiaHoraEventos diaHoraEventos = new DiaHoraEventos(this.getDate());
		diaHoraEventos.addDias(0);
		diaHoraEventos.setHora(0);
		diaHoraEventos.setMinuto(0);
		diaHoraEventos.setSegundo(0);
		diaHoraEventos.setMiliSegundos(0);
		return diaHoraEventos;
	}

	/**
	 * Método que adiciona um zero à esquerda caso o valor só possua 1 dígito
	 * @param valor valor a ser analisado
	 * @return Valor com um zero à esquerda, se necessário
	 */
	public static String adicionaZeroEsquerdaNecessario(int valorInteiro) {
		String valor = Integer.toString(valorInteiro);
		if (valor.length() == 1) {
			valor = "0" + valor;
		}
		return valor;
	}

//	/**
//	 * Método que auxilia na exibição, numa única linha, dos horários de um objeto que implemente
//	 * a interface PautaHorariosIF.
//	 * @param pautaIF Objeto  cujos configuração horários se deseja visualizar numa única linha
//	 * @return COnfiguração de um objeto do tipo PautaHorariosIF, numa única linha
//	 * @throws TorqueException
//	 */
//	public static String formataExibicaoFaixaHorariosAudiencia(PautaHorariosIF pautaIF) throws TorqueException {
//		return "Hora de Inicio:  " + DiaHoraEventos.adicionaZeroEsquerdaNecessario(pautaIF.getHoraInicio()) + ":" + DiaHoraEventos.adicionaZeroEsquerdaNecessario(pautaIF.getMinutoInicial()) + " Hora Final:  " + DiaHoraEventos.adicionaZeroEsquerdaNecessario(pautaIF.getHoraFinal()) + ":" + DiaHoraEventos.adicionaZeroEsquerdaNecessario(pautaIF.getMinutoFinal()) + " Horário Refeição:  " + DiaHoraEventos.adicionaZeroEsquerdaNecessario(pautaIF.getHoraInicioRefeicao()) + ":" + DiaHoraEventos.adicionaZeroEsquerdaNecessario(pautaIF.getMinutoInicialRefeicao()) + "-" + DiaHoraEventos.adicionaZeroEsquerdaNecessario(pautaIF.getHoraFinalRefeicao()) + ":" + DiaHoraEventos.adicionaZeroEsquerdaNecessario(pautaIF.getMinutoFinalRefeicao()) + "  Minutos Intervalo: " + pautaIF.getMinutosIntervalo();
//	}

//	/**
//	 * Método que modifica o objeto para uma data onde se possa marcar a leitura de uma intimação ou citação
//	 * Isto envolve checar o horário do fato, bem como não se tratar de domingo, feriado, dia não útil
//	 * @param codVara Caso não seja informado, não será levado em consideração. Caso seja informado, retornará
//	 *      apenas as datas vinculadas à vara e a nenhuma turma e as datas não vinculadas a nenhuma vara nem nenhuma turma
//	 * @param codTurma Caso não seja informado, não será levado em consideração. Caso seja informado, retornará
//	 *      apenas as datas vinculadas à turma e a nenhuma vara e as datas não vinculadas a nenhuma vara nem nenhuma turma
//	 * @param numeroProcesso É o número de um processo específico
//	 */
//	public void configuraProximoDiaParaCitacaoOuIntimacao(Integer codVara, Integer codTurma, Long numeroProcesso) throws TorqueException {
//		//se o horário ultrapassa o legal, vamos logo colocá-lo para o p´roximo dia às 8 da manhã
//		if (this.getHora() > CalculadorDePrazos.HORA_LEGAL_LIMITE_PARA_ATOS_EXTERNOS) {
//			this.addDias(1);
//			this.setHora(8); //ficará para as 8 da manhã do dia seguinte
//			this.setMinuto(0);
//		}
//
//		//agora vamos incrementar até encontrar um dia válido
//		while (CalculadorDePrazos.ehFeriadoDomingoDiaNaoUtilOuAposHorarioLegal(this, codVara, codTurma, numeroProcesso)) {
//			this.addDias(1);
//		}
//	}
	
	

	/**
	 * Retorna a data atual no formato "1º de janeiro de 1970"
	 * @return uma String com a representação
	 */
	public static String getDataFormalPorExtenso() {
		DiaHoraEventos diaTemp = new DiaHoraEventos();
		String dataFormal=diaTemp.dataNacional().toLowerCase().replaceFirst("^1 ", "1º ");
		
		return dataFormal;
	}
	
	/**
	 * Retorna a data atual no formato "1ª de janeiro de 1970"
	 * @param date a data a ser convertida
	 * @return uma String com a representação
	 */
	public static String dataPorExtenso() {
		Date date = new Date();
		DiaHoraEventos diaTemp = new DiaHoraEventos();
		diaTemp.setData(date);
		return diaTemp.dataNacional();
	}

	/*
	 * Método de Comparação. Retorna um indicador informando se este objeto é
	 * menor (-1), igual (0) ou maior (1) do que o objeto recebido por parâmetro.
	 * @param Object objeto a ser comparado
	 * @return numero inteiro que informa o resultado da comparação
	 * @author Renato Marotta - TJMG
	 */
	public int compareTo(Object o) {
		DiaHoraEventos horaComp = (DiaHoraEventos) o;
		return this.getCalenGreg().compareTo(horaComp.getCalenGreg());
	}

	/*
	 * Implementa o método equals da classe Objetc. Faz a comparação entre dois
	 * objetos e retora true se forem iguais ou false se forem diferentes.
	 * Este método utiliza a implementação de igualdade das implementações de classe
	 * de Calendar.
	 * @param Object objeto a ser comparado
	 * @return resultado da comparação
	 * @author Renato Marotta - TJMG
	 */
	@Override
	public boolean equals(Object o) {
		if (o == null || !(o instanceof DiaHoraEventos)){
			return false;
		}
		DiaHoraEventos horaComp = (DiaHoraEventos) o;
		return this.getCalenGreg().equals(horaComp.getCalenGreg());
	}

	@Override
	public int hashCode() {
		return this.getCalenGreg().hashCode();
	}

	/**
	 * Converte a data deste DiaHoraEventos para uma representação em String no formato especificado
	 * @return uma String com a representação
	 * @author Gustavo - TJMG
	 */
	public String getDataFormatada(String formato) {
		// estou desconsiderando o parametro por que vai ser refatorado.
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm", new Locale("pt", "BR"));
		return df.format(this.getDate());
	}

	public String getDataFormato(String formato) {
		SimpleDateFormat df = new SimpleDateFormat(formato, new Locale("pt", "BR"));
		return df.format(this.getDate());
	}

	/**
	 * Converte a data deste DiaHoraEventos para uma representação em String no formato "01/01/1970"
	 * @return uma String com a representação
	 * @author Gustavo - TJMG
	 */
	public String getDataPadrao() {
		if (this.dataFaixaStr!=null && !this.dataFaixaStr.isEmpty())
			return this.dataFaixaStr;
		else
			return getDataFormato("dd/MM/yyyy");
	}

	/**
	 * Converte a data deste DiaHoraEventos para uma representação em String no formato "01 de janeiro de 1970"
	 * @return uma String com a representação
	 * @author Gustavo - TJMG
	 */    
	public String getDataExtenso() {
		return getDataFormatada("dd 'de' MMMM 'de' yyyy");
	}
	
	/**
	 * Converte a hora deste DiaHoraEventos para uma representação em String no formato "12:00"
	 * @return uma String com a representação
	 * @author Gustavo - TJMG
	 */    
	public String getHoraPadrao() {
		return getDataFormatada("HH:mm");
	}    

	/**
	 * Converte a hora deste DiaHoraEventos para uma representação em String no formato "01/01/1970 12:00"
	 * @return uma String com a representação
	 */    
	public String getDataHoraPadrao() {
		return getDataFormatada("dd/MM/yyyy HH:mm");
	}    

	/**
	 * Converte a Data e hora deste DiaHoraEventos para uma representação em String no formato "01 de janeiro de 1970 às 12:00"
	 * @return uma String com a representação
	 * @author Gustavo - TJMG
	 */    
	public String getDataExtensoHora() {
		return getDataFormatada("dd 'de' MMMM 'de' yyyy 'às' HH:mm");
	}    

	/**
	 * Método utilizado para calcular a idade do objeto de data atual tomando
	 * como base a data atual.
	 * 
	 * @return idade
	 * @author Gustavo-TJMG
	 */
	public int calculaIdade() {

		// Cria um objeto calendar com a data atual
		Calendar today = Calendar.getInstance();

		// Obtém a idade baseado no ano
		int age = today.get(Calendar.YEAR) - calenGreg.get(Calendar.YEAR);

		calenGreg.add(Calendar.YEAR, age);

		//se a data de hoje é antes da data de Nascimento, então diminui 1(um)
		if (today.before(calenGreg)) {
			age--;
		}
		return age;
	}

	/**
	 * @return the dataFaixaStr
	 */
	public String getDataFaixaStr() {
		return dataFaixaStr;
	}

	/**
	 * Define dataFaixaStr e, além disso, define isDataFaixaStrModificado
	 * - Se forceUpdate==TRUE, a data referente a este objeto será atualizada
	 *   de acordo com a dataFaixaStr informada.
	 * - Se forceUpdate==FALSE, apenas define a propriedade dataFaixaStr, mas
	 *   não faz nenhum recalculo sobre a data já armazenada
	 * @param dataFaixaStr
	 * @param forceUpdate
	 */
	public void setDataFaixaStr(String dataFaixaStr, boolean forceUpdate) {
		this.dataFaixaStr = dataFaixaStr;
		this.isDataFaixaStrModificado = forceUpdate;
	}
	
	/**
	 * Define dataFaixaStr e indica que este objeto deve ser atualizado conforme 
	 * a string informada
	 * @param dataFaixaStr the dataFaixaStr to set
	 */
	public void setDataFaixaStr(String dataFaixaStr) {
		setDataFaixaStr(dataFaixaStr, true);
	}
	
	/**
	 * Define dataFaixaStr e força o parse do mesmo
	 * baseado na data base atual
	 * @param dataFaixaStr
	 */
	public void setDataFaixaStrComDataBaseAgora(String dataFaixaStr) {
		setDataFaixaStr(dataFaixaStr);
		parseDataFaixaStrDataBaseAgora();
	}


	/**
	 * Considera dataInicial horaFinal e dataFinal horaFinal
	 * @param dataInicial
	 * @param dataFinal
	 * @return
	 */
	public static Integer getPeriodoEmDias(Date dataInicial, Date dataFinal) {
		Integer tempoDias = null;
		if (dataInicial!=null && dataFinal!=null) {
			long tempoMilisegundos = (new DiaHoraEventos(dataFinal).getDataHoraFinal()).getTime() - (new DiaHoraEventos(dataInicial).getDataHoraFinal()).getTime();
			long tempoMinutos = tempoMilisegundos / 60000;
			long tempoHoras = tempoMinutos / 60;
			tempoDias = ((int) Math.round(tempoHoras / 24) );
		}
		return tempoDias;
	}

	/**
	 * Considera dataInicial horaInicial e dataFinal horaFinal
	 * @param dataInicial
	 * @param dataFinal
	 * @return
	 */
	public static Integer getPeriodo(Date dataInicial, Date dataFinal) {
		Integer tempoDias = null;
		if (dataInicial!=null && dataFinal!=null) {
			DiaHoraEventos dataHoraFinal = new DiaHoraEventos(new DiaHoraEventos(dataFinal).getDataHoraFinal());
			dataHoraFinal.addMilisegundos(1);
			long tempoMilisegundos = (dataHoraFinal.getDate()).getTime() - (new DiaHoraEventos(dataInicial).getDataHoraInicial()).getTime();
			long tempoMinutos = tempoMilisegundos / 60000;
			long tempoHoras = tempoMinutos / 60;
			tempoDias = ((int) Math.round(tempoHoras / 24) );
		}
		return tempoDias;
	}

    
    public static String calcularIdade(Date data) {
        LocalDate agora = LocalDate.now();    
        LocalDate dataCalc = data.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        
        System.out.println("\nDiferenca entre "+ dataCalc +" e "+ agora ); 
        
        Period difData = Period.between(dataCalc, agora);
        return formatar(difData.getYears(), difData.getMonths(), difData.getDays());
    }

    /** Método responsável por formatar uma idade no formato 1 10 6.
     *  Concatena-se 0 se o valor menor que 10 e logo apos o numero adicionasse espaço.
     * 
     *  @return Data formatada para o formato 00 00 00.
     */
    public static String formatar(Integer ano, Integer mes, Integer dia) {
        String idade = "[";

        if (ano.intValue() < 10) {
            idade = (new StringBuilder()).append(idade).append("0").append(ano).append("").toString();
        } else {
            idade = (new StringBuilder()).append(idade).append(ano).append("").toString();
        }
        
        idade = idade + "] ano(s) - [";
        
        
        if (mes.intValue() < 10) {
            idade = (new StringBuilder()).append(idade).append("0").append(mes).append("").toString();
        } else {
            idade = (new StringBuilder()).append(idade).append(mes).append("").toString();
        }
        idade = idade + "] mes(s) - [";
        
        if (dia.intValue() < 10) {
            idade = (new StringBuilder()).append(idade).append("0").append(dia).append("").toString();
        } else {
            idade = (new StringBuilder()).append(idade).append(dia).append("").toString();
        }
        idade = idade + "] dia(s)";
        return idade;
    }
    
    public static void main(String[] args)
    {
    	SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date dat;
		try {
			dat = date.parse("19/11/2016 00:00:00");
			System.out.println(calcularIdade(dat));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }   
   
} 