package stepDefinitions.base;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static Properties prop = new Properties();
    private static FileInputStream fi;


    public DriverFactory() throws FileNotFoundException {
    }

    public static WebDriver getDriver() throws IOException {
       if (webDriver.get() == null){
           webDriver.set(createDriver());
       }
       return webDriver.get();
   }
    private static WebDriver createDriver() throws IOException {
        WebDriver driver = null;
        fi = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
        prop.load(fi);
        String browserType = prop.getProperty("browser");
        switch (browserType){
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(options);
              break;
            case "firefox":
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
