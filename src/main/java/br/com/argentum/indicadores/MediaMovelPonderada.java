package br.com.argentum.indicadores;

import br.com.argentum.model.SerieTemporal;

public class MediaMovelPonderada {

	public double calcula(final int posicao, final SerieTemporal serie) {
		double soma = 0;
		int peso = 3;

		for (int i = posicao; i > posicao - 3; i--) {
			soma += (serie.getCandlestick(i).getFechamento() * peso);
			peso--;
		}

		return soma / 6;
	}

}
