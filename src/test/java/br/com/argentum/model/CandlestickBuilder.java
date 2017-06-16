package br.com.argentum.model;

import java.time.LocalDateTime;

public class CandlestickBuilder {

	private double abertura;
	private double fechamento;
	private double maximo;
	private double minimo;
	private double volume;
	private LocalDateTime data;

	public CandlestickBuilder comAbertura(double abertura) {
		this.abertura = abertura;
		return this;
	}

	public CandlestickBuilder comFechamento(double fechamento) {
		this.fechamento = fechamento;
		return this;
	}

	public CandlestickBuilder comMaximo(double maximo) {
		this.maximo = maximo;
		return this;
	}

	public CandlestickBuilder comMinimo(double minimo) {
		this.minimo = minimo;
		return this;
	}

	public CandlestickBuilder comVolume(double volume) {
		this.volume = volume;
		return this;
	}

	public CandlestickBuilder comData(LocalDateTime data) {
		this.data = data;
		return this;
	}

	public Candlestick build() {
		return new Candlestick(abertura, fechamento, maximo, minimo, volume, data);
	}

}
