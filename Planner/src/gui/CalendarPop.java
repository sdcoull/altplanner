package gui;

import java.util.Calendar;

import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.SWT;

public class CalendarPop extends Composite {

	private DateTime dateTime;
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public CalendarPop(Composite parent, int style) {
		super(parent, style);
		dateTime = new DateTime(this, SWT.BORDER | SWT.CALENDAR);
		dateTime.setBounds(0, 0, 139, 148);
		
		DateFocusListener focusListener = new DateFocusListener(this);
		dateTime.addMouseTrackListener(focusListener);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	
	public void addSelectionListener(SelectionListener sl)
	{
		dateTime.addSelectionListener(sl);
	}
	
	public Calendar getSelectedDate()
	{
		Calendar selectedDate = Calendar.getInstance();
		selectedDate.set(Calendar.YEAR, dateTime.getYear());
		selectedDate.set(Calendar.MONTH, dateTime.getMonth());
		selectedDate.set(Calendar.DAY_OF_MONTH, dateTime.getDay());
		return selectedDate;
	}
	
	public void setDate(int year, int month, int day)
	{
		dateTime.setDate(year, month, day);
	}
}
