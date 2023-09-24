package stepDefinitions.base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.sql.Timestamp;

import static stepDefinitions.base.DriverFactory.cleanUpDriver;
import static stepDefinitions.base.DriverFactory.getDriver;

public class Hooks {

    @Before
    public void setUp() throws IOException {
      getDriver();
    }
    @AfterStep
    public void captureExceptionImage(Scenario scenario) throws IOException {
        if (scenario.isFailed()){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String timeMilliseconds = Long.toString(timestamp.getTime());

            byte[] screenshot = ((TakesScreenshot)  getDriver())
            .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png",timeMilliseconds);
        }
    }

    @After
    public void tearDown(){
       cleanUpDriver();
    }
}
