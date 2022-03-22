package com.epam.jwd.task2.entity;

import java.time.YearMonth;

public class Cruise extends AbstractTour {

	private static final long serialVersionUID = 1L;

	public static class CruiseBuilder {

		private Cruise cruise;

		public CruiseBuilder() {
			cruise = new Cruise();
		}

		public CruiseBuilder(Cruise cruise) {
			this.cruise = cruise;
		}

		public CruiseBuilder withDaysNumber(int daysNumber) {
			cruise.setDaysNumber(daysNumber);
			return this;
		}
		
		public CruiseBuilder withStrasrNumber(int starsNumber) {
			cruise.setStarsNumber(starsNumber);
			return this;
		}

		public CruiseBuilder withTourDate(YearMonth date) {
			cruise.setTourDate(date);
			return this;
		}

		public CruiseBuilder withCompany(String company) {
			cruise.setCompany(company);;
			return this;
		}

		public CruiseBuilder withID(String id) {
			cruise.setTourCode(id);
			return this;
		}

		public CruiseBuilder withTransport(String transport) {
			cruise.setTransport(transport);;
			return this;
		}

		public CruiseBuilder withCost(int cost) {
			cruise.setCost(cost);;
			return this;
		}
		
		public CruiseBuilder withCountry(String country) {
			cruise.setCountry(country);
			return this;
		}

		public CruiseBuilder withAdvertisement(String advertisement) {
			if (advertisement != null) {
				cruise.setAdvertisement(advertisement);
			}
			return this;
		}
		
		public CruiseBuilder withTourId(String tourid) {
			cruise.setTourCode(tourid);
			return this;
		}

		public Cruise build() {
			return cruise;
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
		builder.append('{').append(super.toString())
				.append('}');
		return builder.toString();
	}
	
}
