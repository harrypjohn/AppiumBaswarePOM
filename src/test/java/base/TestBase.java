package base;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utility.CommonUtils;
import utility.ExcelReader;

public class TestBase {
	public static AppiumDriver<MobileElement> driver;
	public static String loadPropertyFile="Android_basware.properties";
	public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\BaswareApp.xlsx");
	public static  Logger log = Logger.getLogger("devpinoyLogger");
	@BeforeSuite
	public void setUp() throws IOException
	{
		if(driver==null)
		{
			if(loadPropertyFile.startsWith("Android"))
			{
				CommonUtils.loadAndroidBaswareConfProp(loadPropertyFile);
				CommonUtils.setAndroidCapabilites();
				driver=CommonUtils.getAndroidDriver();
				log.debug("AndroidDriver is started Successfully");
			}
		}
	}	

	@AfterSuite
	public void tearDown()
	{
		//driver.quit();
	}
	
	
	
	
}
