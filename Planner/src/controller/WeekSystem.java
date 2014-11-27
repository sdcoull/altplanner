package controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import pdfout.PDFBuilder;
import data.SaveLoad;
import model.IPeriod;
import model.IWeek;
import model.Week;

public class WeekSystem {

	IWeek week;
	int day = 0;
	
	public void addPeriod(int periodNum, String className, String notes, String feeling) throws IOException, ClassNotFoundException
	{
		week.getDay(day).addPeriod(periodNum, className, notes, feeling);
		save();
	}
	
	public List<IPeriod> getDay()
	{
		return week.getDay(day).getPeriods();
	}

	public void save() throws IOException, ClassNotFoundException {
		SaveLoad save = new SaveLoad();
		save.saveWeek(week);
	}

	public void load(Calendar date) throws ClassNotFoundException {
		SaveLoad load = new SaveLoad();
		try
		{
			week= load.loadWeek(date);
		}
		catch(IOException e)
		{
			week = new Week(date);
		}
	}
	
	public String getClassName(int period)
	{
		List<IPeriod> p = week.getDay(day).getPeriods();
		for(IPeriod ps : p)
		{
			if(ps.getPeriodNumber() == period)
				return ps.getClassName();
		}
		return "";
	}

	public String getClassText(int period) {
		List<IPeriod> p = week.getDay(day).getPeriods();
		for(IPeriod ps : p)
		{
			if(ps.getPeriodNumber() == period)
				return ps.getNotes();
		}
		return "";
	}

	public void loadDay(String selection) {
		if(selection.equals("Monday"))
		{
			day = 0;
		}
		else if(selection.equals("Tuesday"))
		{
			day = 1;
		}
		else if(selection.equals("Wednesday"))
		{
			day = 2;
		}
		else if(selection.equals("Thursday"))
		{
			day = 3;
		}
		else
		{
			day = 4;
		}
	}

	public Calendar getDate() {
		return week.getDay(day).getDate();
	}

	public void addLunchClass(String text) {
		week.getDay(day).setLunchClass(text);
	}

	public void addCleaningClass(String text) {
		week.getDay(day).setCleaningClass(text);
	}

	public void addAfterSchool(String text) {
		week.getDay(day).setAfterSchool(text);
	}
	
	public String getLunchClass()
	{
		return week.getDay(day).getLunchClass();
	}
	
	public String getCleaningClass()
	{
		return week.getDay(day).getCleaningClass();
	}
	
	public String getAfterSchool()
	{
		return week.getDay(day).getAfterSchool();
	}

	public void createPDF() {
		PDFBuilder builder = new PDFBuilder();
		builder.create(week);
		
	}
	
}
