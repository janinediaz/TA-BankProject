package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import static StepDefinitions.LoginSteps.getDriver;
import static java.lang.Thread.sleep;

public class Transactions {
    WebDriver driver = getDriver();

    @Given("I login as customer and select {int}")
    public void iLoginAsCustomerAndSelect(int acctNum) throws InterruptedException {
        //select Account Number
        Thread.sleep(1500);
        Select drpAcctNumber = new Select(driver.findElement(By.id("accountSelect")));
        String accNo =Integer.toString(acctNum);
        drpAcctNumber.selectByVisibleText(accNo);
    }


    @When("I make a {string} of {string}")
    public void iMakeAOf(String transactionType, String amount) throws InterruptedException {
        //convert amount to int
        int transAmt = Integer.parseInt(amount);

        if (transactionType.equals("Credit")) {
            //click deposit
            WebElement depBtn = driver.findElement(By.xpath("//*[@ng-click='deposit()']"));
            depBtn.click();
            Thread.sleep(1500);

            //enter amount
            WebElement inputAmt = driver.findElement(By.xpath("//*[@ng-model='amount']"));
            inputAmt.sendKeys(String.valueOf(transAmt));
        }
        else {
            //click withdraw
            WebElement withBtn = driver.findElement(By.xpath("//*[@ng-click='withdrawl()']"));
            withBtn.click();
            Thread.sleep(1500);
            //enter amount
            WebElement inputAmt = driver.findElement(By.xpath("//*[@ng-model='amount']"));
            inputAmt.sendKeys(String.valueOf(transAmt));
        }

    }
    @Then("I verify my balance after {string} of {string}")
    public void iVerifyMyBalanceAfterOf(String transType, String amt) throws InterruptedException {
        int totalBal;
        //convert amount to int
        int transAmt = Integer.parseInt(amt);
        //check current balance
        String curBal = driver.findElement(By.xpath("//strong[2]")).getText();
        int currentBalance = Integer.parseInt(curBal);
        System.out.println("Current balance: " + currentBalance);

        //Calculate balance
        if (transType.equals("Credit")) {
            totalBal = currentBalance + transAmt;
            System.out.println("Credit "+transAmt);
            System.out.println("Total balance: " + totalBal);

        }
        else {
            totalBal = currentBalance - transAmt;
            System.out.println("Debit "+transAmt);
            System.out.println("Total balance: " + totalBal);


        }

        Thread.sleep(1500);
        WebElement btnConfirm = driver.findElement(By.cssSelector("button[class='btn btn-default'][type='submit']"));
        btnConfirm.click();

        //verify balance is the same with calculation
        String upBal = driver.findElement(By.xpath("//strong[2]")).getText();
        int updatedBal = Integer.parseInt(upBal);
        System.out.println("Current balance: " + updatedBal);

        if (updatedBal == totalBal) {
            System.out.println(updatedBal + " = " + totalBal + " : Accurate Calculation");
            Assert.assertEquals(updatedBal, totalBal);
        }
        else{
            System.out.println(updatedBal + " != " + totalBal + " : Incorrect Calculation");
            Assert.assertNotEquals(updatedBal, totalBal);
        }

    }

}
