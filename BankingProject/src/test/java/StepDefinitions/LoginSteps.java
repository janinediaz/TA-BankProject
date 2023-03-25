package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;


public class LoginSteps {
    private static WebDriver webdriver;


    @Given("I would like to launch the Banking Page URL {string}")
    public void launchPage(String url) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        webdriver = new ChromeDriver(options);
        webdriver.get(url);
    }

    @Then("I login as Bank Manager")
    public void iLoginAsBankManager() throws InterruptedException {
        Thread.sleep(1500);
        WebElement BMLogin = webdriver.findElement(By.xpath("//*[@ng-click='manager()']"));
        BMLogin.click();
    }

    @Then("I login as {string}")
    public void iLoginAs(String CName) throws InterruptedException {
        Thread.sleep(1500);
        WebElement CLogin = webdriver.findElement(By.xpath("//*[@ng-click='customer()']"));
        CLogin.click();
        Thread.sleep(1500);
        Select drpName = new Select(webdriver.findElement(By.id("userSelect")));
        drpName.selectByVisibleText(CName);
        WebElement logbtn = webdriver.findElement(By.xpath("//*[@class='btn btn-default']"));
        logbtn.click();
    }

    public static WebDriver getDriver() {

        return webdriver;
    }



}
