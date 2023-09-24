package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import stepDefinitions.base.Hooks;

import java.io.IOException;
import java.time.Duration;

import static stepDefinitions.base.DriverFactory.getDriver;

public class Contact_Us_Steps  {
    private WebDriver driver = getDriver();

    public Contact_Us_Steps() throws IOException {
    }

    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {

        driver.get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        driver.findElement(By.xpath("//*[@name='first_name11111']")).sendKeys("Alan");
    }
    @When("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        driver.findElement(By.xpath("//*[@name='last_name']")).sendKeys("Parker");
    }
    @When("I enter a unique email adress")
    public void i_enter_a_unique_email_adress() {
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys("ap@hotmail.com");
    }
    @When("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        driver.findElement(By.xpath("//*[@name='message']")).sendKeys("Lorem Ipsum is slechts een proeftekst uit het drukkerij- en zetterijwezen. Lorem Ipsum is de standaard proeftekst in deze bedrijfstak sinds de 16e eeuw, toen een onbekende drukker een zethaak met letters nam en ze door elkaar husselde om een font-catalogus te maken.");
    }
    @When("I enter a specific first name joe")
    public void i_enter_a_specific_first_name_joe() {
        System.out.println("I enter a specific firstname joe");
    }
    @When("I enter a specific last name blogs")
    public void i_enter_a_specific_last_name_blogs() {
        System.out.println("i enter a specfic last name blogs");
    }
    @When("I enter a specific email adress joe_blogs123@mail.com")
    public void i_enter_a_specific_email_adress_joe_blogs123_mail_com() {
        System.out.println("i enter a specific email");
    }
    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String string) {
        System.out.println("comment " + string);
    }

    @When("I click on the submit button")
    public void i_click_on_the_submit_button() {
        driver.findElement(By.xpath("//*[@type='submit']")).click();
    }

    @Then("I should be presented with a succesful contact us submission message")
    public void i_should_be_presented_with_a_succesful_contact_us_submission_message() {
        String expected = "Thank You for your Message!";
        Assert.assertEquals(driver.findElement(By.id("contact_reply")).getText(),expected);

    }

    @When("I click on the reset button")
    public void i_click_on_the_reset_button() {
        driver.findElement(By.xpath("//*[@value='RESET']")).click();
    }

    @Then("I should be presented with a empty contact Form")
    public void i_should_be_presented_with_a_empty_contact_form() {
        System.out.println(driver.findElement(By.xpath("//*[@name='contactme']")).getText());
    }


}
