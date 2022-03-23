package com.epam.jwd.task2.parser.dom;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.epam.jwd.task2.entity.AbstractTour;
import com.epam.jwd.task2.entity.Cruise;
import com.epam.jwd.task2.entity.Holiday;
import com.epam.jwd.task2.entity.Pilgrimage;
import com.epam.jwd.task2.entity.TouristVouchers;
import com.epam.jwd.task2.entity.Weekend;
import com.epam.jwd.task2.parser.XmlTourTags;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.YearMonth;

public class TourDOMParser {

	private static final Logger LOGGER = LogManager.getLogger(TourDOMParser.class);
	private TouristVouchers tours;
	private DocumentBuilder docBuilder;

	public TourDOMParser() {
		this.tours = new TouristVouchers();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			docBuilder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			LOGGER.log(Level.ERROR, "configuration parser error: " + e);
		}
	}

	public TouristVouchers getTours() {
		return tours;
	}

	public void buildTour(String fileName) {
		Document doc = null;
		try {
			doc = docBuilder.parse(fileName);
			Element root = doc.getDocumentElement();
			NodeList tourList = root.getElementsByTagName("weekend");
			for (int i = 0; i < tourList.getLength(); i++) {
				Element tour = (Element) tourList.item(i);
				AbstractTour abstractTour = buildWeekend(tour);
				tours.add(abstractTour);
			}
			tourList = root.getElementsByTagName("pilgrimage");
			for (int i = 0; i < tourList.getLength(); i++) {
				Element tour = (Element) tourList.item(i);
				AbstractTour abstractTour = buildPilgrimage(tour);
				tours.add(abstractTour);
			}
			tourList = root.getElementsByTagName("cruise");
			for (int i = 0; i < tourList.getLength(); i++) {
				Element tour = (Element) tourList.item(i);
				AbstractTour abstractPublication = buildCruise(tour);
				tours.add(abstractPublication);
			}
			tourList = root.getElementsByTagName("holiday");
			for (int i = 0; i < tourList.getLength(); i++) {
				Element tour = (Element) tourList.item(i);
				AbstractTour abstractPublication = buildHoliday(tour);
				tours.add(abstractPublication);
			}
		} catch (IOException e) {
			LOGGER.log(Level.ERROR, "File error or I/O error: " + e);
		} catch (SAXException e) {
			LOGGER.log(Level.ERROR, "Parsing failure: " + e);
		}
	}

	private AbstractTour buildCruise(Element element) {
		AbstractTour tour = new Cruise();
		tourInit(tour, element);

		return tour;
	}

	private AbstractTour buildHoliday(Element element) {
		AbstractTour tour = new Holiday();
		tourInit(tour, element);

		return tour;
	}

	private AbstractTour buildPilgrimage(Element tour) {
		Pilgrimage pilgrimage = new Pilgrimage();
		tourInit(pilgrimage, tour);
		pilgrimage.setExcursion(Boolean.parseBoolean(XmlTourTags.EXCURSION.getName()));

		return pilgrimage;
	}

	private AbstractTour buildWeekend(Element tour) {
		Weekend weekend = new Weekend();
		tourInit(weekend, tour);
		weekend.setExcursion(Boolean.parseBoolean(XmlTourTags.EXCURSION.getName()));
		return weekend;
	}

	private void tourInit(AbstractTour tour, Element element) {
		tour.setTourCode(element.getAttribute(XmlTourTags.TOURCODE.getName()));
		if (element.hasAttribute("advertisement")) {
			tour.setAdvertisement(element.getAttribute(XmlTourTags.ADVERTISEMENT.getName()));
		}
		tour.setCompany(getElementTextContent(element, XmlTourTags.COMPANY.getName()));
		tour.setTourDate(getElementYearMonthContent(element, XmlTourTags.TOURDATE.getName()));
		tour.setCost(Integer.parseInt(getElementTextContent(element, XmlTourTags.COST.getName())));
		tour.setTransport(getElementTextContent(element, XmlTourTags.TRANSPORT.getName()));
		tour.setStarsNumber(Integer.parseInt(getElementTextContent(element, XmlTourTags.STARSNUMBER.getName())));
		tour.setDaysNumber(Integer.parseInt(getElementTextContent(element, XmlTourTags.DAYSNUMBER.getName())));
	}

	private static String getElementTextContent(Element element, String elementName) {
		NodeList nList = element.getElementsByTagName(elementName);
		Node node = nList.item(0);
		return node.getTextContent();
	}

	private YearMonth getElementYearMonthContent(Element element, String tagName) {
		String yearMonthString = getElementTextContent(element, tagName);
		return YearMonth.parse(yearMonthString);
	}

}
