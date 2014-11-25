package model;

import java.util.Calendar;
import java.util.List;

public interface IDay {
	List<IPeriod> getPeriods();
	void addPeriod(int periodNum, String className, String notes, String feeling);
	Calendar getDate();
	void setLunchClass(String text);
	void setCleaningClass(String text);
	void setAfterSchool(String text);
	String getLunchClass();
	String getCleaningClass();
	String getAfterSchool();
}
