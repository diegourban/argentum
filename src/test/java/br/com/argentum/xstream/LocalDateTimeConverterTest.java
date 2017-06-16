package br.com.argentum.xstream;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.argentum.model.Negociacao;

public class LocalDateTimeConverterTest {

	@Test
	public void deveConverterUmaNegociacaoParaXml() {
		Negociacao negociacao = new Negociacao(10.0, 4, LocalDateTime.of(2017, 6, 16, 18, 56));

		XStream xstream = new XStream(new DomDriver());
		xstream.alias("negociacao", Negociacao.class);
		xstream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());
		String xmlConvertido = xstream.toXML(negociacao);

		String xmlEsperado = 
				"<negociacao>\n" +
				"  <preco>10.0</preco>\n" + 
				"  <quantidade>4</quantidade>\n" + 
				"  <data>\n" + 
				"    <time>1497650160000</time>\n" + 
				"    <timezone>America/Sao_Paulo</timezone>\n" + 
				"  </data>\n" + 
				"</negociacao>";
		
		Assert.assertEquals(xmlEsperado, xmlConvertido);
	}
	
	@Test
	public void deveConveterUmXmlParaNegociacao() {
		String xml = 
				"<negociacao>\n" +
				"  <preco>10.0</preco>\n" + 
				"  <quantidade>4</quantidade>\n" + 
				"  <data>\n" + 
				"    <time>1497650160000</time>\n" + 
				"    <timezone>America/Sao_Paulo</timezone>\n" + 
				"  </data>\n" + 
				"</negociacao>";
		
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("negociacao", Negociacao.class);
		xstream.registerLocalConverter(Negociacao.class, "data", new LocalDateTimeConverter());
		
		Negociacao negociacao = (Negociacao) xstream.fromXML(xml);
		
		Negociacao negociacaoEsperada = new Negociacao(10.0, 4, LocalDateTime.of(2017, 6, 16, 18, 56));
		
		Assert.assertEquals(negociacaoEsperada, negociacao);
	}

}
