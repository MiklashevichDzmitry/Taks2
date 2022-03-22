package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.xml.stream.XMLStreamException;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import com.epam.jwd.task2.builder.director.TouristVouchersDirector;
import com.epam.jwd.task2.builder.parser_builder.StAXBuilder;

import junit.framework.Assert;

class StAXParserTest {

	@Test
	public void testBuilder() throws SAXException, IOException, XMLStreamException {
		var a = TouristVouchersDirector.createTours(new StAXBuilder(), "src/test/resources/tourist_vouchers.xml");
		var b = ReferenceTouristVouchers.getTourList();
		Assert.assertEquals(a.getTouristVouchers(), b);
		System.out.println(a);
	}

}
