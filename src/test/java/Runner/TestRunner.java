package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        tags = "@CheckBeanLidTheProduct",
        features = {"src/test/resources/features"},
        glue = {"StepDefinitions", "utils"},
        plugin = {
                "pretty"
                //"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"

        }
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
