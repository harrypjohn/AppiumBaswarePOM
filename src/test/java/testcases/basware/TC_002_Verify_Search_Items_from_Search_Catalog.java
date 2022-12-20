package testcases.basware;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import screen.basware.CartScreen;
import screen.basware.CreateOrderRequestScreen;
import screen.basware.HomeScreen;
import screen.basware.ManageOnBehalfOfUserPopUpScreen;
import screen.basware.SearchCatalogScreen;
import utility.TestUtil;

public class TC_002_Verify_Search_Items_from_Search_Catalog extends TestBase {
	HomeScreen objHomeScreen;
	SearchCatalogScreen objSearchCatalogScreen; 
	ManageOnBehalfOfUserPopUpScreen objManageOnBehalfOfUserPopUpScreen;
	CartScreen objCartScreen;
	CreateOrderRequestScreen objCreateOrderRequestScreen;
	public static DateFormat dateformat;
	
	
	@BeforeTest
	public void init()
	{
		objHomeScreen=new HomeScreen(driver);
		objSearchCatalogScreen=new SearchCatalogScreen(driver);
		objManageOnBehalfOfUserPopUpScreen=new ManageOnBehalfOfUserPopUpScreen(driver);
		objCartScreen=new CartScreen(driver);
		objCreateOrderRequestScreen=new CreateOrderRequestScreen(driver);
	}
	
@Test(priority = 1)
public void searchItemFromSearch() throws InterruptedException, IOException
{ Thread.sleep(10000);
	objHomeScreen.clickMenuIcon();
try {
		
		System.out.println( new Throwable().getStackTrace()[0].getClassName()+"with method name " + new Throwable().getStackTrace()[0].getMethodName()+ " is running successfully");
		/*
		 * Reporter.log("In "+"Test Case "+ new
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
	Thread.sleep(10000);
}
/*
 * @Test (priority = 2) public void clickAddToCart() throws InterruptedException
 * { objSearchCatalogScreen.click_Add_To_Cart(); Thread.sleep(10000);
 * 
 * 
 * }
 * 
 * @Test (priority = 3) public void clickOkButtonOnOBOPopUp() throws
 * InterruptedException { objManageOnBehalfOfUserPopUpScreen.clickOkButton();
 * Thread.sleep(10000);
 * 
 * }
 * 
 * @Test (priority = 4) public void clickOnShoppingCartIcon() throws
 * InterruptedException { objSearchCatalogScreen.click_Shopping_Cart_Icon();
 * Thread.sleep(10000);
 * 
 * }
 * 
 * @Test (priority = 5) public void clickOnFinishRequestButton() throws
 * InterruptedException {
 * 
 * objCartScreen.clickFinishRequestButton(); Thread.sleep(10000);
 * 
 * 
 * }
 * 
 * @Test (priority = 6) public void clickOnCreateOrderRequestButton() throws
 * InterruptedException { Thread.sleep(10000);
 * objCreateOrderRequestScreen.clickOnCreateOrderRequestButton();;
 * Thread.sleep(10000); }
 */
}
