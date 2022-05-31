package StepDefs.web.admin;

import StepDefs.util.DependencyInjector_Cucumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AmplifySuperAdminLogin_StepDef {

	DependencyInjector_Cucumber di;

	public AmplifySuperAdminLogin_StepDef(DependencyInjector_Cucumber di) {
		this.di = di;
	}

	@Given("Super Admin Login Page is opened")
	public void super_admin_login_page_is_opened() {
		di.loadUrl("SUPER_ADMIN");
	}

	@Given("Perform Super Admin Login")
	public void perform_super_admin_login() {
		di.getLoginSuperAdmin().performLogin();
	}

	@Then("Super Admin Dashboard is displayed")
	public void super_admin_dashboard_is_displayed() {

	}
}
