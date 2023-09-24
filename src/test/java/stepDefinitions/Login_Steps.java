package stepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static stepDefinitions.base.DriverFactory.getDriver;

public class Login_Steps  {
    private WebDriver driver = getDriver();

    public Login_Steps() throws IOException {
    }

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        driver.get("https://webdriveruniversity.com/Login-Portal/index.html");
    }

    @When("I enter username {string}")
    public void i_enter_username(String username)  {
        driver.findElement(By.id("text")).sendKeys(username);
    }
    @When("I enter password {string}")
    public void i_enter_password(String password) {
       driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("I should get an Alert with {string}")
    public void i_should_get_an_alert_with(String message) {

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alert.getText().equals(message));
        alert.accept();
    }

    @When("I enter a username {string}")
    public void i_enter_a_username(String username) throws IOException {
        WebElement header1 = driver.findElement(By.id("text"));
        header1.clear();
        driver.findElement(By.id("text")).sendKeys(username);
        File srcFile = header1.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("./resources/screenshots/image1.png"));
    }
    @When("I enter a password {string}")
    public void i_enter_a_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Then("I should be presented with the following login validation message {string}")
    public void i_should_be_presented_with_the_following_login_validation_message(String message) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alert.getText().equals(message));
        alert.accept();
    }

}