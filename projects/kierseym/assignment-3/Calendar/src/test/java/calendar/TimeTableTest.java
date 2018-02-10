package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
	    Calendar rightnow = Calendar.getInstance();
        int thisMonth = rightnow.get(Calendar.MONTH)+1;
        int thisYear = rightnow.get(Calendar.YEAR);
        int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
        GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
        GregorianCalendar next = new GregorianCalendar(thisYear, thisMonth, 30);	 
        LinkedList<Appt> appts = new LinkedList<Appt>();
        TimeTable tt = new TimeTable();
        LinkedList<CalDay> days =  tt.getApptRange(appts, next, today);
	 }
	 @Test
	  public void test02()  throws Throwable  {
	    Calendar rightnow = Calendar.getInstance();
        int month = rightnow.get(Calendar.MONTH)+1;
        int year = 2018;
        int day = rightnow.get(Calendar.DAY_OF_MONTH);
        GregorianCalendar today = new GregorianCalendar(year, month, day);
        CalDay testDay = new CalDay(today);
        TimeTable tt = new TimeTable();
        Appt test = new Appt(13, 30, day, month, year, "Title", "description");
        testDay.addAppt(test);
        assertEquals(null, tt.deleteAppt(testDay.appts, test));
        Appt hourtest = new Appt(90, 10, day, month, year, "bad test", "bad hour");
        testDay.addAppt(hourtest);
        assertEquals(null, tt.deleteAppt(testDay.appts, hourtest));
        Appt test1 = new Appt(9, 10, day, month, year, "title 1", "second description");
        testDay.addAppt(test1);
        Appt test2 = new Appt(22, 50, day, month, year, "title", "des");
        testDay.addAppt(test2);
        Appt test3 = new Appt(18, 20, day, month, year, "t", "d");
        testDay.addAppt(test3);
        LinkedList<Appt> aps = new LinkedList<Appt>();
        aps = tt.deleteAppt(testDay.appts, test2);
        assertEquals(aps, testDay.appts); 
	 }

    @Test
    public void test03() throws Throwable {
	    Calendar rightnow = Calendar.getInstance();
        int month = rightnow.get(Calendar.MONTH)+1;
        int year = 2018;
        int day = rightnow.get(Calendar.DAY_OF_MONTH);
        GregorianCalendar today = new GregorianCalendar(year, month, day);
        CalDay testDay = new CalDay(today);
        Appt test = new Appt(13, 30, day, month, year, "Title", "description");
        testDay.addAppt(test);
        Appt test1 = new Appt(9, 10, day, month, year, "title 1", "second description");
        testDay.addAppt(test1);
        Appt test2 = new Appt(22, 50, day, month, year, "title", "des");
        testDay.addAppt(test2);
        Appt test3 = new Appt(18, 20, day, month, year, "t", "d");
        testDay.addAppt(test3);
        TimeTable tt = new TimeTable();
        LinkedList<Appt> aps = new LinkedList<Appt>();
        int[] pv = {2, 0, 1, 3};
        aps = tt.permute(testDay.appts, pv);
        assertEquals(aps, tt.permute(testDay.appts, pv));
        int[] pv2 = {2, 4, 0, 3, 1};
        aps = tt.permute(testDay.appts, pv2);
    }
//add more unit tests as you needed
}
