package br.com.argentum.xstream;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class LocalDateTimeConverter implements Converter {

	@Override
	public boolean canConvert(Class type) {
		return type.isAssignableFrom(LocalDateTime.class);
	}

	@Override
	public void marshal(Object object, HierarchicalStreamWriter writer, MarshallingContext context) {
		LocalDateTime data = (LocalDateTime) object;
		ZonedDateTime dataComZona = data.atZone(ZoneOffset.systemDefault());
		long milis = dataComZona.toInstant().toEpochMilli();
		
		writer.startNode("time");
		writer.setValue(String.valueOf(milis));
		writer.endNode();
		
		writer.startNode("timezone");
		writer.setValue(dataComZona.getZone().toString());
		writer.endNode();
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		reader.moveDown();
		String milis = reader.getValue();
		reader.moveUp();
		
		reader.moveDown();
		String timezone = reader.getValue();
		reader.moveUp();
		
		long tempoEmMilis = Long.parseLong(milis);
		Instant tempo = Instant.ofEpochMilli(tempoEmMilis);
		
		ZoneId zona = ZoneId.of(timezone);
		
		ZonedDateTime dataComZona = ZonedDateTime.ofInstant(tempo, zona);
		
		LocalDateTime data = dataComZona.toLocalDateTime();
		
		return data;
	}

}
