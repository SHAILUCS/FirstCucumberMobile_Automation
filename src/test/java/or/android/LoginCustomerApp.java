package or.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginCustomerApp {
	
	private AppiumDriver<WebElement> driver;
	private WebDriverWait wait;
	
	public LoginCustomerApp(AppiumDriver<WebElement> driver, WebDriverWait wait) {
		this.driver= driver;
		this.wait = wait;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//*[contains(@text,'example')]")
	private AndroidElement userName;
	
	@AndroidFindBy(xpath = "//*[contains(@text,'password')]")
	private AndroidElement pwd;
	
	@AndroidFindBy(xpath = "//*[contains(@text,'Log In')]")
	private AndroidElement login;
	
	@AndroidFindBy(xpath = "//*[contains(@text,'Book again')]1")
	private AndroidElement bookAgain;
	
	public void performLogin(String user, String pass) {
		wait.until(ExpectedConditions.elementToBeClickable(userName)).sendKeys(user);
		pwd.sendKeys(pass);
		login.click();
		wait.until(ExpectedConditions.visibilityOf(bookAgain));
	}
	
}
