package gui;

import java.util.Calendar;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

public class DateListener implements SelectionListener {

	private PlannerInterface dayInterface;
	
	public DateListener(PlannerInterface dayInterface) {
		this.dayInterface = dayInterface;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		CalendarPop calenderPopup = dayInterface.calendarPopup;
		Calendar dateToLoad = calenderPopup.getSelectedDate();
		int daySelected = dateToLoad.get(Calendar.DAY_OF_WEEK);
		if(daySelected == Calendar.SATURDAY || daySelected == Calendar.SUNDAY)
		{
			return;
		}
		
		dayInterface.save();
		calenderPopup.setVisible(false);
		dayInterface.loadDate(dateToLoad);
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
	}

}
