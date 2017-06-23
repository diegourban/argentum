package br.com.argentum.indicadores;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

import static org.hamcrest.number.IsCloseTo.*;
import org.junit.Test;

import br.com.argentum.model.GeradorDeSerie;
import br.com.argentum.model.SerieTemporal;

public class MediaMovelSimplesTest {
	
	@Test
	public void sequenciaSimplesDeCandlesticks() {
		SerieTemporal serie = GeradorDeSerie.criaSerie(1, 3, 5, 7, 2, 4);
		Indicador mms = new MediaMovelSimples();
		
		assertThat(mms.calcula(2, serie), is(3.0));
		assertThat(mms.calcula(3, serie), is(5.0));
		assertThat(mms.calcula(4, serie), closeTo(4.6, 0.1));
		assertThat(mms.calcula(5, serie), closeTo(4.3, 0.1));
	}
	

}
