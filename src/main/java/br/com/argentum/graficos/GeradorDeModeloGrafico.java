package br.com.argentum.graficos;

import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import br.com.argentum.indicadores.Indicador;
import br.com.argentum.model.SerieTemporal;

public class GeradorDeModeloGrafico {
	
	private SerieTemporal serie;
	private int comeco;
	private int fim;
	private LineChartModel modeloGrafico;

	public GeradorDeModeloGrafico(SerieTemporal serie, int comeco, int fim) {
		this.serie = serie;
		this.comeco = comeco;
		this.fim = fim;
		this.modeloGrafico = new LineChartModel();
		this.modeloGrafico.setTitle("Indicadores");
		this.modeloGrafico.setLegendPosition("w");
	}

	public void plotaIndicador(Indicador indicador) {
		LineChartSeries linha = new LineChartSeries();
		linha.setLabel(indicador.toString());
		
		double valor = 0;
		
		for(int i = this.comeco; i <= this.fim; i++) {
			valor = indicador.calcula(i, this.serie);
			linha.set(i, valor);
		}
		
		this.modeloGrafico.addSeries(linha);
	}
	
	public LineChartModel getModeloGrafico() {
		return modeloGrafico;
	}
}
