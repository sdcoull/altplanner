package controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import pdfout.PDFBuilder;
import data.SaveLoad;
import model.IDay;
import model.IPeriod;
import model.IWeek;
import model.Week;

public class WeekSystem {

	IWeek week;
	IDay day;
	
	public void addPeriod(int periodNum, String className, String notes, String feeling) throws IOException, ClassNotFoundException
	{
		day.addPeriod(periodNum, className, notes, feeling);
	}
	
	public List<IPeriod> getDay()
	{
		return day.getPeriods();
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
		List<IPeriod> p = day.getPeriods();
		for(IPeriod ps : p)
		{
			if(ps.getPeriodNumber() == period)
				return ps.getClassName();
		}
		return "";
	}

	public String getClassText(int period) {
		List<IPeriod> p = day.getPeriods();
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
			day = week.getDay(0);
		}
		else if(selection.equals("Tuesday"))
		{
			day = week.getDay(1);
		}
		else if(selection.equals("Wednesday"))
		{
			day = week.getDay(2);
		}
		else if(selection.equals("Thursday"))
		{
			day = week.getDay(3);
		}
		else
		{
			day = week.getDay(4);
		}
	}

	public Calendar getDate() {
		return day.getDate();
	}

	public void addLunchClass(String text) {
		day.setLunchClass(text);
	}

	public void addCleaningClass(String text) {
		day.setCleaningClass(text);
	}

	public void addAfterSchool(String text) {
		day.setAfterSchool(text);
	}
	
	public String getLunchClass()
	{
		return day.getLunchClass();
	}
	
	public String getCleaningClass()
	{
		return day.getCleaningClass();
	}
	
	public String getAfterSchool()
	{
		return day.getAfterSchool();
	}

	public void createPDF() {
		PDFBuilder builder = new PDFBuilder();
		builder.create(week);
	}
	
}
