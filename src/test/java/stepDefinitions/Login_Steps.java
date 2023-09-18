package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class Login_Steps {
    private  static WebDriver driver;
    private WebDriverWait wait;
    @Before
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    @After
    public void tearDown(){
        driver.quit();
    }

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        driver.get("https://webdriveruniversity.com/Login-Portal/index.html");
        driver.manage().window().maximize();
    }

    @When("I enter username {string}")
    public void i_enter_username(String username) {
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
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertTrue(alert.getText().equals(message));
        alert.accept();
    }

}