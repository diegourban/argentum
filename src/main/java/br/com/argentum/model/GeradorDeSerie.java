package br.com.argentum.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GeradorDeSerie {
	
	public static SerieTemporal criaSerie(double... valores) {
		final List<Candlestick> candlesticks = new ArrayList<>();
		
		for(final double d : valores) {
			candlesticks.add(new Candlestick(d, d, d, d, 100, LocalDateTime.now()));
		}
		
		return new SerieTemporal(candlesticks);
	}

}
