package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static StepDefinitions.LoginSteps.getDriver;
import static java.lang.Thread.sleep;

public class VerifyCustomerTable {

    WebDriver driver = getDriver();

    @Given("I click on Customers")
    public void iClickOnCustomers() {

        WebElement showCustList = driver.findElement(By.xpath("//*[@ng-click='showCust()']"));
        showCustList.click();


    }

    @When("I browse Customer Table")
    public void iBrowseCustomerTable() {
    }


    @Then("I see the customer on the table {string} {string}")
    public void iSeeTheCustomerOnTheTable(String fName, String lName) throws InterruptedException {
        System.out.println("Searching for " + fName + " " + lName + " ...");
        Thread.sleep(1500);
        WebElement CustTB = driver.findElement(By.tagName("TABLE"));
        List<WebElement> tableRows = CustTB.findElements(By.tagName("tr"));
        int rowSize = tableRows.size();
        int row = 0;
        boolean custExists;

            while (row < rowSize) {
                String custF = tableRows.get(row).getText();
                String custName = fName + " " + lName;
                if (custF.contains(custName)) {
                    System.out.println(custName + " exists.");
                    Assert.assertTrue(custExists=true);
                    break;
                }
                row++;
            }
    }
}