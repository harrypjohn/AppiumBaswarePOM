package rough;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

public class test {
	 
public static void main(String[] args) throws MalformedURLException {
	File screenshotLocation = null;
	
	
	String APPIUM_SERVER_PORT="4723";
	System.out.println("dfd"+APPIUM_SERVER_PORT);
	String dd="http://127.0.0.1:"+APPIUM_SERVER_PORT+"/wd/hub";
	System.out.println(dd);
	
	URL ff=new URL(dd);
	DateFormat dateformat;
	dateformat =  new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
	String fileName =dateformat.format(new Date())+".png";
	screenshotLocation = new File("./screenshots/" + fileName);
	System.out.println(screenshotLocation.toString());
	
	
	String path = "screenshots/" + UUID.randomUUID() + "" + ".png";
	 
	 screenshotLocation = new File(System.getProperty("user.dir") + "/" + path);	 
	      System.out.println(screenshotLocation.toString());
	
}

}
