package br.com.argentum.model;

import java.time.LocalDateTime;

public final class Candlestick {

	private final double abertura;
	private final double fechamento;
	private final double maximo;
	private final double minimo;
	private final double volume;
	private final LocalDateTime data;

	public Candlestick(double abertura, double fechamento, double maximo, double minimo, double volume,
			LocalDateTime data) {
		if (maximo < minimo) {
			throw new IllegalArgumentException("O máximo não deve ser menor que o mínimo");
		}
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.maximo = maximo;
		this.minimo = minimo;
		this.volume = volume;
		this.data = data;
	}

	public boolean isAlta() {
		return this.fechamento >= this.abertura;
	}

	public boolean isBaixa() {
		return this.abertura > this.fechamento;
	}

	public double getAbertura() {
		return abertura;
	}

	public double getFechamento() {
		return fechamento;
	}

	public double getMaximo() {
		return maximo;
	}

	public double getMinimo() {
		return minimo;
	}

	public double getVolume() {
		return volume;
	}

	public LocalDateTime getData() {
		return data;
	}

}
