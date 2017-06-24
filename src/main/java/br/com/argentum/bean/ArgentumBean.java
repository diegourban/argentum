package br.com.argentum.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.LineChartModel;

import br.com.argentum.graficos.GeradorDeModeloGrafico;
import br.com.argentum.indicadores.IndicadorFactory;
import br.com.argentum.model.Candlestick;
import br.com.argentum.model.CandlestickFactory;
import br.com.argentum.model.Negociacao;
import br.com.argentum.model.SerieTemporal;
import br.com.argentum.ws.ClientWebService;

@ViewScoped
@ManagedBean
public class ArgentumBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6955708258884337359L;

	private List<Negociacao> negociacoes = new ArrayList<>();

	private LineChartModel modeloGrafico;
	
	private String nomeMedia;
	private String nomeIndicador;

	public ArgentumBean() {
		init();
		this.negociacoes = new ClientWebService().getNegociacoes();
		geraGrafico();
	}

	public void geraGrafico() {
		List<Candlestick> candlesticks = new CandlestickFactory().constroiCandles(this.negociacoes);
		SerieTemporal serie = new SerieTemporal(candlesticks);

		GeradorDeModeloGrafico geradorModelo = new GeradorDeModeloGrafico(serie, 2, serie.getUltimaPosicao());
		IndicadorFactory fabrica = new IndicadorFactory(this.nomeMedia, this.nomeIndicador);
		geradorModelo.plotaIndicador(fabrica.defineIndicador());
		this.modeloGrafico = geradorModelo.getModeloGrafico();
	}
	
	private void init() {
		this.nomeMedia = "MediaMovelSimples";
		this.nomeIndicador = "IndicadorFechamento";
	}

	public List<Negociacao> getNegociacoes() {
		return this.negociacoes;
	}

	public LineChartModel getModeloGrafico() {
		return modeloGrafico;
	}
	
	public String getNomeMedia() {
		return nomeMedia;
	}
	
	public void setNomeMedia(String nomeMedia) {
		this.nomeMedia = nomeMedia;
	}
	
	public String getNomeIndicador() {
		return nomeIndicador;
	}
	
	public void setNomeIndicador(String nomeIndicador) {
		this.nomeIndicador = nomeIndicador;
	}
}
