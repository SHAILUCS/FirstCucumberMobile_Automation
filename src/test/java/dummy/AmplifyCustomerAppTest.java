package dummy;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import or.app.android.LoginCustomerApp;

public class AmplifyCustomerAppTest {

	public static final boolean emulatorDevice = true;
	public static AppiumDriver<WebElement> driver;
	public static WebDriverWait wait;

	public static void main(String[] args) {
		try {
			
			openApp();

			new LoginCustomerApp().performLogin("+919967489701", "Amplify@123");
			// doLogin();
			// closeApp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void closeApp() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

	private static void openApp() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("appPackage", "henleys.unchainedsystems.amplify");
		cap.setCapability("appActivity", "henleys.unchainedsystems.amplify.MainActivity");

		if (emulatorDevice) {
			/**
			 * EMULATOR CAPABILITIES
			 * 
			 * To Open Emulator from terminal 
			 * emulator -list-avds 
			 * //lists the emulators by name 
			 * emulator -avd Pixel_3a_Android_9 
			 * //To Start the emulator w/o opening Android Studio 
			 * cd C:\Users\Gwl-05\AppData\Local\Android\Sdk\emulator && emulator -avd Pixel_3a_API_30
			 */
			cap.setCapability("deviceName", "sdk_gphone_x86");
			cap.setCapability("udid", "emulator-5554");
			cap.setCapability("platformName", "Android");
			cap.setCapability("platformVersion", "11");

		} else {

			/**
			 * PHYSICAL DEVICE CAPABILITIES
			 */
			cap.setCapability("deviceName", "can't find");
			cap.setCapability("udid", "67692be2");
			cap.setCapability("platformName", "Android");
			cap.setCapability("platformVersion", "11 RKQ1.200826.002");
			// cap.setCapability("appPackage", "com.miui.calculator");
			// cap.setCapability("appActivity","com.miui.calculator.cal.CalculatorActivity");
		}

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		driver = new AndroidDriver<WebElement>(url, cap);
		wait = new WebDriverWait(driver, 20);

	}

	// TODO TEST METHODS
	private static void doLogin() {
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@class='android.widget.EditText'][contains(@text,'example')]")))
				.sendKeys("+919967489701");
		;

		driver.findElement(By.xpath("//*[contains(@text,'password')]")).sendKeys("Amplify@123");

		driver.findElement(By.xpath("//*[contains(@text,'Log In')]")).click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@text,'Book again')]")));

	}

}
