package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import data.UserPreferences;

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

	private void confirmSettings() {
		UserPreferences userPrefs = new UserPreferences();
		if(userPrefs.isFirstTime())
		{
			Settings settings = new Settings(Display.getDefault());
			settings.open();
			userPrefs.setNotFirstTime();
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
		confirmSettings();
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
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem mntmFile = new MenuItem(menu, SWT.CASCADE);
		mntmFile.setText("File");
		
		Menu menu_1 = new Menu(mntmFile);
		mntmFile.setMenu(menu_1);
		
		MenuItem mntmSettings = new MenuItem(menu_1, SWT.NONE);
		mntmSettings.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Settings settings = new Settings(Display.getDefault());
				settings.open();
			}
		});
		mntmSettings.setText("Settings");
	}
}
