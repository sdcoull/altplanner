package gui;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class SaveListener implements Listener {

	private PlannerInterface di;
	
	public SaveListener(PlannerInterface d)
	{
		di = d;
	}

	@Override
	public void handleEvent(Event event) {
		di.save();
	}
}