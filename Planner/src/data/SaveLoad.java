package data;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import model.IDay;
import model.IPeriod;
import model.IWeek;

public class SaveLoad {
	
	public SaveLoad() throws ClassNotFoundException
	{
		try{
		System.out.println("Creating...");
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.
            getConnection("jdbc:h2:~/weeks", "username", "password");
        
        Statement statement = conn.createStatement();
        
        statement.execute("create table weeks(date int primary key, week int, "
        		+ "p1class varchar(255), p1notes varchar(255), "
        		+ "p2class varchar(255), p2notes varchar(255), "
        		+ "p3class varchar(255), p3notes varchar(255), "
        		+ "p4class varchar(255), p4notes varchar(255), "
        		+ "p5class varchar(255), p5notes varchar(255), "
        		+ "p6class varchar(255), p6notes varchar(255)");
        System.out.println("Created new DB.");
        statement.close();
		}
		catch(SQLException e)
		{
			System.err.println("Already created. This way sucks.");
		}
	}
	
//	public void saveWeek(IWeek week) throws IOException {
//		FileOutputStream f = new FileOutputStream(weekSdf.format(week.getDate().getTime()) + ".se");
//		ObjectOutputStream o = new ObjectOutputStream(f);
//		o.writeObject(week);
//		o.close();
//		f.close();
//}
//
	public IWeek loadWeek(Calendar dateToLoad) throws IOException, ClassNotFoundException {
		SimpleDateFormat weekFormat = new SimpleDateFormat("dd.m.yyyy");
		FileInputStream f = new FileInputStream("output - " + weekFormat.format(dateToLoad.getTime()) + ".se");
		ObjectInputStream o = new ObjectInputStream(f);
		 IWeek week = (IWeek) o.readObject();
		 o.close();
		 f.close();
		 return week;
	}
	
	public void saveWeek(IWeek week) throws ClassNotFoundException {
		try{
			System.out.println("Starting Save...");
	        Class.forName("org.h2.Driver");
	        Connection conn = DriverManager.
	            getConnection("jdbc:h2:~/weeks", "username", "password");
	        
	        Statement statement = conn.createStatement();
	        SimpleDateFormat dateFormat = new SimpleDateFormat("ddmmyyyy");
	        SimpleDateFormat weekFormat = new SimpleDateFormat("wyyyy");
	        
	        for(int i = 0; i < 5; i++)
	        {
	        	IDay day = week.getDay(i);
	        	List<IPeriod> periods = day.getPeriods();
	        	if(periods.size() !=0){
	        	statement.execute("insert into weeks values(" 
	        			+ dateFormat.format(day.getDate().getTime()) 
	        			+ weekFormat.format(day.getDate().getTime())
	        			+ periods.get(0).getClassName()
	        			+ periods.get(0).getNotes()
	        			+ periods.get(1).getClassName()
	        			+ periods.get(1).getNotes()
	        			+ periods.get(2).getClassName()
	        			+ periods.get(2).getNotes()
	        			+ periods.get(3).getClassName()
	        			+ periods.get(3).getNotes()
	        			+ periods.get(4).getClassName()
	        			+ periods.get(4).getNotes()
	        			+ periods.get(5).getClassName()
	        			+ periods.get(5).getNotes());
	        	}
	        }
	        ResultSet rs;
	        rs = statement.executeQuery("select * from weeks");
	        while (rs.next()) {
	            System.out.println(rs.getString("name"));
	        }
	        
	        System.out.println("Done!");
	        
	        conn.close();
			}
			catch(Exception e)
			{
				System.err.println("Oops");
				e.printStackTrace();
			}
}

//	public IWeek loadWeek(Calendar dateToLoad) throws IOException, ClassNotFoundException {
//		
//	}
	
//	public static void main(String[] a) {
//		try{
//		System.out.println("Starting");
//        Class.forName("org.h2.Driver");
//        Connection conn = DriverManager.
//            getConnection("jdbc:h2:~/test", "sa", "");
//        
//        Statement stat = conn.createStatement();
//
//        //stat.execute("create table test(id int primary key, name varchar(255))");
//        stat.execute("insert into test values(1, 'Helloo')");
//        ResultSet rs;
//        rs = stat.executeQuery("select * from test");
//        while (rs.next()) {
//            System.out.println(rs.getString("name"));
//        }
//        
//        System.out.println("Done!");
//        
//        conn.close();
//		}
//		catch(Exception e)
//		{
//			System.err.println("Oops");
//			e.printStackTrace();
//		}
//    }
}
