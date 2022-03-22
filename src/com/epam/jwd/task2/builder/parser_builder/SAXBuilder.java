package com.epam.jwd.task2.builder.parser_builder;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.epam.jwd.task2.builder.AbstractBaseBuilder;
import com.epam.jwd.task2.parser.sax.TourErrorHandler;
import com.epam.jwd.task2.parser.sax.TourSAXParser;

public class SAXBuilder extends AbstractBaseBuilder {
	
	SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser parser = factory.newSAXParser();
	XMLReader reader = parser.getXMLReader();
	TourSAXParser tourSAXParser = new TourSAXParser();

	public SAXBuilder() throws ParserConfigurationException, SAXException {
	}

	@Override
	public void buildTouristVouchers(String path) throws IOException, SAXException {

		reader.setContentHandler(tourSAXParser);
		reader.setErrorHandler(new TourErrorHandler());
		reader.parse(path);

		catalog = tourSAXParser.getTour();
	}
}
