
package finalprojectB;

import junit.framework.TestCase;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Random;
//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   public String getURL()
   {
      long randomseed = System.currentTimeMillis();
      Random random = new Random(randomseed);
      int min = 0;
      int max = 4;
      long range = (long)max - (long)min + 1;
      long franction = (long)(range * random.nextDouble());
      int randomNumber = (int)(franction +  min);
      String[] urls = new String[6];
      urls[0] = "http://google.com";
      urls[1] = "http://facebook.com";
      urls[2] = "http://oregonstate.edu";
      urls[3] = "http://pandora.com";
      urls[4] = "http://instagram.com";
      urls[5] = "http://gmail.com";
      return urls[randomNumber];
   }

   
   public void testManualTest()
   {
      //You can use this function to implement your manual testing
      UrlValidator url = new UrlValidator(null, null, 1 );
      assertTrue(url.isValid("http://google.com"));
      assertFalse(url.isValid("://:65a/test1//file"));


	   
   }
   
   
   public void testYourFirstPartition()
   {
	 //Partition that is valid
      UrlValidator url = new UrlValidator(null, null, 1 );
      assertTrue(url.isValid("http://google.com"));
      assertTrue(url.isValid("http://facebook.com"));
      assertTrue(url.isValid("HTTP://GOOGLE.COM"));
   }
   
   public void testYourSecondPartition(){
		 //Partition that is invalid
      UrlValidator url = new UrlValidator(null, null, 1 );
      assertFalse(url.isValid("asdgarh"));
      assertTrue(url.isValid(("file/test")));

   }
   //You need to create more test cases for your Partitions if you need to 

   public void testIsValid()
   {
	   //You can use this function for programming based testing
      for(int i=0; i<10; i++)
      {
         String url = getURL();
         UrlValidator url2 = new UrlValidator(null, null, 1 );
         assertTrue(url2.isValid(url));
      }
   }
   


}
