package tRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
				features="./Features",
				glue="stepDefinition",
				dryRun=false,
				monochrome=true,
				plugin= { "pretty:target/pretty/report .txt",
						   "html:target/html/htmlreport.html",
						   "json:target/json/jsonreport.json",
						   "junit:target/junit/junitreport.xml"
				         }
				
                   )
public class TestRunner {

}
