package StepDefs.web.customer;

import org.springframework.util.SystemPropertyUtils;

import StepDefs.util.DependencyInjector_Cucumber;
import io.cucumber.core.options.CucumberProperties;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AmplifyCustomerPortalLogin_StepDef {
	DependencyInjector_Cucumber di;
	
	public AmplifyCustomerPortalLogin_StepDef(DependencyInjector_Cucumber di) {
		this.di = di;
	}
	
	@Given("Customer Login Page is opened")
	public void customer_login_page_is_opened() {
		di.loadUrl("CUSTOMER");
	}
	
	@Given("Perform Customer Login")
	public void perform_customer_login() {
		di.getLoginCustomer().performLogin();
	}

	@Then("Customer Dashboard is displayed")
	public void customer_dashboard_is_displayed() {
		
	}

}