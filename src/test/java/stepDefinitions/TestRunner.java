package stepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",
        glue={"stepDefinitions"},
        tags = "@sanityTest or @smokeTest",
monochrome = true,
plugin = {"pretty","json:src/test/reports/json_reports/todo_report.json"})

public class TestRunner {
}
