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
        Appt test = new Appt(9, 10, thisDay, thisMonth, thisYear, "title", "des");
        int redays[] = {1, 3, 6};
        test.setRecurrence(redays, 2, 8, 2);
        appts.add(test);
        Appt test1 = new Appt(13, 30, thisDay, thisMonth, thisYear, "title", "des");
        test1.setRecurrence(redays, 1, 1, 10);
        appts.add(test1);
        Appt test2 = new Appt(20, 45, thisDay, thisMonth, thisYear, "title", "des");
        test2.setRecurrence(redays, 3, 2, 9);
        appts.add(test2);
        Appt test3 = new Appt(9, 30, thisDay, thisMonth, thisYear, "Title", "Des");
        test3.setRecurrence(redays, 1000, 4, 10);
        appts.add(test3);
        TimeTable tt = new TimeTable();
        LinkedList<CalDay> days =  tt.getApptRange(appts, today, next);
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
        assertEquals(aps, null);
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
        aps.add(test);
        aps.add(test1);
        aps.add(test2);
        aps.add(test3);
        int[] pv = {2, 0, 1, 3};
        LinkedList<Appt> temp = tt.permute(aps, pv);
        LinkedList<Appt> tempOrdered = new LinkedList<Appt>();
        tempOrdered.add(test);
        tempOrdered.add(test1);
        tempOrdered.add(test2);
        tempOrdered.add(test3);
        assertEquals(temp, tempOrdered);
    }

    @Test
    public void test04() throws Throwable {
        int month = 2;
        int day = 10;
        int year = 2018;
        GregorianCalendar first = new GregorianCalendar(year, month, day);
        int month2 = 2;
        int day2s = 12;
        GregorianCalendar second = new GregorianCalendar(year, month2, day2s);
        Appt appt1 = new Appt(2, 20, 10, 2, 2018, "1", "des");
        Appt appt2 = new Appt(10, 40, 11, 2, 2018, "2", "des");
        Appt appt3 = new Appt(20, 10, 12, 2, 2018, "2", "des");
        LinkedList<Appt> appts = new LinkedList<Appt>();
        appts.add(appt1);
        appts.add(appt2);
        appts.add(appt3);
        TimeTable tt = new TimeTable();
        LinkedList<CalDay> calDays = new LinkedList<CalDay>();
        calDays = tt.getApptRange(appts, first, second);
        CalDay day1 = new CalDay(first);
        GregorianCalendar third = new GregorianCalendar(2018, 2, 11);
        CalDay day2 = new CalDay(third);
        CalDay day3 = new CalDay(second);
        day1.addAppt(appt1);
        day2.addAppt(appt2);
        day3.addAppt(appt3);
        LinkedList<CalDay> temps = new LinkedList<CalDay>();
        temps.add(day1);
        temps.add(day2);
        //temps.add(day3);
        //assertEquals(calDays, temps);
    }

    @Test
    public void test05() throws Throwable {
        GregorianCalendar first = new GregorianCalendar(2018, 3, 10);
        GregorianCalendar second = new GregorianCalendar(2018, 3, 15);
        Appt appt1 = new Appt(2, 20, 10, 3, 2018, "Title", "des");
        Appt appt2 = new Appt(3, 30, 11, 3, 2018, "t", "des");
        Appt appt3 = new Appt(10, 10, 12, 3, 2018, "t", "des");
        LinkedList<Appt> appts = new LinkedList<Appt>();
        appts.add(appt1);
        appts.add(appt2);
        appts.add(appt3);
        LinkedList<CalDay> caldays = new LinkedList<CalDay>();
        TimeTable tt = new TimeTable();
        caldays = tt.getApptRange(appts, first, second);
        LinkedList<CalDay> temp = new LinkedList<CalDay>();
        CalDay day1 = new CalDay(first);
        GregorianCalendar next = new GregorianCalendar(2018, 3, 11);
        CalDay day2 = new CalDay(next);
        day1.addAppt(appt1);
        day2.addAppt(appt2);
        GregorianCalendar next1 = new GregorianCalendar(2018, 3, 12);
        CalDay day3 = new CalDay(next1);
        day3.addAppt(appt3);
        GregorianCalendar next3 = new GregorianCalendar(2018, 3, 13);
        CalDay day4 = new CalDay(next3);
        GregorianCalendar next4 = new GregorianCalendar(2018, 3, 14);
        CalDay day5 = new CalDay(next4);
        temp.add(day1);
        temp.add(day2);
        temp.add(day3);
        temp.add(day4);
        temp.add(day5);
//        assertEquals(temp, caldays);
    }
//add more unit tests as you needed
}
