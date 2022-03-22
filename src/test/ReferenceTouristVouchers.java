package test;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import com.epam.jwd.task2.entity.AbstractTour;
import com.epam.jwd.task2.entity.Cruise;
import com.epam.jwd.task2.entity.Holiday;
import com.epam.jwd.task2.entity.Pilgrimage;
import com.epam.jwd.task2.entity.Weekend;

public class ReferenceTouristVouchers {

	private static List<AbstractTour> tourList = new ArrayList<>();

	public static List<AbstractTour> getTourList() {

		AbstractTour tour = new Holiday.HolidayBuilder().withCompany("Dream").withCountry("Turkey")
				.withTourDate(YearMonth.of(2022, 06)).withDaysNumber(10).withStrasrNumber(2).withTransport("plain")
				.withCost(1300).build();

		tourList.add(tour);

		tour = new Weekend.WeekendBuilder().withCompany("Dream").withCountry("Turkey")
				.withTourDate(YearMonth.of(2022, 06)).withDaysNumber(10).withStrasrNumber(2).withTransport("plain")
				.withCost(1300).build();;

		tourList.add(tour);

		tour = new Cruise.CruiseBuilder().withCompany("Dream").withCountry("Turkey")
				.withTourDate(YearMonth.of(2022, 06)).withDaysNumber(10).withStrasrNumber(2).withTransport("plain")
				.withCost(1300).build();;

		tour = new Pilgrimage.PilgrimageBuilder().withCompany("Dream").withCountry("Turkey")
				.withTourDate(YearMonth.of(2022, 06)).withDaysNumber(10).withStrasrNumber(2).withTransport("plain")
				.withCost(1300).build();;

		tourList.add(tour);

		return tourList;
	}

}
