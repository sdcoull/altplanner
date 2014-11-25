package data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import model.IWeek;

public class SaveLoad {
	
	private SimpleDateFormat weekSdf = new SimpleDateFormat("w.yyyy");
	
	public void saveWeek(IWeek week) throws IOException {
		FileOutputStream f = new FileOutputStream(weekSdf.format(week.getDate().getTime()) + ".se");
		ObjectOutputStream o = new ObjectOutputStream(f);
		o.writeObject(week);
		o.close();
		f.close();
}

	public IWeek loadWeek(Calendar dateToLoad) throws IOException, ClassNotFoundException {
		FileInputStream f = new FileInputStream(weekSdf.format(dateToLoad.getTime()) + ".se");
		ObjectInputStream o = new ObjectInputStream(f);
		 IWeek week = (IWeek) o.readObject();
		 o.close();
		 f.close();
		 return week;
	}

}
