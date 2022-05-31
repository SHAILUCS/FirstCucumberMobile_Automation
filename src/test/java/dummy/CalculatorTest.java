package dummy;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class CalculatorTest {

	public static AppiumDriver<WebElement> appDriver;

	public static void main(String[] args) {
		emulatorCalcTest();
		//physicalDeviceCalcTest();
	}

	private static void emulatorCalcTest() {
		try {
			openCalc(true);
			additionTest();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	private static void physicalDeviceCalcTest() {
		try {
			openCalc(false);
			additionTest();
			//confirmation();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	private static void openCalc(boolean emulator) throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();

		if (emulator) {
			/**
			 * EMULATOR CAPABILITIES
			 */
			cap.setCapability("deviceName", "sdk_gphone_x86");
			cap.setCapability("udid", "emulator-5554");
			cap.setCapability("platformName", "Android");
			cap.setCapability("platformVersion", "11");
			cap.setCapability("appPackage", "com.google.android.calculator");
			cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		} else {

			/**
			 * PHYSICAL DEVICE CAPABILITIES
			 */

			cap.setCapability("deviceName", "can't find");
			cap.setCapability("udid", "67692be2");
			cap.setCapability("platformName", "Android");
			cap.setCapability("platformVersion", "11 RKQ1.200826.002");
			cap.setCapability("appPackage", "com.google.android.calculator");
			cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		//	cap.setCapability("appPackage", "com.miui.calculator");
		//	cap.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
		}

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		appDriver = new AndroidDriver<WebElement>(url, cap);

	}

	
	//TODO TEST METHODS
	private static void confirmation() {
		appDriver.findElement(By.xpath("//*[@resource-id='android:id/button1']")).click();
		/*
		 * resource-id android:id/button1
		 * 
		 * resource-id android:id/button2
		 */
	}
	
	private static void additionTest() {
		appDriver.findElement(By.id("com.google.android.calculator:id/digit_4")).click();
		appDriver.findElement(By.id("com.google.android.calculator:id/digit_6")).click();
		
		appDriver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
		
		appDriver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();

		appDriver.findElement(By.id("com.google.android.calculator:id/eq")).click();

		String result = appDriver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();
		
		if (result.contains("55")) {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}
		
		
	}
	
}
