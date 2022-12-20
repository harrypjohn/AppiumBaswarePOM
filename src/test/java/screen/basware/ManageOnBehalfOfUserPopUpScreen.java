package screen.basware;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ManageOnBehalfOfUserPopUpScreen extends ScreenBase {
	public ManageOnBehalfOfUserPopUpScreen(AppiumDriver<MobileElement> driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.app.Dialog/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.Button")
	public WebElement okButtonOnManangeOnBehalfOfUser;
	
	public void clickOkButton()
	{
		okButtonOnManangeOnBehalfOfUser.click();
	}

}
