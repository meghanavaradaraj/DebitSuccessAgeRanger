package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//@formatter:off
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/java/testScenarios", glue = "stepDefinitions", 
		tags = { "@NavigateToAgeRanger, @AddPerson, @EditPerson, @SearchPerson, @DeletePerson, @VerifyFieldValidations, @APITests, @closeBrowser" },
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:reports/ageRangerAutomatedTestReport.html" })

public class RunTest {

}

