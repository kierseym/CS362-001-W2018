package calendar;


import org.junit.Test;
import java.util.Random;
import java.util.GregorianCalendar;
import java.util.Calendar;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {

    /**
     * Generate Random Tests that tests CalDay Class.
     */

		 private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	 	 private static final int NUM_TESTS=100;

		 public static Appt getRandomAppt(Random random) {
			 int hour = ValuesGenerator.getRandomIntBetween(random, -3, 27);
			 int minute = ValuesGenerator.getRandomIntBetween(random, -10, 70);
			 int day = ValuesGenerator.getRandomIntBetween(random, -5, 40);
			 int month = ValuesGenerator.getRandomIntBetween(random, 1, 12);
			 int year = ValuesGenerator.getRandomIntBetween(random, 1950, 2050);
			 String title = "test title";
			 String des = "test description";
			 Appt appt = new Appt(hour, minute, day, month, year, title, des);
			 return appt;
		 }

		 public static CalDay getRandomCalDay(Random random){
			 int year = ValuesGenerator.getRandomIntBetween(random, 1990, 2020);
			 int month = ValuesGenerator.getRandomIntBetween(random, 1, 12);
			 int day = ValuesGenerator.getRandomIntBetween(random, 1, CalendarUtil.NumDaysInMonth(year,month-1));
			 GregorianCalendar today = new GregorianCalendar(year, month, day);
			 CalDay calday = new CalDay(today);
			 return calday;
		 }
/*
	 @Test
	  public void addApptTest()  throws Throwable  {
			long startTime = Calendar.getInstance().getTimeInMillis();
 		 	long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
			System.out.println("testing addAppt...");
			try{
				for (int iteration = 0; elapsed < TestTimeout; iteration++) {
					long randomseed =System.currentTimeMillis(); //10
		//			System.out.println(" Seed:"+randomseed );
					Random random = new Random(randomseed);
					Appt randomAppt1 = getRandomAppt(random);
					Appt randomAppt2 = getRandomAppt(random);
					Appt randomAppt3 = getRandomAppt(random);
					CalDay calday = getRandomCalDay(random);
					calday.addAppt(randomAppt1);
					calday.addAppt(randomAppt2);
					calday.addAppt(randomAppt3);

					elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
		 		}
			}catch(NullPointerException e){

			}

	 }*/



}
