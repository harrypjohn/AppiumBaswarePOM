package screen.basware;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import freemarker.core.ReturnInstruction.Return;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class LoginScreen extends ScreenBase {
	
	public LoginScreen(AppiumDriver<MobileElement> driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBys({@FindBy(className="android.widget.EditText")})
	 List<WebElement> textboxes;
	@FindBy(className = "android.widget.Button")
	public WebElement loginButton;
	
	public HomeScreen login(String username, String password)
	{
		for(int i=0;i<textboxes.size();i++)
		{
			if(i==0)
			{
				textboxes.get(0).sendKeys(username);
			}
			else
			{
				textboxes.get(1).sendKeys(password);
			}
		}
		loginButton.click();
		return new HomeScreen(driver);
	}
	

}
