package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Week implements IWeek, Serializable {
	
	private static final long serialVersionUID = -6717146510722638865L;
	private List<IDay> days = new ArrayList<IDay>();
	private Calendar date;

	public Week(Calendar date) {
		this.date = date;
		createDays();
	}
	
	private void createDays()
	{
		Calendar c1 = (Calendar) date.clone();
		c1.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		days.add(new Day(c1));
		
		Calendar c2 = (Calendar) date.clone();
		c2.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		days.add(new Day(c2));
		
		Calendar c3 = (Calendar) date.clone();
		c3.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		days.add(new Day(c3));
		
		Calendar c4 = (Calendar) date.clone();
		c4.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		days.add(new Day(c4));
		
		Calendar c5 = (Calendar) date.clone();
		c5.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		days.add(new Day(c5));
	}

	@Override
	public Date getDate() {
		return date.getTime();
	}

	@Override
	public IDay getDay(int day) {
		return days.get(day);
	}

}
