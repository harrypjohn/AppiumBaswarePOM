package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CommonUtils {

	public static String APPLICATION_PATH;
	public static String BASE_PKG;
	public static String APPLICATION_ACTIVITY;
	public static String BROWSER_NAME;
	public static String PLATFORM_NAME;
	public static String PLATFORM_VERSION;
	public static String DEVICE_NAME;
	public static int IMPLICITY_WAIT;
	public static int EXPLICIT_WAIT;
	public static String APPIUM_SERVER_PORT;
	public static Properties prop = new Properties();
	public static DesiredCapabilities capabilities = new DesiredCapabilities();
	public static AndroidDriver driver;
	public static URL serverUrl;

	public static void loadAndroidBaswareConfProp(String propertyFileName) throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\" + propertyFileName);
		prop.load(fis);
		APPLICATION_PATH = prop.getProperty("application.path");
		BASE_PKG = prop.getProperty("base.pkg");
		APPLICATION_ACTIVITY = prop.getProperty("application.activity");
		BROWSER_NAME = prop.getProperty("browser.name");
		PLATFORM_NAME = prop.getProperty("platform.name");
		PLATFORM_VERSION = prop.getProperty("platform.version");
		DEVICE_NAME = prop.getProperty("device.name");
		IMPLICITY_WAIT = Integer.parseInt(prop.getProperty("implicti.wait"));
		EXPLICIT_WAIT = Integer.parseInt(prop.getProperty("explicti.wait"));
		APPIUM_SERVER_PORT = prop.getProperty("appium.server.port");

	}

	public static void print_properties() throws IOException {
		System.out.println(APPLICATION_PATH);
		System.out.println(BASE_PKG);
		System.out.println(APPLICATION_ACTIVITY);
		System.out.println(BROWSER_NAME);
		System.out.println(PLATFORM_NAME);
		System.out.println(PLATFORM_VERSION);
		System.out.println(DEVICE_NAME);
		System.out.println(IMPLICITY_WAIT);
		System.out.println(EXPLICIT_WAIT);
		System.out.println(APPIUM_SERVER_PORT);

	}

	public static void setAndroidCapabilites() {

		capabilities.setCapability("appPackage", BASE_PKG);
		capabilities.setCapability("appActivity", APPLICATION_ACTIVITY);
		capabilities.setCapability("platformName", PLATFORM_NAME);
		capabilities.setCapability("deviceName", DEVICE_NAME);

	}

	public static AppiumDriver<MobileElement> getAndroidDriver() throws MalformedURLException {
	
		serverUrl=new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver(serverUrl, capabilities);
	return driver;

	}

	public static void getSystemAndReprotTestngLogs()
	{
		System.out.println(new Throwable().getStackTrace()[2].getMethodName()+" method in class "+ new Throwable().getStackTrace()[2].getClassName()+ " is running successfully");
		Reporter.log(new Throwable().getStackTrace()[2].getMethodName()+" method in class "+ new Throwable().getStackTrace()[2].getClassName()+ " is not running successfully");
	}
}
