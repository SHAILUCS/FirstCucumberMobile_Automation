package StepDefs.app;

import StepDefs.util.DependencyInjector_Cucumber;
import io.cucumber.core.options.CucumberProperties;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import or.app.android.LoginCustomerApp;
import runner.util.ThreadLocalDriver;

public class AmplifyCustomerAppLogin_StepDef {

	DependencyInjector_Cucumber di;
	public AmplifyCustomerAppLogin_StepDef(DependencyInjector_Cucumber di) {
		this.di = di;
	}
	
	@Given("Customer App Login Screen is opened")
	public void customer_app_login_screen_is_opened() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("SSR | @Given(Customer App Login Screen is opened)");
	}
	
	@Given("Perform Customer App Login")
	public void perform_customer_app_login() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("SSR | @Given(Perform Customer App Login)");
		di.getLoginCustomerApp().performLogin(ThreadLocalDriver.getScenario(), "");
		//di.getLoginCustomerApp().performLogin("+919967489701", "Amplify@123");
	}

	@Then("Customer App Dashboard is displayed")
	public void customer_app_dashboard_is_displayed() {
		
	}
}
