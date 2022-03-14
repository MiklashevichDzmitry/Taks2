package com.epam.jwd.task2.entity;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.HashSet;
import java.util.Set;

@XmlRootElement
public class TouristVouchers {
	
	 Set<Tour> touristVouchers;

	    public Set<Tour> getCandies() {
	        return touristVouchers;
	    }

	    @XmlElementWrapper
	    @XmlElements({
	            @XmlElement(type = Holiday.class, name = "holiday"),
	            @XmlElement(type = Cruise.class, name = "cruise"),
	            @XmlElement(type = Weekend.class, name = "weekend"),
	            @XmlElement(type = Pilgrimage.class, name = "pilgrimage")
	    })
	    public void setCandies(Set<Tour> touristVouchers) {
	        this.touristVouchers = touristVouchers;
	    }

	    public void add(Tour product) {
	        if (this.touristVouchers == null) {
	            this.touristVouchers = new HashSet<>();
	        }
	        this.touristVouchers.add(product);

	    }

}
