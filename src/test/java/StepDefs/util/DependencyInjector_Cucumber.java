package StepDefs.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.util.Prop;

import io.appium.java_client.AppiumDriver;
import or.app.android.LoginCustomerApp;
import or.web.admin.LoginAdmin;
import or.web.admin.LoginSuperAdmin;
import or.web.customer.LoginCustomer;
import runner.util.ThreadLocalDriver;

public class DependencyInjector_Cucumber {
	
	public DependencyInjector_Cucumber() {
		System.out.println(Thread.currentThread().getId() + " DI: @Before setUp()");
	}

	public void loadUrl(String site) {
		System.out.println(Thread.currentThread().getId() + " DI: loadUrl()");

		String url = "";
		switch (site) {
		case "SUPER_ADMIN":
			url = Prop.getProp("superAdminUrl");
			break;
		case "ADMIN":
			url = Prop.getProp("adminUrl");
			break;
		case "CUSTOMER":
			url = Prop.getProp("customerUrl");
			break;
		}
		ThreadLocalDriver.getWebDriver().get(url);
	}

	
	public WebDriver getWebDriver() {
		System.out.println(Thread.currentThread().getId() + " DI: getWebDriver()");
		return ThreadLocalDriver.getWebDriver();
	}

	public AppiumDriver<WebElement> getAppiumDriver() {
		System.out.println(Thread.currentThread().getId() + " DI: getAppiumDriver()");
		return ThreadLocalDriver.getAppiumDriver();
	}

	public WebDriverWait getWait() {
		System.out.println(Thread.currentThread().getId() + " DI: getWait()");
		return ThreadLocalDriver.getWait();
	}


	//TODO Object Repositories objects
	public LoginCustomerApp getLoginCustomerApp() {
		return new LoginCustomerApp();
	}

	public LoginAdmin getLoginAdmin() {
		return new LoginAdmin();
	}

	public LoginCustomer getLoginCustomer() {
		return new LoginCustomer();
	}

	public LoginSuperAdmin getLoginSuperAdmin() {
		return new LoginSuperAdmin();
	}

}