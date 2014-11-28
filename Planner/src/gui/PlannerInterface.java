package gui;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;

import controller.WeekSystem;

import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class PlannerInterface extends Composite {

	private WeekSystem daySystem = new WeekSystem();
	private SaveListener saveListener = new SaveListener(this);
	private ComboListener comboListener = new ComboListener(this);
	public CalendarPop calendarPopup;

	private Text textClass1;
	private Text textNotes1;
	private Group group_1;
	private Text textClass2;
	private Text textNotes2;
	private Group group_2;
	private Text textClass3;
	private Text textNotes3;
	private Group group_3;
	private Text textClass4;
	private Text textNotes4;
	private Group group_4;
	private Text textClass5;
	private Text textNotes5;
	private Group group_5;
	private Text textClass6;
	private Text textNotes6;
	private Combo combo;
	private Text textLunchClass;
	private Text textCleaningClass;
	private Text textAfterSchool;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public PlannerInterface(final Composite parent, int style, final CalendarPop calendarPopup) {
		super(parent, style);
		this.calendarPopup = calendarPopup;

		Group group = new Group(this, SWT.NONE);
		group.setBounds(0, 31, 113, 127);

		textClass1 = new Text(group, SWT.BORDER | SWT.CENTER);
		textClass1.setBounds(10, 10, 89, 19);
		textClass1.setMessage("Class 1");
		textClass1.setText("");
		textClass1.addListener(SWT.FocusOut, saveListener);

		textNotes1 = new Text(group, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		textNotes1.setMessage("Notes");
		textNotes1.setBounds(10, 35, 89, 78);
		textNotes1.addListener(SWT.FocusOut, saveListener);

		group_1 = new Group(this, SWT.NONE);
		group_1.setBounds(119, 31, 113, 127);

		textClass2 = new Text(group_1, SWT.BORDER | SWT.CENTER);
		textClass2.setMessage("Class 2");
		textClass2.setText("");
		textClass2.setBounds(10, 10, 89, 19);
		textClass2.addListener(SWT.FocusOut, saveListener);

		textNotes2 = new Text(group_1, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		textNotes2.setMessage("Notes");
		textNotes2.setBounds(10, 35, 89, 78);
		textNotes2.addListener(SWT.FocusOut, saveListener);

		group_2 = new Group(this, SWT.NONE);
		group_2.setBounds(238, 31, 113, 127);

		textClass3 = new Text(group_2, SWT.BORDER | SWT.CENTER);
		textClass3.setMessage("Class 3");
		textClass3.setText("");
		textClass3.setBounds(10, 10, 89, 19);
		textClass3.addListener(SWT.FocusOut, saveListener);

		textNotes3 = new Text(group_2, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		textNotes3.setMessage("Notes");
		textNotes3.setBounds(10, 35, 89, 78);
		textNotes3.addListener(SWT.FocusOut, saveListener);

		group_3 = new Group(this, SWT.NONE);
		group_3.setBounds(357, 31, 113, 127);

		textClass4 = new Text(group_3, SWT.BORDER | SWT.CENTER);
		textClass4.setMessage("Class 4");
		textClass4.setText("");
		textClass4.setBounds(10, 10, 89, 19);
		textClass4.addListener(SWT.FocusOut, saveListener);

		textNotes4 = new Text(group_3, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		textNotes4.setMessage("Notes");
		textNotes4.setBounds(10, 35, 89, 78);
		textNotes4.addListener(SWT.FocusOut, saveListener);

		group_4 = new Group(this, SWT.NONE);
		group_4.setBounds(476, 31, 113, 127);

		textClass5 = new Text(group_4, SWT.BORDER | SWT.CENTER);
		textClass5.setMessage("Class 5");
		textClass5.setText("");
		textClass5.setBounds(10, 10, 89, 19);
		textClass5.addListener(SWT.FocusOut, saveListener);

		textNotes5 = new Text(group_4, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		textNotes5.setMessage("Notes");
		textNotes5.setBounds(10, 35, 89, 78);
		textNotes5.addListener(SWT.FocusOut, saveListener);

		group_5 = new Group(this, SWT.NONE);
		group_5.setBounds(595, 31, 113, 127);

		textClass6 = new Text(group_5, SWT.BORDER | SWT.CENTER);
		textClass6.setMessage("Class 6");
		textClass6.setText("");
		textClass6.setBounds(10, 10, 89, 19);
		textClass6.addListener(SWT.FocusOut, saveListener);

		textNotes6 = new Text(group_5, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		textNotes6.setMessage("Notes");
		textNotes6.setBounds(10, 35, 89, 78);
		textNotes6.addListener(SWT.FocusOut, saveListener);

		combo = new Combo(this, SWT.READ_ONLY);
		combo.setBounds(92, 3, 113, 27);
		combo.add("Monday");
		combo.add("Tuesday");
		combo.add("Wednesday");
		combo.add("Thursday");
		combo.add("Friday");
		combo.addSelectionListener(comboListener);
		
		Group group_6 = new Group(this, SWT.NONE);
		group_6.setBounds(0, 157, 708, 43);
		
		textLunchClass = new Text(group_6, SWT.BORDER | SWT.CENTER);
		textLunchClass.setBounds(10, 10, 98, 19);
		textLunchClass.setMessage("Lunch Class");
		textLunchClass.addListener(SWT.FocusOut, saveListener);
		
		textCleaningClass = new Text(group_6, SWT.BORDER | SWT.CENTER);
		textCleaningClass.setBounds(114, 10, 98, 19);
		textCleaningClass.setMessage("Cleaning Class");
		textCleaningClass.addListener(SWT.FocusOut, saveListener);
		
		textAfterSchool = new Text(group_6, SWT.BORDER | SWT.CENTER);
		textAfterSchool.setBounds(218, 10, 476, 19);
		textAfterSchool.setMessage("After School");
		textAfterSchool.addListener(SWT.FocusOut, saveListener);
		
		Button btnCreatePdf = new Button(this, SWT.NONE);
		btnCreatePdf.setBounds(595, 3, 113, 28);
		btnCreatePdf.setText("Create PDF");
		btnCreatePdf.addSelectionListener(new SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e) {	
					save();
					daySystem.createPDF();
			}
		});
		
		Button btnCalendar = new Button(this, SWT.NONE);
		btnCalendar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				calendarPopup.setVisible(true);
				calendarPopup.setFocus();
			}
		});
		btnCalendar.setBounds(0, 3, 94, 28);
		btnCalendar.setText("Calendar");
		
		//After normal code
		loadWeek(Calendar.getInstance());
		parent.addListener(SWT.Close, saveListener);
		calendarPopup.setVisible(false);
		calendarPopup.addSelectionListener(new DateListener(this));
	}

	protected void loadWeek(Calendar dateToLoad) {
		try {
			daySystem.load(dateToLoad);
			SimpleDateFormat sdf1 = new SimpleDateFormat("EEEE");
			String dayOfWeek = sdf1.format(dateToLoad.getTime());
			int index = Arrays.asList(combo.getItems()).indexOf(dayOfWeek);
			combo.select(index);
			loadDay(dayOfWeek);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loadDay(String selection) {
		daySystem.loadDay(selection);
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy");
		Calendar selectedDate = daySystem.getDate();
		this.getShell().setText(sdf.format(selectedDate.getTime()));
		calendarPopup.setDate(selectedDate.get(Calendar.YEAR), selectedDate.get(Calendar.MONTH), selectedDate.get(Calendar.DAY_OF_MONTH));
		
		textClass1.setText(daySystem.getClassName(1));
		textClass2.setText(daySystem.getClassName(2));
		textClass3.setText(daySystem.getClassName(3));
		textClass4.setText(daySystem.getClassName(4));
		textClass5.setText(daySystem.getClassName(5));
		textClass6.setText(daySystem.getClassName(6));
		textNotes1.setText(daySystem.getClassText(1));
		textNotes2.setText(daySystem.getClassText(2));
		textNotes3.setText(daySystem.getClassText(3));
		textNotes4.setText(daySystem.getClassText(4));
		textNotes5.setText(daySystem.getClassText(5));
		textNotes6.setText(daySystem.getClassText(6));
		textLunchClass.setText(daySystem.getLunchClass());
		textCleaningClass.setText(daySystem.getCleaningClass());
		textAfterSchool.setText(daySystem.getAfterSchool());
	}

	protected void save() {
		try {
			daySystem.addPeriod(1, textClass1.getText(), textNotes1.getText(), "test");
			daySystem.addPeriod(2, textClass2.getText(), textNotes2.getText(), "test");
			daySystem.addPeriod(3, textClass3.getText(), textNotes3.getText(), "test");
			daySystem.addPeriod(4, textClass4.getText(), textNotes4.getText(), "test");
			daySystem.addPeriod(5, textClass5.getText(), textNotes5.getText(), "test");
			daySystem.addPeriod(6, textClass6.getText(), textNotes6.getText(), "test");
			daySystem.addLunchClass(textLunchClass.getText());
			daySystem.addCleaningClass(textCleaningClass.getText());
			daySystem.addAfterSchool(textAfterSchool.getText());
			daySystem.save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public String getSelectedDay() {
		return combo.getItem(combo.getSelectionIndex());
	}

	public void loadDate(Calendar dateToLoad) {
		loadWeek(dateToLoad);
	}
}
