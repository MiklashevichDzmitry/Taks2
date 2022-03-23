package test;

import java.io.IOException;

import javax.xml.stream.XMLStreamException;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import com.epam.jwd.task2.builder.director.TouristVouchersDirector;
import com.epam.jwd.task2.builder.parser_builder.DOMBuilder;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
class DOMParserTest {

	@Test
	public void testBuilder() throws IOException, XMLStreamException, SAXException {
		var a = TouristVouchersDirector.createTours(new DOMBuilder(), "src/test/resources/tourist_vouchers.xml");
		var b = ReferenceTouristVouchers.getTourList();
		//Assert.assertEquals(a.getTouristVouchers(), b);
		System.out.println(a);
	}

}
