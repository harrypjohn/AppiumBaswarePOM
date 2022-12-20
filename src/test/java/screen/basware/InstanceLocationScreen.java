package screen.basware;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class InstanceLocationScreen extends ScreenBase {
	public InstanceLocationScreen(AppiumDriver<MobileElement> driver) {
		super(driver);	
		PageFactory.initElements(driver, this);	
	}
	
    @FindBy(className ="android.widget.EditText")
    private WebElement instance;
    
    @FindBy(className ="android.widget.Button")
    private WebElement continueButton;
    
     
    public void enterInstanceLocation() throws InterruptedException {
    	Thread.sleep(5000);
    	instance.sendKeys("https://pm.baswareqa.com/qapd");
    	Thread.sleep(5000);
       }    
    
    public LoginScreen click_Continue_Button() throws InterruptedException { 
		Thread.sleep(5000);
		continueButton.click();
		Thread.sleep(5000);
		return new LoginScreen(driver);
}
}
 
