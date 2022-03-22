package com.epam.jwd.task2.builder.parser_builder;

import java.io.FileNotFoundException;

import javax.xml.stream.XMLStreamException;

import com.epam.jwd.task2.builder.AbstractBaseBuilder;
import com.epam.jwd.task2.parser.stax.TourStAXParser;

public class StAXBuilder extends AbstractBaseBuilder {

	@Override
	public void buildTouristVouchers(String path) throws XMLStreamException, FileNotFoundException {
		TourStAXParser stAXBuilder = new TourStAXParser();
		stAXBuilder.buildCatalog(path);
		catalog = stAXBuilder.getTour();

	}

}
