package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "tests",
        dryRun = false,
        tags = "@regression",
        monochrome = true,
        plugin = {"pretty"}
)
public class RegressionRunner {
}
