package br.com.argentum.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CandlestickFactory {

	public Candlestick geraCandleParaData(List<Negociacao> negociacoes, LocalDateTime data) {
		double abertura = 0.0;
		double fechamento = 0.0;

		if (!negociacoes.isEmpty()) {
			abertura = negociacoes.get(0).getPreco();
			fechamento = negociacoes.get(negociacoes.size() - 1).getPreco();
		}

		double minimo = abertura;
		double maximo = abertura;

		double volume = 0;
		for (Negociacao negociacao : negociacoes) {
			volume += negociacao.getVolume();

			if (negociacao.getPreco() < minimo) {
				minimo = negociacao.getPreco();
			}
			if (negociacao.getPreco() > maximo) {
				maximo = negociacao.getPreco();
			}

		}

		return new Candlestick(abertura, fechamento, maximo, minimo, volume, data);
	}

	public List<Candlestick> constroiCandles(List<Negociacao> negociacoes) {
		List<Candlestick> candlesticks = new ArrayList<>();

		List<Negociacao> negociacoesDoDia = new ArrayList<>();

		LocalDateTime dataAtual = negociacoes.get(0).getData();

		for (Negociacao negociacao : negociacoes) {
			if (negociacao.isMesmoDia(dataAtual)) {
				negociacoesDoDia.add(negociacao);
			} else {
				Candlestick candle = geraCandleParaData(negociacoesDoDia, dataAtual);
				candlesticks.add(candle);
				negociacoesDoDia = new ArrayList<>();
				negociacoesDoDia.add(negociacao);
				dataAtual = negociacao.getData();
			}
		}
		
		Candlestick candle = geraCandleParaData(negociacoesDoDia, dataAtual);
		candlesticks.add(candle);

		return candlesticks;
	}

}
