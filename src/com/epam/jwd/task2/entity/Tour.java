package com.epam.jwd.task2.entity;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.Serializable;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@XmlType(propOrder = {"company", "country", "tour_date", "days_number", "transport", "hotels", "cost"}, name = "tour")
public abstract class Tour implements Serializable {
   
	private static final long serialVersionUID = -3277035596610997101L;
    private String tourCode;
    private String tourType;

    private YearMonth tourDate;
    private int cost;
    private int daysNumber;
    private String transport;

    private List<Hotel> hotels;
    private Company production;

    {
    	hotels = new ArrayList<>();
    }

    public Tour() {
    }

    @Override
    public boolean equals(Object o) {
       
    }

    @Override
    public int hashCode() {
       
    }

    @Override
    public String toString() {
      
    }
}