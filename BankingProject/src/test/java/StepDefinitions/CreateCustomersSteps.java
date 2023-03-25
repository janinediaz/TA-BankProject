package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static StepDefinitions.LoginSteps.getDriver;
import static java.lang.Thread.sleep;

public class CreateCustomersSteps {

    WebDriver driver = getDriver();

    @Given("I click on Add New Customer Button")
    public void iClickOnAddNewCustomerButton() throws InterruptedException {
        Thread.sleep(1500);
        WebElement AddCustomerBtn = driver.findElement(By.xpath("//*[@ng-click='addCust()']"));
        AddCustomerBtn.click();
    }

    @Given("I input the customer first name {string}")
    public void iInputTheCustomerFirstName(String firstname) throws InterruptedException {
        Thread.sleep(1500);
        WebElement inputFName = driver.findElement(By.xpath("//*[@ng-model='fName']"));
        inputFName.sendKeys(firstname);

    }

    @Given("I input the customer last name {string}")
    public void iInputTheCustomerLastName(String lastname) {
        WebElement inputLName = driver.findElement(By.xpath("//*[@ng-model='lName']"));
        inputLName.sendKeys(lastname);
    }

    @Given("I input the customer post code {string}")
    public void iInputTheCustomerPostCode(String postCode) {
        WebElement inputPostCode = driver.findElement(By.xpath("//*[@ng-model='postCd']"));
        inputPostCode.sendKeys(postCode);
    }

    @When("I click Add customer")
    public void iClickAddCustomer() {
        WebElement AddCust = driver.findElement(By.xpath("//*[@class='btn btn-default'][@type='submit']"));
        AddCust.click();

    }

    @Then("the customers should be created successfully")
    public void theCustomersShouldBeCreatedSuccessfully() throws InterruptedException {
        Thread.sleep(1500);
        driver.switchTo().alert().accept();
    }
}
