package gui;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

public class ComboListener implements SelectionListener {

	private PlannerInterface dayInterface;
	
	public ComboListener(PlannerInterface dayInterface) {
		this.dayInterface = dayInterface;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		String selection = dayInterface.getSelectedDay();
		dayInterface.save();
		dayInterface.loadDay(selection);
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
	}

}
