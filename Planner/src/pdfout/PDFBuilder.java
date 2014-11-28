package pdfout;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import com.ibm.icu.util.Calendar;

import data.UserPreferences;
import model.IDay;
import model.IPeriod;
import model.IWeek;

public class PDFBuilder {

	private UserPreferences userPrefs = new UserPreferences();
	private PDDocument document;
	private final String fileName = "template.pdf";
	private final String newFileName = "output - ";

	public void create(IWeek week) {
		try {
			System.out.println("Starting..");
			document = PDDocument.load(fileName);
			System.out.println("Loaded Template..");
			setField("schoolName", userPrefs.getValue(UserPreferences.SCHOOLNAME));
			setField("altName", userPrefs.getValue(UserPreferences.USERNAME));
			//setField("comments", "TODO");
			System.out.println("Added user fields..");

			String[] days = {"mon", "tue", "wed", "thurs", "fri"};
			for(int j = 0; j<5; j++)
			{
				String dayField = days[j];
				System.out.println("Adding " + dayField);
				IDay day =  week.getDay(j);
				
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				setField(dayField + "Date", sdf.format(day.getDate().getTime()));

				setField(dayField + "After", day.getAfterSchool() + "/n");
				List<IPeriod> periods = day.getPeriods();
				for(int i = 0; i < periods.size(); i++)
				{
					IPeriod period = periods.get(i);
					setField(dayField + "Class" + (i+1), period.getClassName());
					setField(dayField + "Lesson" + (i+1), period.getNotes());
				}
			}
			
			SimpleDateFormat sFile = new SimpleDateFormat("MM.dd.yyyy");
			document.save(newFileName + sFile.format(Calendar.getInstance().getTime()) + ".pdf");
			document.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (COSVisitorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setField(String fName, String value)
	{
		try {
			PDAcroForm af = document.getDocumentCatalog().getAcroForm();
			PDField f = af.getField(fName);
			if(f == null)
			{
				System.err.println("Couldn't find field:" + fName);
			}
			else
			{
				f.setValue(value);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
