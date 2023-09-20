package stepDefinitions.base;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

   public static WebDriver getDriver(){
       if (webDriver.get() == null){
           webDriver.set(createDriver());
       }
       return webDriver.get();
   }
    private static WebDriver createDriver(){
        WebDriver driver = null;
        String browserType = "chrome";
        switch (browserType){
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(options);
              break;
            case "firefox":
                FirefoxDriver firefoxDriver = new FirefoxDriver();
                FirefoxOptions ffoptions = new FirefoxOptions();
                ffoptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new FirefoxDriver(ffoptions);
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }
public static void cleanUpDriver(){
        webDriver.get().quit();
        webDriver.remove();
}
}
