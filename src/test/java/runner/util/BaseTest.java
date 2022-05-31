package runner.util;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.util.Prop;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	@BeforeMethod
	public void setUpDriver() {
		String port = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("port");
		String deviceName = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
				.getParameter("deviceName");
		String platformVersion = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest()
				.getParameter("platformVersion");
		String udid = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("udid");

		System.out.println(Thread.currentThread().getId() + " Base Test :- @BeforeMethod setUpAppiumDriver " + port);

		if (null != port) {
			startAppiumDriver(deviceName, platformVersion, udid, port);
		} else {
			startWebDriver();
		}
	}

	@AfterMethod
	public void teardownDriver() {
		String port = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("port");
		System.out.println(Thread.currentThread().getId() + " Base Test @AfterMethod() : " + port);
		if (null != port) {
			ThreadLocalDriver.getAppiumDriver().quit();
		} else {
			ThreadLocalDriver.getWebDriver().quit();
		}

	}

	@BeforeTest
	public void setUpTests() {
		String port = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("port");
		System.out.println(Thread.currentThread().getId() + " Base Test @BeforeTest SETUP : " + port);
		if (null != port) {
			startAppiumServer(port);
		}
	}

	@AfterTest
	public void tearDownTests() throws Exception { 
		String port = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("port");
		System.out.println(Thread.currentThread().getId() + " Base Test @AfterTest : " + port);
		if (null != port) {
			ThreadLocalDriver.getAppiumService().stop();
		}
	}

	//TODO Helper Methods
	
	private void startAppiumServer(String port) {
		String ip = Prop.getProp("IP");
		AppiumDriverLocalService service;
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder.withIPAddress(ip);
		builder.usingPort(Integer.parseInt(port));
		service = AppiumDriverLocalService.buildService(builder);
		service.start();
		ThreadLocalDriver.setAppiumService(service);
		System.out.println(Thread.currentThread().getId() + " Base Test :- Appium Server is started on port " + port);
	}

	private void startAppiumDriver(String deviceName, String platformVersion, String udid, String port) {
		try {

			String appPackage = Prop.getProp("appPackage");
			String appActivity = Prop.getProp("appActivity");
			
			DesiredCapabilities cap = new DesiredCapabilities();

			cap.setCapability("platformName", "Android");
			cap.setCapability("appPackage", appPackage);
			cap.setCapability("appActivity", appActivity);
			cap.setCapability("automationName", "UiAutomator2");

			String emulatorDevice = Prop.getProp("mobile_emulator");
			if ("Y".equalsIgnoreCase(emulatorDevice)) {
				/**
				 * EMULATOR CAPABILITIES
				 * 
				 * To Open Emulator from terminal emulator -list-avds //lists the emulators by
				 * name emulator -avd Pixel_4_API_30 //To Start the emulator w/o opening Android
				 * Studio cd %ANDROID_HOME%\emulator && emulator -avd Pixel_3a_API_30
				 */

				/*
				 * cap.setCapability("deviceName", "sdk_gphone_x86");
				 * cap.setCapability("platformVersion", "11"); cap.setCapability("platformName",
				 * "Android"); cap.setCapability("udid", "emulator-5554");
				 */
				cap.setCapability("deviceName", deviceName);
				cap.setCapability("platformVersion", platformVersion);
				cap.setCapability("udid", udid);

			} else {

				/**
				 * PHYSICAL DEVICE CAPABILITIES
				 */

				/*
				 * cap.setCapability("deviceName", "can't find"); cap.setCapability("udid",
				 * "67692be2"); cap.setCapability("platformVersion", "11 RKQ1.200826.002");
				 */

				cap.setCapability("deviceName", deviceName);
				cap.setCapability("platformVersion", platformVersion);
				cap.setCapability("udid", udid);
			}

			String ip = Prop.getProp("IP");
			URL url = new URL("http://"+ip+":" + port + "/wd/hub");
			AndroidDriver<WebElement> driverApp = new AndroidDriver<WebElement>(url, cap);
			WebDriverWait wait = new WebDriverWait(driverApp, 10);

			ThreadLocalDriver.setAppiumDriver(driverApp);
			ThreadLocalDriver.setWait(wait);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void startWebDriver() {
		System.out.println(Thread.currentThread().getId() + " Base Test : startWebDriver()");

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Prop.getProp("wait_implicit")), TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(Prop.getProp("wait_explicit")));
		ThreadLocalDriver.setWebDriver(driver);
		ThreadLocalDriver.setWait(wait);
	}
	
	public static boolean checkIfServerIsRunnning(int port) {

	    boolean isServerRunning = false;
	    ServerSocket serverSocket;
	    try {
	        serverSocket = new ServerSocket(port);
	        serverSocket.close();
	    } catch (IOException e) {
	        //If control comes here, then it means that the port is in use
	        isServerRunning = true;
	    } finally {
	        serverSocket = null;
	    }
	    return isServerRunning;
	}
	public static void main(String[] args) {
		System.out.println(checkIfServerIsRunnning(6664));
	}
	
}
