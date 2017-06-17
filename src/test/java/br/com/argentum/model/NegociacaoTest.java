package br.com.argentum.model;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

public class NegociacaoTest {

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarNegociacaoComPrecoNegativo() {
		new Negociacao(-1, 1, LocalDateTime.now());
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarNegociacaoComQuantidadeNegativ1() {
		new Negociacao(1, -1, LocalDateTime.now());
	}

	@Test(expected = IllegalArgumentException.class)
	public void naoDeveCriarNegociacaoComDataNula() {
		new Negociacao(1, 1, null);
	}
	
	@Test
	public void minutosDiferentesEhMesmoDia() {
		LocalDateTime agora = LocalDateTime.of(2017, 1, 1, 10, 30);
		LocalDateTime antes = agora.minusMinutes(1);

		Negociacao negociacao = new Negociacao(10.0, 1, agora);
		
		Assert.assertTrue(negociacao.isMesmoDia(antes));
	}
	
	@Test
	public void horasDiferentesEhMesmoDia() {
		LocalDateTime agora = LocalDateTime.of(2017, 1, 1, 10, 30);
		LocalDateTime depois = agora.plusHours(1);

		Negociacao negociacao = new Negociacao(10.0, 1, agora);
		
		Assert.assertTrue(negociacao.isMesmoDia(depois));
	}

	@Test
	public void diasDiferentesNaoEhMesmoDia() {
		LocalDateTime hoje = LocalDateTime.now();
		LocalDateTime ontem = hoje.minusDays(1);

		Negociacao negociacao = new Negociacao(10.0, 1, hoje);
		
		Assert.assertFalse(negociacao.isMesmoDia(ontem));
	}
	
	@Test
	public void mesesDiferentesNaoEhMesmoDia() {
		LocalDateTime hoje = LocalDateTime.now();
		LocalDateTime mesPassado = hoje.minusMonths(1);

		Negociacao negociacao = new Negociacao(10.0, 1, hoje);
		
		Assert.assertFalse(negociacao.isMesmoDia(mesPassado));
	}
	
	@Test
	public void anosDiferentesNaoEhMesmoDia() {
		LocalDateTime hoje = LocalDateTime.now();
		LocalDateTime anoPassado = hoje.minusYears(1);

		Negociacao negociacao = new Negociacao(10.0, 1, hoje);
		
		Assert.assertFalse(negociacao.isMesmoDia(anoPassado));
	}
}
