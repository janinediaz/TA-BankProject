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

public class DeleteCustomersSteps {

    WebDriver driver = getDriver();

    @Given("I search customer {string} {string} {string} and delete customer")
    public void iSearchCustomerAndDeleteCustomer(String FName, String LName, String PCode) throws InterruptedException {
        System.out.println("Searching for " + FName + " " + LName + " with Post Code " + PCode + " ...");
        Thread.sleep(1500);
        WebElement SearchInput = driver.findElement(By.xpath("//*[@ng-model='searchCustomer']"));
        SearchInput.clear();
        SearchInput.sendKeys(PCode);
        Thread.sleep(1500);
        WebElement CustTB = driver.findElement(By.tagName("TABLE"));
        List<WebElement> tableRows = CustTB.findElements(By.tagName("tr"));
        int rowSize = tableRows.size();
        int row = 1;


        while (row <= rowSize) {
            String custF = tableRows.get(row).getText();
            System.out.println(custF+"Checking customer... ");
            String custName = FName + " " + LName + " " + PCode;
            if (custF.contains(custName)) {
                System.out.println(custName+" found. Deleting...");
                String xp = "//table/tbody/tr["+row+"]/td[5]/button";
                WebElement DelBtn = driver.findElement(By.xpath(xp));
                DelBtn.click();
                System.out.println("Customer deleted.");
                break;
            }
            row++;
        }

    }

    @Then("customer {string} {string} {string} should be deleted successfully")
    public void customerShouldBeDeletedSuccessfully(String FName, String LName, String PCode) throws InterruptedException {

        System.out.println("Verifying " + FName + " " + LName + " with Post Code " + PCode + " ...");
        Thread.sleep(1500);
        WebElement SearchInput = driver.findElement(By.xpath("//*[@ng-model='searchCustomer']"));
        SearchInput.clear();
        SearchInput.sendKeys(PCode);
        Thread.sleep(1500);
        WebElement CustTB = driver.findElement(By.tagName("TABLE"));
        List<WebElement> tableRows = CustTB.findElements(By.tagName("tr"));
        int rowSize = tableRows.size();
        int row = 1;
        boolean custNotExist;

        while (row <= rowSize) {
            String custF = tableRows.get(row).getText();
            System.out.println(custF+"Checking customer... ");
            String cust = FName + " " + LName + " " + PCode;
            if (custF.contains(cust)) {
                System.out.println(cust + " still exists.");
            }
            else {
                System.out.println(cust + " does not exist.");
                Assert.assertTrue(custNotExist=true);
                break;
            }
            row++;
        }

    }

}
