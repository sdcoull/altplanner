package data;

import java.util.prefs.Preferences;

public class UserPreferences {
	private Preferences prefs = Preferences.userNodeForPackage(UserPreferences.class);
	public static final String USERNAME = "userName";
	public static final String SCHOOLNAME = "schoolName";
	private final String firstTime = "firstTime";
	
	public void setNotFirstTime()
	{
		prefs.putBoolean(firstTime, false);
	}
	
	public boolean isFirstTime()
	{
		return prefs.getBoolean(firstTime, true);
	}
	
	public String getValue(String field)
	{
		return prefs.get(field, "");
	}
	
	public void setValue(String field, String value)
	{
		prefs.put(field, value);
	}
}
