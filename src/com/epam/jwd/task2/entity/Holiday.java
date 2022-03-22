package com.epam.jwd.task2.entity;

import java.time.YearMonth;

public class Holiday extends AbstractTour {

	private static final long serialVersionUID = 1L;

	public Holiday() {

	}

	public static class HolidayBuilder {

		private Holiday holiday;

		public HolidayBuilder() {
			holiday = new Holiday();
		}

		public HolidayBuilder(Holiday holiday) {
			this.holiday = holiday;
		}

		public HolidayBuilder withDaysNumber(int daysNumber) {
			holiday.setDaysNumber(daysNumber);
			return this;
		}
		
		public HolidayBuilder withStrasrNumber(int starsNumber) {
			holiday.setStarsNumber(starsNumber);
			return this;
		}

		public HolidayBuilder withTourDate(YearMonth date) {
			holiday.setTourDate(date);
			return this;
		}

		public HolidayBuilder withCompany(String company) {
			holiday.setCompany(company);;
			return this;
		}

		public HolidayBuilder withID(String id) {
			holiday.setTourCode(id);
			return this;
		}

		public HolidayBuilder withTransport(String transport) {
			holiday.setTransport(transport);;
			return this;
		}

		public HolidayBuilder withCost(int cost) {
			holiday.setCost(cost);;
			return this;
		}
		
		public HolidayBuilder withCountry(String country) {
			holiday.setCountry(country);
			return this;
		}

		public HolidayBuilder withAdvertisement(String advertisement) {
			if (advertisement != null) {
			holiday.setAdvertisement(advertisement);
			}
			return this;
		}
		
		public HolidayBuilder withSubscriptionIndex(String advertisement) {
			holiday.setAdvertisement(advertisement);
			return this;
		}

		public Holiday build() {
			return holiday;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!super.equals(o)) {
			return false;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		return result;
	}

	@Override
	public String toString() {
		String className = this.getClass().getSimpleName();
		StringBuilder builder = new StringBuilder(className);
		builder.append('{').append(super.toString()).append('}');
		return builder.toString();
	}

}
