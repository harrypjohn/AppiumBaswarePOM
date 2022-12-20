package listener;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import base.TestBase;
import utility.TestUtil;

public class CustomListeners extends TestBase implements ITestListener {
	public static DateFormat dateformat;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	public void onTestSuccess(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");

		/*
		 * result contains everything about the result like method and testcase etc.
		 * System.out.println("Test"+result.getName());
		 * System.out.println("Test"+result.toString());
		 */

		try {

			System.out.println(new Throwable().getStackTrace()[0].getClassName() + "with method name "
					+ new Throwable().getStackTrace()[0].getMethodName() + " is running successfully" );
			Reporter.log("In " + "Test Case " + new Throwable().getStackTrace()[0].getClassName() + "with method name "
					+ new Throwable().getStackTrace()[0].getMethodName() + " is running successfully");

			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			dateformat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
			String dest = System.getProperty("user.dir") + "\\Screenshots\\" + result.getName()
					+ dateformat.format(new Date()) + ".png";

			File destination = new File(dest);
			FileUtils.copyFile(source, destination);

			Reporter.log("<br>"+" <a href='" + destination.getAbsolutePath() + "'> <img src='" + destination.getAbsolutePath()
					+ "' height='200' width='200'/> </a>  ");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(new Throwable().getStackTrace()[0].getMethodName() + " method in class "
					+ new Throwable().getStackTrace()[0].getClassName() + " is not running successfully");
			Reporter.log(new Throwable().getStackTrace()[0].getMethodName() + " method in class "
					+ new Throwable().getStackTrace()[0].getClassName() + " is not running successfully");
		}

	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		System.out.println("I am onTestFailure method so capturing snapshot");
		String Path = "12-Jul-2022__01_04_39PM.jpg";
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<br>  <img src='" + Path + "' height='100' width='100' /><br>");
		Reporter.log("<a href=" + Path + ">Click here to see full Snapshot in new tab</a>");

		Reporter.log("<br>  <img src='" + Path + "' height='100' width='100' /><br>");

		Reporter.log(
				" <a target=\"_blank\" href='" + Path + "'> <img src='" + Path + "' height='200' width='200'/> </a>  ");

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) {
		System.out.println("Custom Listener is onStart Method");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);

		System.out.println("Custom Listener is onFinish Method");
	}

}
