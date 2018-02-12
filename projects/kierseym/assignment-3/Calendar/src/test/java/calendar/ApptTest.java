package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());         		
	 }
    //test the tostring function works
	 @Test
	  public void test02()  throws Throwable  {
	    	int startHour = 10;
            int startMinute = 20;
            int startDay = 20;
            int startMonth = 01;
            int startYear = 2018;
            String title = "Dentist";
            String description = "Get teeth cleaned";
            Appt appt1 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, description);
            String correctString = "    01/20/2018 at 10:20am ,Dentist, Get teeth cleaned\n";
            //assertEquals(correctString, appt1.toString()); 
	 }
    
    //test invalid date
    @Test
    public void test03() throws Throwable {
        int startHour = 50;
        int startMinute = 70;
        int startDay = 0;
        int startMonth = 10;
        int startYear = 2018;
        String title = null;
        String des = null;
        Appt appt2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, des);
        startHour = -1;
        Appt hourTest = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, des);
        startHour = 12;
        Appt minuteTest = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, des);
        startMinute = -1;
        Appt minuteTest2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, des);
        startMinute = 45;
        Appt DayTest = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, des);
        startDay = 40;
        Appt DayTest2 = new Appt(startHour, startMinute, startDay, startMonth, startYear, title, des);
        assertFalse(appt2.getValid());
        assertFalse(hourTest.getValid());
        assertFalse(minuteTest.getValid());
        assertFalse(minuteTest2.getValid());
        assertFalse(DayTest.getValid());
        assertFalse(DayTest2.getValid());
    }

    //test compareTo
    @Test
    public void test04() throws Throwable {
        int hour = 20;
        int minute = 30;
        int day = 10;
        int month = 01;
        int year = 2018;
        String title = "test";
        String des = "test description";
        Appt appt3 = new Appt(hour, minute, day, month, year, title, des);
        int hour1 = 4;
        int minute1 = 15;
        int day1 = 11;
        int month1 = 01;
        int year1 = 2018;
        String title1 = "test2";
        String des1 = "test2 description";
        Appt compare = new Appt(hour1, minute1, day1, month1, year1, title1, des1);
        int comTo = appt3.compareTo(compare);
        assertEquals(30, comTo);
        
    }

    //represntationApp
    @Test
    public void test05() throws Throwable {
        int hour = 14;
        int minute = 10;
        int day = 20;
        int month = 01;
        int year = 2018;
        String title = "test";
        String des = "test";
        Appt repTest = new Appt(hour, minute, day, month, year, title, des);
//        assertEquals("  01/20/2018 at 2:10pm ,test, test\n", repTest.toString());
        hour = 0;
        Appt repTest2 = new Appt(hour, minute, day, month, year, title, des);
  //      assertEquals("  01/20/2018 at 12:10am ,test, test\n", repTest2.toString());
    }

    //recurrint tests
    @Test
    public void test06() throws Throwable {
        int hour = 11;
        int minute = 10;
        int day = 21;
        int month = 10;
        int year = 2018;
        String title = "test";
        String des = "test";
        Appt reTest = new Appt(hour, minute, day, month, year, title, des);
        assertFalse(reTest.isRecurring());
        int days[] = {1, 2};
        reTest.setRecurrence(days, 2, 8, 2);
        assertTrue(reTest.isRecurring());
    }


    @Test
    public void test07() throws Throwable {
        for(int i=-1; i<25; i++)
        {   
            Appt test = new Appt(i, 20, 10, 2, 2018, "title", "des");
            if(i<0)
            {
                assertFalse(test.getValid());
            }
            else if(i>23)
            {
                assertFalse(test.getValid());
            }
            else
            {
                assertTrue(test.getValid());
            }
        }   
        for(int j=-1; j<63; j++)
        {
            Appt test = new Appt(2, j, 10, 2, 2018, "title", "des");
            if(j<0)
                assertFalse(test.getValid());
            else if(j>59)
                assertFalse(test.getValid());
            else
                assertTrue(test.getValid());
        }
    
        for(int k=-1; k<33; k++)
        {
            Appt test = new Appt(2, 30, k, 3,  2018, "Title", "Des");
            if(k<1)
                assertFalse(test.getValid());
            else if(k>30)
                assertFalse(test.getValid());
            else
                assertTrue(test.getValid());
        }

    }

    @Test
    public void test08() throws Throwable {
    /*
        for(int i=0; i<25; i++)
        {
            Appt test = new Appt(i, 10, 10, 3, 2018, "Title", "des");
            String half = (i < 11) ? "pm" : "am";
            if(i > 11)
                i -= 12;
            if(i == 0)
                i = 12;
            String testString = i +":"+ "10" + half;
            String day = "3"+"/"+"10"+"/"+"2018 at ";
            String total = "\t"+ day + testString + " ," + "Title"+ ", "+ "des"+"\n";
            if(i<1)
                assertEquals(null, test.toString());
            else if(i>23)
                assertEquals(null, test.toString());
            else
                assertEquals(total, test.toString());
        }
    */
        Appt test = new Appt(12, 10, 10, 3, 2018, "title", "des");
        String time = "12:10am";
        String day = "3/10/2018 at ";
        String total = "\t"+day + time +" ,title, des\n";
        assertEquals(total, test.toString());
        Appt test2 = new Appt(1, 10, 10, 3, 2018, "title", "des");
        String time2 = "1:10pm";
        String total2 = "\t"+day + time2 +" ,title, des\n";
        assertEquals(total2, test2.toString());
        Appt test3 = new Appt(-1, 10, 10, 3, 2018, "title", "des");
        assertEquals(null, test3.toString());
    }

    @Test
    public void test09() throws Throwable {
        Appt test = new Appt(2, 30, 10, 3, 2018, "Title", "des");
        for(int i=-1; i<25; i++)
        {
            test.setStartHour(i);
            if(i<0)
            {
                assertFalse(test.getValid());
            }
            else if(i>23)
            {
                assertFalse(test.getValid());
            }
            else
            {
                assertTrue(test.getValid());
            }
        }
        Appt test2 = new Appt(2, 10, 10, 3, 2018, "title", "des");
        for(int j=-1; j<62; j++)
        {
            test2.setStartMinute(j);
            if(j<0)
            {
                assertFalse(test2.getValid());
            }
            else if(j>59)
            {
                assertFalse(test2.getValid());
            }
            else
            {
                assertTrue(test2.getValid());
            }
        }
        Appt test3 = new Appt(2, 10, 10, 3, 2018, "title", "des");
        test3.setStartYear(2019);
        assertTrue(test3.getValid());
        Appt test4 = new Appt(-1, 10, 10, 3, 2018, "title", "des");
        test4.setStartYear(2019);
        assertFalse(test4.getValid());
        Appt test5 = new Appt(2, 10, 10, 3, 2018, "title", "des");
        for(int h=-1; h<33; h++)
        {
            test5.setStartDay(h);
            if(h<1)
            {
                assertFalse(test5.getValid());
            }
            else if(h>30)
            {
                assertFalse(test5.getValid());
            }
            else
            {
                assertTrue(test5.getValid());
            }
        }
    }

    @Test
    public void test10() throws Throwable {
        Appt test = new Appt(10, 30, 10, 2, 2018, "title", "des");
        int days[] = {1,2,3,4}; 
        test.setRecurrence(days, 2, 2, 2);
        assertEquals(days, test.getRecurDays());
        assertEquals(2, test.getRecurBy());
        assertEquals(2, test.getRecurIncrement());
        assertEquals(2, test.getRecurNumber());
    }
//add more unit tests as you needed
    	
}
