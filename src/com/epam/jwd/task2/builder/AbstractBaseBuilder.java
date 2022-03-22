package com.epam.jwd.task2.builder;

import java.io.IOException;

import javax.xml.stream.XMLStreamException;

import org.xml.sax.SAXException;

import com.epam.jwd.task2.entity.TouristVouchers;

public abstract class AbstractBaseBuilder {

	protected TouristVouchers catalog;

	public AbstractBaseBuilder() {
	}

	public TouristVouchers getCatalog() {
		return catalog;
	}

	public void buildTouristVouchers(String path) throws IOException, XMLStreamException, SAXException {
		
	}

}