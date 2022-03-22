package com.epam.jwd.task2.parser;

import java.util.Objects;

public enum XmlTourTags {

	TOURISTVOUCHERS("tourist_vouchers"), HOLIDAY("holiday"), WEEKEND("weekend"),
	CRUISE("cruise"), PILGRIMAGE("pilgrimage"), TOURCODE("tour_code"),
	ADVERTISEMENT("advertisement"), COMPANY("company"), COUNTRY("country"), TOURDATE("tour_date"),
	DAYSNUMBER("days_number"), TRANSPORT("transport"), COST("cost"), STARSNUMBER("stars_number"),
	EXCURSION("excursion");

	private String name;

	public String getName() {
		return name;
	}

	XmlTourTags(String name) {
		this.name = name;
	}

	public static XmlTourTags getXmlPublicationWord(String name) {
		for (XmlTourTags word : XmlTourTags.values()) {
			if (Objects.equals(word.name, name))
				return word;
		}
		return null;
	}

}
