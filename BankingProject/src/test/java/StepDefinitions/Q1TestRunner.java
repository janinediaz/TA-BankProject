package StepDefinitions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;




@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/CucumberReports/Q1TestRun/Q1TestCucumberReport"},
        features = {"src/test/Resources/Feature/TA01Login.feature","src/test/Resources/Feature/TA02CreateCustomer.feature","src/test/Resources/Feature/TA03VerifyCustomerTable.feature", "src/test/Resources/Feature/TA04DeleteCustomers.feature"},
        glue = {"StepDefinitions"},
        tags = "not @Customer",
        publish = true
)


public class Q1TestRunner {

}
