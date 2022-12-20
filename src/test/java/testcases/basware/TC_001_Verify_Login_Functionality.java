package testcases.basware;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;


import screen.basware.HomeScreen;
import screen.basware.InstanceLocationScreen;
import screen.basware.LoginScreen;
import utility.ExcelReader;
import utility.TestUtil;

public class TC_001_Verify_Login_Functionality extends TestBase {
	
	InstanceLocationScreen objInstanceLocationScreen;
	LoginScreen objLoginScreen;
	HomeScreen objHomeScreen;
	public static DateFormat dateformat;
	@BeforeTest
	public void init()
	{
		objInstanceLocationScreen=new InstanceLocationScreen(driver);
		objLoginScreen=new LoginScreen(driver);
		objHomeScreen=new HomeScreen(driver);	
	}
	@Test(priority = 0,dataProvider = "getData")
	
		public void validateLoginFunctionality(String username,String password) throws InterruptedException
		{
		try {
			objInstanceLocationScreen.enterInstanceLocation();
			//System.out.println("This is just data provider testing "+username+" "+password);
			objInstanceLocationScreen.click_Continue_Button().login(username,password);
			Assert.assertEquals(true, objHomeScreen.getHelloText().contains("Hello"));
			
			
			
				
			System.out.println(new Throwable().getStackTrace()[0].getClassName()+"with method name " + new Throwable().getStackTrace()[0].getMethodName()+ " is running successfully");
			/*
			 * Reporter.log( new
			 * Throwable().getStackTrace()[0].getClassName()+"with method name " + new
			 * Throwable().getStackTrace()[0].getMethodName()+ " is running successfully");
			 * 
			 * TakesScreenshot ts = (TakesScreenshot)driver; File source =
			 * ts.getScreenshotAs(OutputType.FILE); dateformat = new
			 * SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa"); String dest =
			 * System.getProperty("user.dir")
			 * +"\\Screenshots\\"+dateformat.format(new Date())+".png";
			 * 
			 * File destination = new File(dest); FileUtils.copyFile(source, destination);
			 * 
			 * Reporter.log(" <a href='"+destination.getAbsolutePath()+"'> <img src='"+
			 * destination.getAbsolutePath()+"' height='200' width='200'/> </a>  ");
			 */
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(new Throwable().getStackTrace()[0].getMethodName()+" method in class "+ new Throwable().getStackTrace()[0].getClassName()+ " is not running successfully");
			Reporter.log(new Throwable().getStackTrace()[0].getMethodName()+" method in class "+ new Throwable().getStackTrace()[0].getClassName()+ " is not running successfully");
		}
			
			
		}
	@DataProvider
	public Object[][] getData()
	{
		return TestUtil.getDataFromTestUtil("Login");
		
	}
	
	
	
}
