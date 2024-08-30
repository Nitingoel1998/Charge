package TestRunner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;




@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src//test//resources//Features//",
		glue = { "stepDefinitions" },
		tags ="@TC13_verifyPaymentProcessViaManualCard",
		dryRun = false,
		plugin = { "pretty",
				"html:target/cucumberReports/reports.html",
				"me.jvt.cucumber.report.PrettyReports:target/cucumber"},
		monochrome = true,
		publish =true

)
public class Runner {

}
