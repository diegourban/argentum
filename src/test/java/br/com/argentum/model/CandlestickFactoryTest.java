package br.com.argentum.model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class CandlestickFactoryTest {

	@Test
	public void deveCriarCandlestickSemNegociacao() {
		LocalDateTime hoje = LocalDateTime.now();

		List<Negociacao> negociacoes = Collections.emptyList();

		CandlestickFactory factory = new CandlestickFactory();
		Candlestick candlestick = factory.geraCandlestickParaData(negociacoes, hoje);

		assertThat(candlestick.getAbertura(), is(0.0));
		assertThat(candlestick.getFechamento(), is(0.0));
		assertThat(candlestick.getMinimo(), is(0.0));
		assertThat(candlestick.getMaximo(), is(0.0));
		assertThat(candlestick.getVolume(), is(0.0));
	}

	@Test
	public void deveCriarCandlestickComUmaNegociacao() {
		LocalDateTime hoje = LocalDateTime.now();

		Negociacao negociacao = new Negociacao(40.0, 100, hoje);

		List<Negociacao> negociacoes = Arrays.asList(negociacao);

		CandlestickFactory factory = new CandlestickFactory();
		Candlestick candlestick = factory.geraCandlestickParaData(negociacoes, hoje);

		assertThat(candlestick.getAbertura(), is(40.0));
		assertThat(candlestick.getFechamento(), is(40.0));
		assertThat(candlestick.getMinimo(), is(40.0));
		assertThat(candlestick.getMaximo(), is(40.0));
		assertThat(candlestick.getVolume(), is(4000.0));
	}

	@Test
	public void deveCriarCandlestick() {
		LocalDateTime hoje = LocalDateTime.now();

		Negociacao negociacao1 = new Negociacao(40.0, 100, hoje);
		Negociacao negociacao2 = new Negociacao(35.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao4 = new Negociacao(20.0, 100, hoje);

		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4);

		CandlestickFactory factory = new CandlestickFactory();
		Candlestick candlestick = factory.geraCandlestickParaData(negociacoes, hoje);

		assertThat(candlestick.getAbertura(), is(40.0));
		assertThat(candlestick.getFechamento(), is(20.0));
		assertThat(candlestick.getMinimo(), is(20.0));
		assertThat(candlestick.getMaximo(), is(45.0));
		assertThat(candlestick.getVolume(), is(14000.0));
	}

	@Test
	public void negociacoesDeTresDiasDiferentesGeraTresCandlesDiferentes() {
		LocalDateTime hoje = LocalDateTime.now();

		Negociacao negociacao1 = new Negociacao(10.0, 2, hoje);
		Negociacao negociacao2 = new Negociacao(20.0, 1, hoje);

		LocalDateTime amanha = hoje.plusDays(1);

		Negociacao negociacao3 = new Negociacao(50.0, 100, amanha);
		Negociacao negociacao4 = new Negociacao(10.0, 3, amanha);
		Negociacao negociacao5 = new Negociacao(20.0, 4, amanha);

		LocalDateTime depois = amanha.plusDays(1);

		Negociacao negociacao6 = new Negociacao(15.0, 20, depois);
		Negociacao negociacao7 = new Negociacao(100.0, 2, depois);

		List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, negociacao3, negociacao4, negociacao5,
				negociacao6, negociacao7);
		
		CandlestickFactory fabrica = new CandlestickFactory();
		
		List<Candlestick> candlesticks = fabrica.constroiCandles(negociacoes);
		
		assertThat(candlesticks.size(), is(3));
		assertThat(candlesticks.get(0).getVolume(), is(40.0));
		assertThat(candlesticks.get(1).getVolume(), is(5110.0));
		assertThat(candlesticks.get(2).getVolume(), is(500.0));
	}

}
