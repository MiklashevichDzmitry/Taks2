package com.epam.jwd.task2.parser.sax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.epam.jwd.task2.entity.AbstractTour;
import com.epam.jwd.task2.entity.Cruise;
import com.epam.jwd.task2.entity.Holiday;
import com.epam.jwd.task2.entity.Pilgrimage;
import com.epam.jwd.task2.entity.TouristVouchers;
import com.epam.jwd.task2.entity.Weekend;
import com.epam.jwd.task2.parser.XmlTourTags;

import java.time.YearMonth;
import java.util.Objects;

public class TourSAXParser extends DefaultHandler {

	private static final Logger LOGGER = LogManager.getLogger(TourSAXParser.class);

	private TouristVouchers tours;
	private String tag = null;
	private AbstractTour abstractTour;

	public TouristVouchers getTour() {
		return tours;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (Objects.equals(XmlTourTags.TOURISTVOUCHERS.getName(), qName)) {
			tours = new TouristVouchers();
			tag = null;
		} else if (Objects.equals(XmlTourTags.HOLIDAY.getName(), qName)) {
			abstractTour = new Holiday();
			setAttribute(attributes);
		} else if (Objects.equals(XmlTourTags.CRUISE.getName(), qName)) {
			abstractTour = new Cruise();
			setAttribute(attributes);

		} else if (Objects.equals(XmlTourTags.WEEKEND.getName(), qName)) {
			abstractTour = new Weekend();
			setAttribute(attributes);

		} else if (Objects.equals(XmlTourTags.PILGRIMAGE.getName(), qName)) {
			abstractTour = new Pilgrimage();
			setAttribute(attributes);

		} else {
			tag = qName;
		}

	}

	private void setAttribute(Attributes attributes) {
		String id = attributes.getValue(0);
		String advertisement = attributes.getValue(1);
		abstractTour.setTourCode(id);
		abstractTour.setAdvertisement(advertisement);
		tag = null;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		String s = new String(ch, start, length);

		if (tag != null && !s.contains("\n")) {
			if (Objects.equals(XmlTourTags.COMPANY.getName(), tag)) {
				abstractTour.setCompany(s);
			} else if (Objects.equals(XmlTourTags.COUNTRY.getName(), tag)) {
				abstractTour.setCountry(s);
			} else if (Objects.equals(XmlTourTags.DAYSNUMBER.getName(), tag)) {
				abstractTour.setDaysNumber(Integer.parseInt(s));
			} else if (Objects.equals(XmlTourTags.TRANSPORT.getName(), tag)) {
				abstractTour.setTransport(s);
			} else if (Objects.equals(XmlTourTags.TOURDATE.getName(), tag)) {
				YearMonth dateTime = YearMonth.parse(s);
				abstractTour.setTourDate(dateTime);
			} else if (Objects.equals(XmlTourTags.EXCURSION.getName(), tag)) {
				if (abstractTour instanceof Weekend) {
					((Weekend) abstractTour).setExcursion(Boolean.parseBoolean(s));
				} else if (abstractTour instanceof Pilgrimage) {
					((Pilgrimage) abstractTour).setExcursion(Boolean.parseBoolean(s));
				}
			} else {
				String cl = abstractTour.getClass().getName();
				LOGGER.info("this field is missing in the class" + cl);
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if (Objects.equals(XmlTourTags.HOLIDAY.getName(), qName) || Objects.equals(XmlTourTags.WEEKEND.getName(), qName)
				|| Objects.equals(XmlTourTags.PILGRIMAGE.getName(), qName)
				|| Objects.equals(XmlTourTags.CRUISE.getName(), qName)) {
			tours.add(abstractTour);
		}

	}
}
