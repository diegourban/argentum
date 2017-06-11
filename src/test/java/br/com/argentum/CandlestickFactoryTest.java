package br.com.argentum;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

import br.com.argentum.model.Candlestick;
import br.com.argentum.model.CandlestickFactory;
import br.com.argentum.model.Negociacao;

public class CandlestickFactoryTest {
	
	@Test
	public void deveCriarCandlestick() {
		LocalDateTime hoje = LocalDateTime.now();
		
		Negociacao negociacao1 = new Negociacao(40.0, 100, hoje);
		Negociacao negociacao2 = new Negociacao(35.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao4 = new Negociacao(20.0, 100, hoje);
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4);
		
		CandlestickFactory factory = new CandlestickFactory();
		Candlestick candlestick = factory.geraCandleParaData(negociacoes, hoje);
		
		assertThat(candlestick.getAbertura(), is(40.0));
		assertThat(candlestick.getFechamento(), is(20.0));
		assertThat(candlestick.getMinimo(), is(20.0));
		assertThat(candlestick.getMaximo(), is(45.0));
		assertThat(candlestick.getVolume(), is(14000.0));
	}

}
