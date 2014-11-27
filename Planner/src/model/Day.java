		package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Day implements IDay, Serializable {
	
	private static final long serialVersionUID = -3548026173824024294L;
	private ArrayList<IPeriod> periods = new ArrayList<IPeriod>();
	private Calendar date;
	private String lunchClass = "";
	private String cleaningClass = "";
	private String afterSchool = "";
	
	public Day(Calendar date)
	{
		this.date = date;
		for(int i = 0; i < 6; i++)
		{
			IPeriod period = new Period(i, "", "", "");
			periods.add(period);
		}
	}

	@Override
	public ArrayList<IPeriod> getPeriods() {
		return periods;
	}

	@Override
	public void addPeriod(int periodNum, String className, String notes, String feeling) {
		for(IPeriod p:periods)
		{
			if(p.getPeriodNumber() == periodNum)
			{
				IPeriod period = new Period(periodNum, className, notes, feeling);
				periods.remove(periodNum-1);
				periods.add(periodNum-1, period);
				return;
			}
		}
	}

	@Override
	public Calendar getDate() {
		return date;
	}
	
	public String getLunchClass() {
		return lunchClass;
	}

	public void setLunchClass(String lunchClass) {
		this.lunchClass = lunchClass;
	}

	public String getCleaningClass() {
		return cleaningClass;
	}

	public void setCleaningClass(String cleaningClass) {
		this.cleaningClass = cleaningClass;
	}

	public String getAfterSchool() {
		return afterSchool;
	}

	public void setAfterSchool(String afterSchool) {
		this.afterSchool = afterSchool;
	}
}
