package screen.basware;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CreateOrderRequestScreen extends ScreenBase {
	public CreateOrderRequestScreen(AppiumDriver<MobileElement>driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath ="//android.widget.Button[@text='CREATE ORDER REQUEST']")
public WebElement createOrderRequestButton;

public void clickOnCreateOrderRequestButton()
{
createOrderRequestButton.click();	
}
}
