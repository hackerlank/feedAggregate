package com.vincentko.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class VincentKoUtil {
	
	public VincentKoUtil(){}
	
    public Calendar dateAdd(int daynum) {
    	Calendar cal = Calendar.getInstance();
    	cal.add(Calendar.DAY_OF_MONTH, daynum);
	    cal.set(Calendar.HOUR_OF_DAY, cal.getActualMinimum(Calendar.HOUR_OF_DAY));
	    cal.set(Calendar.MINUTE, cal.getActualMinimum(Calendar.MINUTE));
	    cal.set(Calendar.SECOND, cal.getActualMinimum(Calendar.SECOND));
	    cal.set(Calendar.MILLISECOND, cal.getActualMinimum(Calendar.MILLISECOND));
	    
	    return cal;
    	
    }
    
    public void setEndOfDay(Calendar cal) {

	    cal.set(Calendar.HOUR_OF_DAY, cal.getActualMaximum(Calendar.HOUR_OF_DAY));
	    cal.set(Calendar.MINUTE, cal.getActualMaximum(Calendar.MINUTE));
	    cal.set(Calendar.SECOND, cal.getActualMaximum(Calendar.SECOND));
	    cal.set(Calendar.MILLISECOND, cal.getActualMaximum(Calendar.MILLISECOND));	    
    	
    }
    
    public void setBeginningOfDay(Calendar cal) {

	    cal.set(Calendar.HOUR_OF_DAY, cal.getActualMinimum(Calendar.HOUR_OF_DAY));
	    cal.set(Calendar.MINUTE, cal.getActualMinimum(Calendar.MINUTE));
	    cal.set(Calendar.SECOND, cal.getActualMinimum(Calendar.SECOND));
	    cal.set(Calendar.MILLISECOND, cal.getActualMinimum(Calendar.MILLISECOND));	    
    	
    }
    
    public Date convertStringToDate(String strDate) throws ParseException {
    	SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = formatter.parse(strDate);
		return date;
    }
    
    public Date convertStringToCalendar(String strDate) throws ParseException {
    	SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
		Date date = formatter.parse(strDate);
		return date;
    }

}
