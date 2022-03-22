package com.epam.jwd.task2.entity;

import java.time.YearMonth;

import javax.xml.bind.annotation.XmlElement;

public class Pilgrimage extends AbstractTour {
	
	private static final long serialVersionUID = 3796736371273322548L;
	private boolean isExcursionEnabled;

	public static class PilgrimageBuilder {

		private Pilgrimage pilgrimage;

		public PilgrimageBuilder() {
			pilgrimage = new Pilgrimage();
		}

		public PilgrimageBuilder(Pilgrimage pilgrimage) {
			this.pilgrimage = pilgrimage;
		}

		public PilgrimageBuilder withDaysNumber(int daysNumber) {
			pilgrimage.setDaysNumber(daysNumber);
			return this;
		}
		
		public PilgrimageBuilder withStrasrNumber(int starsNumber) {
			pilgrimage.setStarsNumber(starsNumber);
			return this;
		}

		public PilgrimageBuilder withTourDate(YearMonth date) {
			pilgrimage.setTourDate(date);
			return this;
		}

		public PilgrimageBuilder withCompany(String company) {
			pilgrimage.setCompany(company);;
			return this;
		}

		public PilgrimageBuilder withID(String id) {
			pilgrimage.setTourCode(id);
			return this;
		}

		public PilgrimageBuilder withTransport(String transport) {
			pilgrimage.setTransport(transport);;
			return this;
		}

		public PilgrimageBuilder withCost(int cost) {
			pilgrimage.setCost(cost);;
			return this;
		}
		
		public PilgrimageBuilder withCountry(String country) {
			pilgrimage.setCountry(country);
			return this;
		}

		public PilgrimageBuilder withAdvertisement(String advertisement) {
			if (advertisement != null) {
				pilgrimage.setAdvertisement(advertisement);
			}
			return this;
		}
		
		public PilgrimageBuilder withTourId(String tourid) {
			pilgrimage.setTourCode(tourid);
			return this;
		}
		
		public PilgrimageBuilder withExcursion(boolean excursion) {
			pilgrimage.setExcursion(excursion);
			return this;
		}

		public Pilgrimage build() {
			return pilgrimage;
		}
	}

	@XmlElement(name = "excursionEnabled")
	public boolean isExcursionEnabled() {
		return isExcursionEnabled;
	}

	public void setExcursion(boolean excursion) {
		isExcursionEnabled = excursion;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!super.equals(o)) {
			return false;
		}
		Pilgrimage that = (Pilgrimage) o;
		return isExcursionEnabled == that.isExcursionEnabled;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = result * prime + (isExcursionEnabled ? 1 : 0);
		return result;
	}

	@Override
	public String toString() {
		String className = this.getClass().getSimpleName();
		StringBuilder builder = new StringBuilder(className);
		builder.append('{').append(super.toString()).append(", isExcursionEnabled=").append(isExcursionEnabled)
				.append('}');
		return builder.toString();
	}

}
