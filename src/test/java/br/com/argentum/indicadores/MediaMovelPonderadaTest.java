package br.com.argentum.indicadores;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import br.com.argentum.model.GeradorDeSerie;
import br.com.argentum.model.SerieTemporal;

public class MediaMovelPonderadaTest {

	@Test
	public void sequenciaSimplesDeCandlesticks() {
		SerieTemporal serie = GeradorDeSerie.criaSerie(1, 2, 3, 4, 5, 6);
		MediaMovelPonderada mmp = new MediaMovelPonderada();

		assertThat(mmp.calcula(2, serie), closeTo(14.0 / 6, 0.1));
		assertThat(mmp.calcula(3, serie), closeTo(20.0 / 6, 0.1));
		assertThat(mmp.calcula(4, serie), closeTo(26.0 / 6, 0.1));
		assertThat(mmp.calcula(5, serie), closeTo(32.0 / 6, 0.1));
	}

}
