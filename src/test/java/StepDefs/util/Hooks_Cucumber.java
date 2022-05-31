package StepDefs.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import runner.util.ThreadLocalDriver;

public class Hooks_Cucumber {


	@Before
	public void setUpCucumberHooks(Scenario sc) {
		String port = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("port");

		System.out.println(Thread.currentThread().getId() + " Hooks : @Before " + sc.getName() + sc.getSourceTagNames()+ port);
		ThreadLocalDriver.setScenario(sc.getName());
	}

	@After
	public void tearDownCucumberHooks(Scenario sc) {
		System.out.println(Thread.currentThread().getId() + " Hooks : @After" + sc.getSourceTagNames() + sc.getSourceTagNames().contains("@app"));

		
		if (sc.getSourceTagNames().contains("@web")) {
			if (sc.isFailed()) {
				final byte[] screenshot = ((TakesScreenshot) ThreadLocalDriver.getWebDriver()).getScreenshotAs(OutputType.BYTES);
				sc.attach(screenshot, "image/png", sc.getName()); // ... and embed it in the report.
			}
			
		} else if (sc.getSourceTagNames().contains("@app")) {
			
			System.out.println(Thread.currentThread().getId()+" App tearDown()");
			if (sc.isFailed()) {
				System.out.println(Thread.currentThread().getId()+" App tearDown() FAILED");
				final byte[] screenshot = ((TakesScreenshot) ThreadLocalDriver.getAppiumDriver()).getScreenshotAs(OutputType.BYTES);
				sc.attach(screenshot, "image/png", sc.getName()); // ... and embed it in the report.
			}
	
		}

	}
}
