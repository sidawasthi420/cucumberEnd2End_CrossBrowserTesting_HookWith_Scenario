package testRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(
		features = "src/test/resources/features/test.feature",
		glue = {"stepDefinition","hooks"},
		plugin = {"pretty","html:target/cucumber-reports.html","json:target/cucumber-reports.json"},//,   pretty formats the test results in a human-readable format on the console
		monochrome = true,   // to make console output more readable by removing unnecessary characters
		tags = "@ChromeBrowser"
		)
	
public class runner extends AbstractTestNGCucumberTests{
	
	private TestNGCucumberRunner testNGCucumberRunner;


    @BeforeClass( alwaysRun = true )
    public void setUpClass()  {
        testNGCucumberRunner = new TestNGCucumberRunner( this.getClass() );
    }

    @Test( groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features" )
    public void feature( PickleWrapper pickleWrapper,FeatureWrapper cucumber Feature ) {
        testNGCucumberRunner.runScenario( pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass( alwaysRun = true )
    public void tearDownClass()  {
        testNGCucumberRunner.finish();
    }
}
