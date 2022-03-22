package com.epam.jwd.task2.builder.parser_builder;

import java.io.IOException;

import javax.xml.stream.XMLStreamException;

import com.epam.jwd.task2.builder.AbstractBaseBuilder;
import com.epam.jwd.task2.parser.dom.TourDOMParser;

public class DOMBuilder extends AbstractBaseBuilder {

	@Override
	public void buildTouristVouchers(String path) throws IOException, XMLStreamException {

		TourDOMParser domBuilder = new TourDOMParser();
		domBuilder.buildTour(path);
		catalog = domBuilder.getTours();

	}

}
