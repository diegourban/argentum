package br.com.argentum.indicadores;

import br.com.argentum.model.SerieTemporal;

public class MediaMovelPonderada implements Indicador {

	private Indicador decorator;

	public MediaMovelPonderada() {
		this.decorator = new IndicadorFechamento();
	}

	public MediaMovelPonderada(Indicador decorator) {
		super();
		this.decorator = decorator;
	}

	@Override
	public double calcula(final int posicao, final SerieTemporal serie) {
		double soma = 0;
		int peso = 3;

		for (int i = posicao; i > posicao - 3; i--) {
			soma += (decorator.calcula(i, serie) * peso);
			peso--;
		}

		return soma / 6;
	}

	@Override
	public String toString() {
		return "MMP - " + this.decorator.toString();
	}

}
