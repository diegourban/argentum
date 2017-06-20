package br.com.argentum.indicadores;

import br.com.argentum.model.SerieTemporal;

public class MediaMovelSimples {
	
	public double calcula(final int posicao, final SerieTemporal serie) {
		double soma = 0;
		
		for(int i = posicao; i > posicao - 3; i--) {
			soma += serie.getCandlestick(i).getFechamento();
		}
		
		return soma / 3;
	}

}
