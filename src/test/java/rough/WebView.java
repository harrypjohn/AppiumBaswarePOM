package rough;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class WebView {
	public static AndroidDriver driver;
	public static void main(String args[]) throws MalformedURLException
	{
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("deviceName", "Redmi Note 11T 5G");
	capabilities.setCapability("platformName", "Android");
	capabilities.setCapability("appPackage", "com.verian.mobile");
	capabilities.setCapability("appActivity", "com.verian.mobile.MainActivity");
	driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	WebDriverWait wait = new WebDriverWait(driver, 50);
	driver.findElement(By.className("android.widget.EditText")).sendKeys("https://pm.baswareqa.com/qapd");

	driver.findElement(By.className("android.widget.Button")).click();

Set<String> contextNames = driver.getContextHandles();
for (String contextName : contextNames) {
    System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
}
driver.context("WEBVIEW_chrome"); // set context to WEBVIEW_1


	List<MobileElement> values = driver.findElementsByClassName("android.widget.EditText");

	for (int i = 0; i < values.size(); i++) {
		if (i == 0) {
			values.get(0).sendKeys("T301admin");
		} else {
			values.get(1).sendKeys("Testing@1234");
		}

	}
	driver.findElement(By.className("android.widget.Button")).click();
	
	driver.findElement(By.xpath("//android.widget.Button[@text='menu']")).click();

	}

}
