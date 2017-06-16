package br.com.argentum.model;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

public class CandlestickTest {

	@Test(expected = IllegalArgumentException.class)
	public void maximoNaoDeveSerMenorQueMinimo() {
		CandlestickBuilder builder = new CandlestickBuilder();

		builder.comAbertura(10.0).comFechamento(20.0).comMaximo(100.0).comMinimo(1000.0).comVolume(100.0)
				.comData(LocalDateTime.now()).build();
	}
	
	@Test
	public void ehAltaSeFechamentoForIgualAbertura() {
		CandlestickBuilder builder = new CandlestickBuilder();

		Candlestick candlestick = builder.comAbertura(20.0).comFechamento(20.0).comMaximo(100.0).comMinimo(10.0).comVolume(100.0)
				.comData(LocalDateTime.now()).build();
		
		Assert.assertTrue(candlestick.isAlta());
	}
}
