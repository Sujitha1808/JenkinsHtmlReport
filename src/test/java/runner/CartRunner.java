package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class CartRunner 
{
	@CucumberOptions(
		    features = "src/test/resources/features",
		    glue = "stepDefinitions",
		    plugin = {"pretty","json:target/cucumber-reports-json/Cucumber.json","html:target/cucumber-reports-html.html"},
		    tags = "@CartTest"
		)
		public class TestRunner extends AbstractTestNGCucumberTests 
		{
			
		}


}
