package com.epam.jwd.task2.builder.director;

import java.io.IOException;

import javax.xml.stream.XMLStreamException;

import org.xml.sax.SAXException;

import com.epam.jwd.task2.builder.AbstractBaseBuilder;
import com.epam.jwd.task2.entity.TouristVouchers;

public class TouristVouchersDirector {

	 public static TouristVouchers createTours(AbstractBaseBuilder builder, String path) throws IOException, XMLStreamException, SAXException {
	        builder.buildTouristVouchers(path);
	        return builder.getCatalog();
	    }
	 
}
