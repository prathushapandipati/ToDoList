package toDoListExample;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateUtil {
	
	public static Date stringToDate(String date)  {
		Date dateObj = null;
		try{
			 DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		 	 dateObj = formatter.parse(date);
		} catch(Exception ex){
			System.out.println("Please enter valid date (Ex:1-Jan-2017):\n");
			Scanner scanner = new Scanner(System.in);
			String validDate = scanner.next();
			stringToDate(validDate);
		}		
		return dateObj;
	}
	
	public static String dateToString(Date date)  {
		String reportDate = null;
		try{
			DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
			reportDate = df.format(date);
		} catch(Exception ex){
			System.err.println("Exception Occured on conversion to date format");
		}		
		return reportDate;
	}
	
	
	

	

}
