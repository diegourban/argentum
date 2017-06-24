package br.com.argentum.indicadores;

import java.lang.reflect.Constructor;

public class IndicadorFactory {
	
	private String nomeMedia;
	private String nomeIndicador;

	public IndicadorFactory(String nomeMedia, String nomeIndicador) {
		this.nomeMedia = nomeMedia;
		this.nomeIndicador = nomeIndicador;
	}
	
	public Indicador defineIndicador() {
		final String pacote = "br.com.argentum.indicadores.";
		
		if(this.nomeMedia == null || this.nomeIndicador == null) {
			this.nomeMedia = "MediaMovelSimples";
			this.nomeIndicador = "IndicadorFechamento";
		}
		
		try {
			Class<Indicador> classeIndicador = (Class<Indicador>) Class.forName(pacote + nomeIndicador);
			Indicador indicador = classeIndicador.newInstance();
			
			Class<Indicador> classeMedia = (Class<Indicador>) Class.forName(pacote + nomeMedia);
			Constructor<Indicador> constructor = classeMedia.getConstructor(Indicador.class);
			Indicador media = constructor.newInstance(indicador);
			
			return media;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
