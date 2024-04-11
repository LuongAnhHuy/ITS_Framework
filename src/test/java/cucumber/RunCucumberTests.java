package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/featurefiles",
        glue = "cucumber.object",
        plugin = {"pretty", "html:target/cucumber-html-report.html"}
)
@Test
public class RunCucumberTests extends AbstractTestNGCucumberTests {
}
