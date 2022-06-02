package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import runner.util.BaseTest;

@CucumberOptions(features = { "src/test/resources/feature/app/device1" }, glue = {
		"StepDefs" }, tags = "@run", monochrome = true, plugin = { "pretty", "html:target/HtmlReports/report1.html",
				"json:target/json-cucumber-reports/cukejson1.json",
				"testng:target/testng-cucumber-reports/cuketestng1.xml" })
public class AppTestRunner1 extends BaseTest {

	 private TestNGCucumberRunner testNGCucumberRunner;

	    @BeforeClass(alwaysRun = true)
	    public void setUpClass() {
	        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	    }

	    @Test(groups = "cucumber", description = "Run Cucumber Features.", dataProvider = "scenarios")
	    public void scenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
	        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
	    }

	    @DataProvider
	    public Object[][] scenarios() {
	        return testNGCucumberRunner.provideScenarios();
	    }

	    @AfterClass(alwaysRun = true)
	    public void tearDownClass() {
	        testNGCucumberRunner.finish();
	    }
}