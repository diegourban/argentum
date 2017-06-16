package br.com.argentum.reader;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.argentum.model.Negociacao;

public class LeitorXmlTest {
	
	@Test
	public void deveLerXmlComUmaNegociacao() {
		String xml = 
				"<list>\n" +
				"  <negociacao>\n" +
				"    <preco>10.0</preco>\n" + 
				"    <quantidade>4</quantidade>\n" + 
				"    <data>\n" + 
				"      <time>1497650160000</time>\n" + 
				"      <timezone>America/Sao_Paulo</timezone>\n" + 
				"    </data>\n" + 
				"  </negociacao>\n" +
				"</list>";
		
		InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
		
		LeitorXml leitor = new LeitorXml();
		List<Negociacao> negociacoesCarregadas = leitor.carrega(inputStream);
	
		Negociacao negociacaoEsperada = new Negociacao(10.0, 4, LocalDateTime.of(2017, 6, 16, 18, 56));
		
		Assert.assertEquals(1, negociacoesCarregadas.size());
		Assert.assertEquals(negociacaoEsperada, negociacoesCarregadas.get(0));
	}

}
