package br.com.argentum.reader;

import java.io.InputStream;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.argentum.model.Negociacao;
import br.com.argentum.xstream.LocalDateTimeConverter;

public class LeitorXml {
	
	public List<Negociacao> carrega(InputStream inputStream) {
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("negociacao", Negociacao.class);
		xstream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());
		
		return (List<Negociacao>) xstream.fromXML(inputStream);
	}
	

}
