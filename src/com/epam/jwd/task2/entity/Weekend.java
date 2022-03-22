package com.epam.jwd.task2.entity;

import java.time.YearMonth;

import javax.xml.bind.annotation.XmlElement;

public class Weekend extends AbstractTour {

	private static final long serialVersionUID = 3796736371273322548L;
	private boolean isExcursionEnabled;

	public static class WeekendBuilder {

		private Weekend weekend;

		public WeekendBuilder() {
			weekend = new Weekend();
		}

		public WeekendBuilder(Weekend pilgrimage) {
			this.weekend = pilgrimage;
		}

		public WeekendBuilder withDaysNumber(int daysNumber) {
			weekend.setDaysNumber(daysNumber);
			return this;
		}
		
		public WeekendBuilder withStrasrNumber(int starsNumber) {
			weekend.setStarsNumber(starsNumber);
			return this;
		}

		public WeekendBuilder withTourDate(YearMonth date) {
			weekend.setTourDate(date);
			return this;
		}

		public WeekendBuilder withCompany(String company) {
			weekend.setCompany(company);;
			return this;
		}

		public WeekendBuilder withID(String id) {
			weekend.setTourCode(id);
			return this;
		}

		public WeekendBuilder withTransport(String transport) {
			weekend.setTransport(transport);;
			return this;
		}

		public WeekendBuilder withCost(int cost) {
			weekend.setCost(cost);;
			return this;
		}
		
		public WeekendBuilder withCountry(String country) {
			weekend.setCountry(country);
			return this;
		}

		public WeekendBuilder withAdvertisement(String advertisement) {
			if (advertisement != null) {
				weekend.setAdvertisement(advertisement);
			}
			return this;
		}
		
		public WeekendBuilder withTourId(String tourid) {
			weekend.setTourCode(tourid);
			return this;
		}
		
		public WeekendBuilder withExcursion(boolean excursion) {
			weekend.setExcursion(excursion);
			return this;
		}

		public Weekend build() {
			return weekend;
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
		Weekend that = (Weekend) o;
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
