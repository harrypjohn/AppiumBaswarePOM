package screen.basware;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;

public class HomeScreen extends ScreenBase {
	public HomeScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView")
	public WebElement helloTextElement;
	@FindBy(xpath="//android.widget.Button[@text='menu']")
	public WebElement menuIcon;
	@FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.Button")
	public WebElement menuIcon1;
	
	
	public String getHelloText() throws InterruptedException
	{
		
		Thread.sleep(5000);
		return helloTextElement.getText();
	}
	
	public void clickMenuIcon() throws InterruptedException
	{
		menuIcon.click();
		Thread.sleep(1000);
		TouchAction t =new TouchAction(driver);
		PointOption point=new PointOption();
		t.press(PointOption.point(263, 435)).release().perform();	
	}
	
	public void clickSearchCatalog()
	{
			}
	public void clickFavorites()
	{
		
	}
	public void clickOffCatalogRequest()
	{
		
	}
	public void clickReceivePO()
	{
		
	}
	public void clickExpenseReports()
	{
		
	}
	public void clickReceipts()
	{
		
	}
	public void clickMyCards()
	{
		
	}
	public void clickTripQueue()
	{
		
	}
	public void clickApprovals()
	{
		
	}
	public void clickSettings()
	{
		
	}
	public void clickLogout()
	{
		
	}

}
