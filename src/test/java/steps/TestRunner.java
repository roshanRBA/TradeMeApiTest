package steps;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/features"},
        glue = "steps",
        plugin= {"pretty","html:target/site/cucumber-pretty"}
)

class TestRunner extends AbstractTestNGCucumberTests {


}
