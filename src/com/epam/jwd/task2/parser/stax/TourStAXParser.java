package com.epam.jwd.task2.parser.stax;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.jwd.task2.entity.*;
import com.epam.jwd.task2.parser.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.YearMonth;
import java.util.Objects;

public class TourStAXParser {

	private static final Logger LOGGER = LogManager.getLogger(TourStAXParser.class);
	private TouristVouchers tour;
	private XMLInputFactory inputFactory;

	public TourStAXParser() {
		inputFactory = XMLInputFactory.newInstance();
		tour = new TouristVouchers();
	}

	public TouristVouchers getTour() {
		return tour;
	}

	public void buildCatalog(String fileName) {
		FileInputStream inputStream = null;
		XMLStreamReader reader;
		String name;
		try {
			inputStream = new FileInputStream(new File(fileName));
			reader = inputFactory.createXMLStreamReader(inputStream);
			while (reader.hasNext()) {
				int type = reader.next();
				if (type == XMLStreamConstants.START_ELEMENT) {
					name = reader.getLocalName();
					if (Objects.equals(name, XmlTourTags.HOLIDAY.getName())) {
						var a = buildHoliday(reader);
						tour.add(a);
					}
					if (Objects.equals(name, XmlTourTags.CRUISE.getName())) {
						var a = buildCruise(reader);
						tour.add(a);
					}
					if (Objects.equals(name, XmlTourTags.WEEKEND.getName())) {
						var a = buildWeekend(reader);
						tour.add(a);
					}

					if (Objects.equals(name, XmlTourTags.PILGRIMAGE.getName())) {
						var a = buildPilgrimage(reader);
						tour.add(a);
					}
				}
			}
		} catch (XMLStreamException ex) {
			LOGGER.log(Level.ERROR, "StAX parsing error! " + ex.getMessage());
		} catch (FileNotFoundException ex) {
			LOGGER.log(Level.ERROR, "File " + fileName + " not found! " + ex);
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				LOGGER.log(Level.ERROR, "Impossible close file " + fileName + " : " + e);
			}
		}
	}

	private AbstractTour buildHoliday(XMLStreamReader reader) throws XMLStreamException {
		Holiday holiday = new Holiday();
		holiday.setTourCode(reader.getAttributeValue(null, XmlTourTags.TOURCODE.getName()));
		holiday.setAdvertisement(reader.getAttributeValue(null, XmlTourTags.ADVERTISEMENT.getName()));
		String name;
		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				name = reader.getLocalName();
				tourInit(holiday, reader, name);
				break;
			case XMLStreamConstants.END_ELEMENT:
				name = reader.getLocalName();
				if (Objects.equals(name, XmlTourTags.HOLIDAY.getName())) {
					return holiday;
				}
				break;
			}
		}
		return null;
	}

	private AbstractTour buildCruise(XMLStreamReader reader) throws XMLStreamException {
		Cruise booklet = new Cruise();
		booklet.setTourCode(reader.getAttributeValue(null, XmlTourTags.TOURCODE.getName()));
		booklet.setAdvertisement(reader.getAttributeValue(null, XmlTourTags.ADVERTISEMENT.getName()));
		String name;
		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				name = reader.getLocalName();
				tourInit(booklet, reader, name);
				break;
			case XMLStreamConstants.END_ELEMENT:
				name = reader.getLocalName();
				if (Objects.equals(name, XmlTourTags.CRUISE.getName())) {
					return booklet;
				}
				break;
			}
		}
		return null;
	}

	private AbstractTour buildWeekend(XMLStreamReader reader) throws XMLStreamException {
		Weekend weekend = new Weekend();
		weekend.setTourCode(reader.getAttributeValue(null, XmlTourTags.TOURCODE.getName()));
		String name;
		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				name = reader.getLocalName();
				tourInit(weekend, reader, name);
				if (Objects.equals(name, XmlTourTags.EXCURSION.getName())) {
					weekend.setExcursion(Boolean.parseBoolean(getXMLText(reader)));
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				name = reader.getLocalName();
				if (Objects.equals(name, XmlTourTags.WEEKEND.getName())) {
					return weekend;
				}
				break;
			}
		}
		return null;
	}

	private AbstractTour buildPilgrimage(XMLStreamReader reader) throws XMLStreamException {
		Pilgrimage pilgrimage = new Pilgrimage();
		pilgrimage.setTourCode(reader.getAttributeValue(null, XmlTourTags.TOURCODE.getName()));
		String name;
		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				name = reader.getLocalName();
				tourInit(pilgrimage, reader, name);
				if (Objects.equals(name, XmlTourTags.EXCURSION.getName())) {
					pilgrimage.setExcursion(Boolean.parseBoolean(getXMLText(reader)));
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				name = reader.getLocalName();
				if (Objects.equals(name, XmlTourTags.WEEKEND.getName())) {
					return pilgrimage;
				}
				break;
			}
		}
		return null;
	}

	private void tourInit(AbstractTour tour, XMLStreamReader reader, String name) throws XMLStreamException {
		switch (Objects.requireNonNull(XmlTourTags.getXmlPublicationWord(name))) {
		case COMPANY:
			tour.setCompany(getXMLText(reader));
			break;
		case COUNTRY:
			tour.setCountry(getXMLText(reader));
			break;
		case TOURDATE:
			tour.setTourDate(YearMonth.parse(getXMLText(reader)));
			break;
		case DAYSNUMBER:
			tour.setDaysNumber(Integer.parseInt(getXMLText(reader)));
			break;
		case TRANSPORT:
			tour.setTransport(getXMLText(reader));
			break;
		case COST:
			tour.setCost(Integer.parseInt(getXMLText(reader)));
			break;
		default:
			break;
		}
	}

	private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
		String text = null;
		if (reader.hasNext()) {
			reader.next();
			text = reader.getText();
		}
		return text;
	}
}
