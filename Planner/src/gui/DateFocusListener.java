package gui;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackListener;


public class DateFocusListener implements MouseTrackListener {

	CalendarPop calendarPop;
	
	public DateFocusListener(CalendarPop calendarPop) {
		this.calendarPop = calendarPop;
	}

	@Override
	public void mouseEnter(MouseEvent e) {
	}

	@Override
	public void mouseExit(MouseEvent e) {
		calendarPop.setVisible(false);
	}

	@Override
	public void mouseHover(MouseEvent e) {
	}

}
