package runner.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class ThreadLocalDriver {
	// AndroidDriver<WebElement>
	private static final ThreadLocal<WebDriver> tlWebDriver = new ThreadLocal<>();

	public static synchronized void setWebDriver(WebDriver driver) {
		tlWebDriver.set(driver);
	}

	public static synchronized WebDriver getWebDriver() {
		return tlWebDriver.get();
	}

	// AndroidDriver<WebElement>
	private static final ThreadLocal<AndroidDriver<WebElement>> tlDriver = new ThreadLocal<>();

	public static synchronized void setAppiumDriver(AndroidDriver<WebElement> driver) {
		tlDriver.set(driver);
	}

	public static synchronized AndroidDriver<WebElement> getAppiumDriver() {
		return tlDriver.get();
	}

	// WebDriverWait
	private static final ThreadLocal<WebDriverWait> tlWait = new ThreadLocal<>();

	public static synchronized void setWait(WebDriverWait obj) {
		tlWait.set(obj);
	}

	public static synchronized WebDriverWait getWait() {
		return tlWait.get();
	}
	
	// AppiumDriverLocalService
	private static final ThreadLocal<AppiumDriverLocalService> threadlocalService = new ThreadLocal<>();

	protected static synchronized void setAppiumService(AppiumDriverLocalService service) {
		threadlocalService.set(service);
	}

	protected static synchronized AppiumDriverLocalService getAppiumService() {
		return threadlocalService.get();
	}

	// AppiumDriverLocalService
	private static final ThreadLocal<String> threadlocalScenario = new ThreadLocal<>();

	public static synchronized void setScenario(String sc) {
		threadlocalScenario.set(sc);
	}

	public static synchronized String getScenario() {
		return threadlocalScenario.get();
	}
}
