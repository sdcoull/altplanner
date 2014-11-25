package model;

import java.io.Serializable;

public class Period implements IPeriod, Serializable {
	
	private static final long serialVersionUID = -4978688963512739960L;
	int periodNumber;
	String className;
	String notes;
	String feeling;
	
	public Period(int periodNumber, String className, String getNotes, String getFeeling)
	{
		this.periodNumber = periodNumber;
		this.className = className;
		this.notes = getNotes;
		this.feeling = getFeeling;
	}

	@Override
	public int getPeriodNumber() {
		return periodNumber;
	}

	@Override
	public String getClassName() {
		return className;
	}

	@Override
	public String getNotes() {
		return notes;
	}

	@Override
	public String getFeeling() {
		return feeling;
	}

}
