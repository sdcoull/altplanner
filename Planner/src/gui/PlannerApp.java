package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;

public class PlannerApp {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PlannerApp window = new PlannerApp();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell(SWT.TITLE | SWT.CLOSE | SWT.BORDER);
		shell.setSize(713, 226);
		shell.setText("ALT Planner");
		
		CalendarPop calendarComp = new CalendarPop(shell, SWT.NONE);
		calendarComp.setBounds(5, 5, 139, 148);
		
		Composite composite = new PlannerInterface(shell, SWT.NONE, calendarComp);
		composite.setBounds(0, 0, 713, 200);
	}
}
