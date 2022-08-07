package stepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = {"stepDefinitions"},
        tags = "@sanityTest or @smokeTest",
        monochrome = true,
        plugin = {"pretty", "html:target/cucumber-reports/html-report/todo-cucumber-report.html", "json:target/cucumber-reports/json-report/todo-cucumber-report.json"})

public class TestRunner {
}
