package runner;

import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features/"}, glue = "steps", plugin = {"json:target/cucumber.json", "html:target/cucumber-reports.html"})

public class TestRunner {


}
