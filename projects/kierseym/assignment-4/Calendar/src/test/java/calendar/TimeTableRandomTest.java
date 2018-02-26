package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.LinkedList;
import java.util.GregorianCalendar;


import org.junit.Test;


import static org.junit.Assert.*;


public class TimeTableRandomTest {
/**
 * Random Test Generator  for TimeTable class.
 */
 private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
 private static final int NUM_TESTS=100;

 public static int RandomSelectRecur(Random random){
		 int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

	 int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		 return RecurArray[n] ; // return the value of the  appointments to recur
	}

	public static int RandomSelectRecurForEverNever(Random random){
			int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

		int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
			return RecurArray[n] ; // return appointments to recur forever or Never recur
			}

 public static Appt getRandomAppt(Random random) {
	 int hour = ValuesGenerator.getRandomIntBetween(random, -3, 27);
	 int minute = ValuesGenerator.getRandomIntBetween(random, -10, 70);
	 int day = ValuesGenerator.getRandomIntBetween(random, -5, 40);
	 int month = ValuesGenerator.getRandomIntBetween(random, 1, 12);
	 int year = 2018;
	 String title = "test title";
	 String des = "test description";
	 Appt appt = new Appt(hour, minute, day, month, year, title, des);
	 boolean recurif = ValuesGenerator.getBoolean(50, random);
	 if(recurif){
		 int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
		 boolean test = ValuesGenerator.getBoolean(50, random);
		 int[] recurDays;
		 if(test)
				recurDays = ValuesGenerator.generateRandomArray(random, sizeArray);
		 else
				recurDays = null;
		 int recur=RandomSelectRecur(random);
		 int recurIncrement = ValuesGenerator.RandInt(random);
		 int recurNumber=RandomSelectRecurForEverNever(random);
		 appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
	 }
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

	public static GregorianCalendar getRandomDay(Random random){
		int year = ValuesGenerator.getRandomIntBetween(random, 1990, 2020);
		int month = ValuesGenerator.getRandomIntBetween(random, 1, 12);
		int day = ValuesGenerator.getRandomIntBetween(random, 1, CalendarUtil.NumDaysInMonth(year,month-1));
		GregorianCalendar today = new GregorianCalendar(year, month, day);
		return today;
	}




    /**
     * Generate Random Tests that tests TimeTable Class.
     */

	 @Test
	  public void testRange()  throws Throwable  {
			long startTime = Calendar.getInstance().getTimeInMillis();
 		 	long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
			System.out.println("testing throw exception...");
			try{
				for (int iteration = 0; elapsed < TestTimeout; iteration++) {
					long randomseed =System.currentTimeMillis();
					Random random = new Random(randomseed);
					int numAppts = ValuesGenerator.getRandomIntBetween(random, 0, 10);
					LinkedList<Appt> appts = new LinkedList<Appt>();
					for(int a=0; a<numAppts; a++){
						Appt appt = getRandomAppt(random);
						appts.add(appt);
					}
				GregorianCalendar first = getRandomDay(random);
				GregorianCalendar second = getRandomDay(random);
        boolean notBefore = ValuesGenerator.getBoolean(50, random);
        while(!first.before(second))
          second = getRandomDay(random);
		 		TimeTable timetable = new TimeTable();
				LinkedList<CalDay> days = timetable.getApptRange(appts, first, second);
				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			}
    }catch(DateOutOfRangeException e){
			}

      try{
        long randomseed =System.currentTimeMillis();
        Random random = new Random(randomseed);
        LinkedList<Appt> appts = new LinkedList<Appt>();
        GregorianCalendar first = getRandomDay(random);
				GregorianCalendar second = getRandomDay(random);
        while(first.before(second))
        {
          second = getRandomDay(random);
        }
        TimeTable tt = new TimeTable();
        LinkedList<CalDay> cal = tt.getApptRange(appts, first, second);
      }catch(DateOutOfRangeException e){}

	 }


	 @Test
	  public void testDeleteAppt()  throws Throwable  {
			long startTime = Calendar.getInstance().getTimeInMillis();
 		 	long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
			System.out.println("testing deleteAppt..");
			try{
				for (int iteration = 0; elapsed < TestTimeout; iteration++) {
					long randomseed =System.currentTimeMillis();
					Random random = new Random(randomseed);
          Appt toDelete =getRandomAppt(random);
          LinkedList<Appt> appts = new LinkedList<Appt>();
          if(iteration == 0){
            toDelete = null;
          }
          else if(iteration == 1){
            appts = null;
          }
          else{
  					int numAppts = ValuesGenerator.getRandomIntBetween(random, 0, 10);
  					for(int a=0; a<numAppts; a++){
  						Appt appt = getRandomAppt(random);
              if(iteration == 2){
                toDelete = getRandomAppt(random);
                appts.add(appt);
              }
              else{
    						if(a == 1){
    							toDelete = appt;
    						}
    						appts.add(appt);
  					   }
             }
          }

		 		TimeTable timetable = new TimeTable();
				LinkedList<Appt> deleted = new LinkedList<Appt>();
				deleted = timetable.deleteAppt(appts, toDelete);
				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			}
    }catch(NullPointerException e){
			}

	 }



}
