package gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import data.UserPreferences;

public class Settings extends Shell {

	private UserPreferences userPrefs = new UserPreferences();
	protected Shell shell;
	private Text nameTxt;
	private Text schoolTxt;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Display display = Display.getDefault();
			Settings shell = new Settings(display);
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public Settings(Display display) {
		super(display, SWT.APPLICATION_MODAL | SWT.TITLE | SWT.CLOSE | SWT.BORDER);
		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Settings (v1.0 BETA)");
		setSize(499, 168);
		
		Group grpAltInformation = new Group(this, SWT.NONE);
		grpAltInformation.setBounds(0, 61, 498, 63);
		
		Label lblName = new Label(grpAltInformation, SWT.NONE);
		lblName.setBounds(10, 10, 59, 14);
		lblName.setText("Name:");
		
		nameTxt = new Text(grpAltInformation, SWT.BORDER);
		nameTxt.setBounds(67, 7, 417, 19);
		nameTxt.setText(userPrefs.getValue(UserPreferences.USERNAME));
		
		Label lblSchool = new Label(grpAltInformation, SWT.NONE);
		lblSchool.setBounds(10, 33, 59, 14);
		lblSchool.setText("School:");
		
		schoolTxt = new Text(grpAltInformation, SWT.BORDER);
		schoolTxt.setBounds(67, 30, 417, 19);
		schoolTxt.setText(userPrefs.getValue(UserPreferences.SCHOOLNAME));
		
		Button btnSave = new Button(this, SWT.NONE);
		btnSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				userPrefs.setValue(UserPreferences.USERNAME, nameTxt.getText());
				userPrefs.setValue(UserPreferences.SCHOOLNAME, schoolTxt.getText());
				close();
			}
		});
		btnSave.setBounds(306, 119, 94, 28);
		btnSave.setText("Save");
		
		Button btnCancel = new Button(this, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				close();
			}
		});
		btnCancel.setBounds(398, 119, 94, 28);
		btnCancel.setText("Cancel");
		
		Group group = new Group(this, SWT.NONE);
		group.setBounds(0, 0, 498, 55);
		
		Label lblAltPlannerV = new Label(group, SWT.WRAP);
		lblAltPlannerV.setBounds(10, 8, 475, 31);
		lblAltPlannerV.setText("Thank you, you wonderful people, for giving this app a try!! It's people like you who make the world awesome :)");
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
