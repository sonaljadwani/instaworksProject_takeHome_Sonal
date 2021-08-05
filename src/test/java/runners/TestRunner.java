package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/java/com/features"},
		glue = {"stepdefinition","app"},
		plugin = {"pretty"
		}
		)

public class TestRunner {

}
