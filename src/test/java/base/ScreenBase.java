package base;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ScreenBase {
public static AppiumDriver<MobileElement> driver;
public ScreenBase(AppiumDriver<MobileElement> driver)
{
	this.driver=driver;
}

}
