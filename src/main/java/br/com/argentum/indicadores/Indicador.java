package br.com.argentum.indicadores;

import br.com.argentum.model.SerieTemporal;

public interface Indicador {

	double calcula(int posicao, SerieTemporal serie);

}