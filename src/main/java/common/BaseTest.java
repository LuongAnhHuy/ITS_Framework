package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BaseTest extends AbstractPage {
    private WebDriver driver;
//    private String projectPath = System.getProperty("user.dir");

//    protected WebDriver getBrowserDriver(String browserName) {
//        switch (browserName) {
//            case "chrome":
//                System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
//                driver = new ChromeDriver();
//                break;
//            case "firefox":
//                System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//                driver = new FirefoxDriver();
//                break;
//            default:
//                throw new RuntimeException("Please enter the correct Browser name!!!");
//        }
//
//        driver.manage().window().maximize();
//        driver.get("https://demo.guru99.com/v4/");
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        return driver;
//    }
    protected WebDriver getBrowserDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                throw new RuntimeException("Please enter the correct Browser name!!!");
        }

        maximizeBrowsers(driver);
        implicitWaitBrowser(driver);
        return driver;
    }


    protected WebDriver closedBrowser() {
        closeBrowsers(driver);
        return driver;
    }

    protected int randomNumber() {
        Random rand = new Random();
        return rand.nextInt(999);
    }


}

