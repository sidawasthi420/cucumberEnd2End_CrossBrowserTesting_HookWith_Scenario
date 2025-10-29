package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/test.feature",
		glue = {"stepDefinition","hooks"},
		plugin = {"pretty","html:target/cucumber-reports.html","json:target/cucumber-reports.json"},//,   pretty formats the test results in a human-readable format on the console
		monochrome = true,   // to make console output more readable by removing unnecessary characters
		tags = "@ChromeBrowser"
		)
public class runner {

}
