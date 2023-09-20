package stepDefinitions.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static stepDefinitions.base.DriverFactory.cleanUpDriver;
import static stepDefinitions.base.DriverFactory.getDriver;

public class Hooks {

    @Before
    public void setUp(){
      getDriver();
    }
    @After
    public void tearDown(){
       cleanUpDriver();
    }
}
