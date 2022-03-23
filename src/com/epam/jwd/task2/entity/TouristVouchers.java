package com.epam.jwd.task2.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@XmlRootElement
public class TouristVouchers {

	/*Set<AbstractTour> touristVouchers;

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

	}*/
	
	private List<AbstractTour> tours;

    public List<AbstractTour> getTouristVouchers() {
        return new ArrayList<>(tours);
    }

    public void setTouristVouchers(List<AbstractTour> tours) {
        this.tours = tours;
    }

    public TouristVouchers() {
    	tours = new ArrayList<>();
    }

    public void add(AbstractTour tour) {
    	tours.add(tour);
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "publications=" + tours +
                '}';
    }

}
