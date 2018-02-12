package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {
        //test that a CalDay object can be created correctly
	 @Test
	  public void test01()  throws Throwable  {
        Calendar rightnow = Calendar.getInstance();
        int thisMonth = rightnow.get(Calendar.MONTH)+1;
        int thisYear = rightnow.get(Calendar.YEAR);
        int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
        GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
        CalDay day = new CalDay(today); 
        assertEquals(thisDay, day.getDay());
        assertEquals(thisMonth, day.getMonth());
        assertEquals(thisYear, day.getYear());
	 }
    
    //test addAppt
	 @Test
	  public void test02()  throws Throwable  {
        Calendar rightnow = Calendar.getInstance();
        int thisMonth = rightnow.get(Calendar.MONTH)+1;
        int thisYear = rightnow.get(Calendar.YEAR);
        int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
        GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
        CalDay day = new CalDay(today); 

        Appt test = new Appt(11, 15, 28, thisMonth, 2018, "title", "des");
        day.addAppt(test);
        Appt test1 = new Appt(18, 20, 28, thisMonth, 2018, "title", "des");
        day.addAppt(test1);
        LinkedList<Appt> testList = new LinkedList<Appt>();
        testList.add(test);
        testList.add(test1);
        assertEquals(testList, day.getAppts()); 
	 }

    //test toString
    @Test
    public void test03() throws Throwable {
        Calendar rightnow = Calendar.getInstance();
        int thisMonth = rightnow.get(Calendar.MONTH)+1;
        int thisYear = rightnow.get(Calendar.YEAR);
        int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
        GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
        CalDay day = new CalDay(today); 
         
        StringBuilder sb = new StringBuilder();
        String date = "2/11/2018";
        sb.append("\t --- " + date + " --- \n");
        sb.append(" --- -------- Appointments ------------ --- \n");
        Appt test = new Appt(10, 20, 28, thisMonth, thisYear, "test", "des");
        day.addAppt(test);
        Appt test1 = new Appt(15, 45, 28, thisMonth, thisYear, "test2", "des2");
        day.addAppt(test1);
        sb.append(test + " ");
        sb.append(test1 + " ");
        sb.append("\n");
        assertEquals(sb.toString(), day.toString());
    }

    @Test
    public void test04() throws Throwable {
        Calendar rightnow = Calendar.getInstance();
        int thisMonth = rightnow.get(Calendar.MONTH)+1;
        int thisYear = rightnow.get(Calendar.YEAR);
        int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
        GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
        CalDay day = new CalDay(today); 
    
        Appt test = new Appt(90, 20, 90, 11, 2018, "title", "des");
        day.addAppt(test);
        Appt first = new Appt(2, 30, 28, thisMonth, thisYear, "title", "des");
        Appt second = new Appt(8, 20, 28, thisMonth, thisYear, "title", "des");
        Appt third = new Appt(14, 10, 28, thisMonth, thisYear, "title", "des");
        day.addAppt(first);
        day.addAppt(third);
        day.addAppt(second);
        LinkedList<Appt> testList = new LinkedList<Appt>();
        testList.add(first);
        testList.add(second);
        testList.add(third);
        assertEquals(testList, day.getAppts());      
        
            
    }

    @Test
    public void test05() throws Throwable {
        Calendar rightnow = Calendar.getInstance();
        int thisMonth = rightnow.get(Calendar.MONTH)+1;
        int thisYear = rightnow.get(Calendar.YEAR);
        int thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
        GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
        CalDay day = new CalDay(); 
        day.toString(); 

            
    }

    @Test
    public void test06() throws Throwable {
        Calendar rightnow = Calendar.getInstance();
        int month = 4;
        int thisday = 10;
        int year = 2018;
        GregorianCalendar today = new GregorianCalendar(year, month, thisday);
        CalDay day = new CalDay(today);
        LinkedList<Appt> tests = new LinkedList<Appt>();
        Appt test = new Appt(2, 30, 2, 5, 2018, "title", "Des");
        tests.add(test);
        Appt test2 = new Appt(10, 20, 2, 5, 2018, "title2", "des2");
        tests.add(test2);
        day.addAppt(test2);
        day.addAppt(test);
        assertEquals(2, day.getSizeAppts());
    }

    @Test
    public void test07() throws Throwable {
        int month = 3;
        int day = 10;
        int year = 2018;
        GregorianCalendar today = new GregorianCalendar(year, month, day);
        CalDay calday = new CalDay(today);
        Appt test = new Appt(2, 20, 3, 10, 2018, "title", "des");
        Appt test2 = new Appt(10, 30, 3, 10, 2018, "title2", "des");
        calday.addAppt(test);
        calday.addAppt(test2);
        Iterator<?> iterator = calday.getAppts().iterator();
        //assertEquals(iterator, calday.getAppts().iterator());
    }

    @Test
    public void test08() throws Throwable {
        int month = 3;
        int day = 10;
        int year = 2018;
        GregorianCalendar today = new GregorianCalendar(year, month, day);
        CalDay calday = new CalDay(today);
        LinkedList<Appt> appts = new LinkedList<Appt>();
        Appt appt = new Appt(2, 20, 3, 10, 2018, "title", "des");
        TimeTable tt = new TimeTable();
        assertEquals(null, tt.deleteAppt(null, null));
        appts.add(appt);
        Appt appt2 = new Appt(5, 40, 3, 10, 2018, "title", "des");
        appts.add(appt2);
        LinkedList<Appt> temp = new LinkedList<Appt>();
        temp = tt.deleteAppt(appts, appt2);
        appts.remove(appt2);
        assertEquals(temp, null);
        
        
    }
//add more unit tests as you needed	
}
