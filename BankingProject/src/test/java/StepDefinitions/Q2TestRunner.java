package StepDefinitions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/CucumberReports/Q2TestRun/Q2TestCucumberReport"},
        features = {"src/test/Resources/Feature/TA01Login.feature","src/test/Resources/Feature/TA05Transaction.feature"},
        glue = {"StepDefinitions"},
        tags = "not @Manager",
        publish = true
)


public class Q2TestRunner {

}
