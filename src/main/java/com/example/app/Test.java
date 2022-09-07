package com.example.app;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Test {

	public static void main(String[] args) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.ENGLISH);
		Calendar cal = Calendar.getInstance();

		Date currentDate = cal.getTime();

		String todaysdate = dateFormat.format(currentDate);
		String todayDay = dayFormat.format(currentDate);

		String date = "FutureDate";

		switch (date) {
		case "PreviousDate":

			cal.add(Calendar.DATE, -1);

			Date previousDate = cal.getTime();
			String previousDay = dayFormat.format(previousDate);

			if ("Sunday".equals(previousDay)) {
				cal.add(Calendar.DATE, -2);
				previousDate = cal.getTime();
			} else if ("Saturday".equals(previousDay)) {
				cal.add(Calendar.DATE, -1);
				previousDate = cal.getTime();
			}

			System.out.println(previousDate);

			break;
		case "FutureDate":

			cal.add(Calendar.DATE, 1);

			Date futureDate = cal.getTime();
			String futureDay = dayFormat.format(futureDate);

			if ("Saturday".equals(futureDay)) {
				cal.add(Calendar.DATE, 2);
				futureDate = cal.getTime();
			} else if ("Sunday".equals(futureDay)) {
				cal.add(Calendar.DATE, 1);
				futureDate = cal.getTime();
			}

			System.out.println(futureDate);

			break;

		default:

			System.out.println(todaysdate);
			System.out.println(todayDay);

			break;
		}

	}

}
