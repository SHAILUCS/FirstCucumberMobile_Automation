package StepDefs.web.admin;

import StepDefs.util.DependencyInjector_Cucumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AmplifyAdminLogin_StepDef {
	
	DependencyInjector_Cucumber di;
	
	public AmplifyAdminLogin_StepDef(DependencyInjector_Cucumber di) {
		this.di = di;
	}

	@Given("Admin Login Page is opened")
	public void admin_login_page_is_opened() {
		di.loadUrl("ADMIN");
	}

	@Given("Perform Admin Login")
	public void perform_admin_login() {
		di.getLoginAdmin().performLogin();
	}

	@Then("Admin Dashboard is displayed")
	public void admin_dashboard_is_displayed() {
		
	}
}
