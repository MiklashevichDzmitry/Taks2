package com.epam.jwd.task2.entity;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.epam.jwd.task2.parser.YearMonthAdapter;

import java.io.Serializable;
import java.time.YearMonth;

@XmlType(name = "tour")
public abstract class AbstractTour implements Serializable {

	private static final long serialVersionUID = -3277035596610997101L;
	private String tourCode;
	private String advertisement;

	private YearMonth tourDate;
	private int cost;
	private int daysNumber;
	private int starsNumber;
	private String transport;
	private String company;
	private String country;

	@XmlAttribute(name = "tour_code")
	public String getTourCode() {
		return tourCode;
	}

	public void setTourCode(String tourCode) {
		this.tourCode = tourCode;
	}

	@XmlAttribute(name = "advertisement")
	public String getAdvertisement() {
		return tourCode;
	}

	public void setAdvertisement(String advertisement) {
		this.advertisement = advertisement;
	}

	@XmlElement(name = "company")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	@XmlElement(name = "cost")
	public int getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
	public int getStarsNumber() {
		return starsNumber;
	}
	
	public void setStarsNumber(Integer starsNumber) {
		this.starsNumber = starsNumber;
	}

	@XmlElement(name = "transport")
	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	@XmlJavaTypeAdapter(YearMonthAdapter.class)
	@XmlElement(name = "tour_date")
	public YearMonth getExpirationDate() {
		return tourDate;
	}

	public void setTourDate(YearMonth tourDate) {
		this.tourDate = tourDate;
	}

	@XmlElement(name = "days_number")
	public int getDaysNumber() {
		return daysNumber;
	}

	public void setDaysNumber(int daysNumber) {
		this.daysNumber = daysNumber;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) {
			return true;
		}
		if (o == null || o.getClass() != this.getClass()) {
			return false;
		}
		AbstractTour tour = (AbstractTour) o;
		if (tour.tourDate == null ? tourDate != null : !(tour.tourDate.equals(tourDate))) {
			return false;
		}
		
		if (tour.advertisement == null ? advertisement != null : !(tour.advertisement.equals(advertisement))) {
			return false;
		}
		
		return cost == tour.cost && tourCode.equals(tour.tourCode) && advertisement == tour.advertisement
				&& company.equals(tour.company) && transport == tour.transport && country == tour.country && daysNumber == tour.daysNumber;

	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + (tourCode == null ? 0 : tourDate.hashCode());
		result = prime * result + (country == null ? 0 : tourDate.hashCode());
		result = prime * result + (advertisement == null ? 0 : tourDate.hashCode());
		result = prime * result + company.hashCode();
		result = prime * result + (tourDate == null ? 0 : tourDate.hashCode());
		result = prime * result + cost;
		result = prime * result + daysNumber;
		result = prime * result + (transport == null ? 0 : transport.hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("tourCode='").append(tourCode).append('\'').append("advertisement='").append(advertisement).append('\'')
				.append(", company='").append(company).append('\'').append(", tourDate=").append(tourDate)
				.append(", cost=").append(cost).append(", daysNumber=").append(daysNumber).append(", transport=").append(transport);
		return builder.toString();
	}

}