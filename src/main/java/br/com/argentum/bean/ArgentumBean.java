package br.com.argentum.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.LineChartModel;

import br.com.argentum.graficos.GeradorDeModeloGrafico;
import br.com.argentum.indicadores.IndicadorAbertura;
import br.com.argentum.indicadores.MediaMovelSimples;
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

	public ArgentumBean() {
		this.negociacoes = new ClientWebService().getNegociacoes();
		List<Candlestick> candlesticks = new CandlestickFactory().constroiCandles(this.negociacoes);
		SerieTemporal serie = new SerieTemporal(candlesticks);

		GeradorDeModeloGrafico geradorModelo = new GeradorDeModeloGrafico(serie, 2, serie.getUltimaPosicao());
		geradorModelo.plotaIndicador(new IndicadorAbertura());
		geradorModelo.plotaIndicador(new MediaMovelSimples(new IndicadorAbertura()));
		this.modeloGrafico = geradorModelo.getModeloGrafico();
	}

	public List<Negociacao> getNegociacoes() {
		return this.negociacoes;
	}

	public LineChartModel getModeloGrafico() {
		return modeloGrafico;
	}
}
