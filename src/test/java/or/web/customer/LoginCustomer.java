package or.web.customer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.util.Util;

import runner.util.ThreadLocalDriver;

public class LoginCustomer {
	WebDriverWait wait;
	WebDriver driver;
	public LoginCustomer() {
		this.driver = ThreadLocalDriver.getWebDriver();
		this.wait = ThreadLocalDriver.getWait();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[.='Log in']")
	private WebElement button_Login;
	
	@FindBy(name="userName")
	private WebElement text_UserName;

	@FindBy(name="password")
	private WebElement text_Password;

	@FindBy(xpath = "(//button[.='Log in'])[2]")
	private WebElement button_Login_Form;
	
	@FindBy(xpath = "//span[contains(@class,'icon-notification')]1")
	private WebElement button_Notification;
	
	
	public void performLogin() {
		button_Login.click();
		
		wait.until(ExpectedConditions.visibilityOf(text_UserName)).sendKeys("+919967489701");
		
		// text_UserName.sendKeys("+919967489701");
		text_Password.sendKeys("Amplify@123");
		button_Login_Form.click();
		
		wait.until(ExpectedConditions.visibilityOf(button_Notification));
		
		Util.wait(5);
		
	}
}
