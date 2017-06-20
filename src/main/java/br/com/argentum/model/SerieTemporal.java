package br.com.argentum.model;

import java.util.List;

public class SerieTemporal {
	
	private final List<Candlestick> candlesticks;
	
	public SerieTemporal(final List<Candlestick> candlesticks) {
		this.candlesticks = candlesticks;
	}
	
	public Candlestick getCandlestick(final int posicao) {
		return this.candlesticks.get(posicao);
	}
	
	public int getUltimaPosicao() {
		return this.candlesticks.size() - 1;
	}

}
