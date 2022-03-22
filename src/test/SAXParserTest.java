package test;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import com.epam.jwd.task2.builder.director.TouristVouchersDirector;
import com.epam.jwd.task2.builder.parser_builder.SAXBuilder;


class SAXParserTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testBuilder() throws ParserConfigurationException, IOException, XMLStreamException, SAXException {
		var a = TouristVouchersDirector.createTours(new SAXBuilder(), "src/test/resources/tourist_vouchers.xml");
		var b = ReferenceTouristVouchers.getTourList();
		assertEquals(a.getTouristVouchers(), b);
		System.out.println(a);
	}

}
