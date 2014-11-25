package model;

import java.util.Date;

public interface IWeek {
	Date getDate();
	IDay getDay(int day);
}
