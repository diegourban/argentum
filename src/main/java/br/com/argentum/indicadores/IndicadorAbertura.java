package br.com.argentum.indicadores;

import br.com.argentum.model.SerieTemporal;

public class IndicadorAbertura implements Indicador {

	@Override
	public double calcula(int posicao, SerieTemporal serie) {
		return serie.getCandlestick(posicao).getAbertura();
	}
	
	@Override
	public String toString() {
		return "Abertura";
	}

}
