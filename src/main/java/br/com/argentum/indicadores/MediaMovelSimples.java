package br.com.argentum.indicadores;

import br.com.argentum.model.SerieTemporal;

public class MediaMovelSimples implements Indicador {

	private Indicador decorator;

	public MediaMovelSimples() {
		this.decorator = new IndicadorFechamento();
	}

	public MediaMovelSimples(Indicador decorator) {
		this.decorator = decorator;
	}

	@Override
	public double calcula(final int posicao, final SerieTemporal serie) {
		double soma = 0;

		for (int i = posicao; i > posicao - 3; i--) {
			soma += decorator.calcula(i, serie);
		}

		return soma / 3;
	}

	@Override
	public String toString() {
		return "MMS - " + this.decorator.toString();
	}

}
