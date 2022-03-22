package com.epam.jwd.task2.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.HashSet;
import java.util.Set;

@XmlRootElement
public class TouristVouchers {

	Set<AbstractTour> touristVouchers;

	public Set<AbstractTour> getTouristVouchers() {
		return touristVouchers;
	}

	@XmlElementWrapper
	@XmlElements({@XmlElement(type = Weekend.class, name = "weekend"),
			@XmlElement(type = Pilgrimage.class, name = "pilgrimage") })
	public void setTours(Set<AbstractTour> touristVouchers) {
		this.touristVouchers = touristVouchers;
	}

	public void add(AbstractTour tour) {
		if (this.touristVouchers == null) {
			this.touristVouchers = new HashSet<>();
		}
		this.touristVouchers.add(tour);

	}

}
