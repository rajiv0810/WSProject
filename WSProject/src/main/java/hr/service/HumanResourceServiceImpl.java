package hr.service;

import java.util.Date;

public class HumanResourceServiceImpl implements HumanResourceService {

	public void bookLeave(Date startDate, Date endDate, String name) {
		System.out.println("Booking holiday for [" + startDate + "-" + endDate + "] for [" + name + "] ");
	}

}
