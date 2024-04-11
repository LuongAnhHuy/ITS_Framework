package cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import webdriver.WebDriverFactory;

public class CucumberChromeHooks {

    @Before("@uiChrome")
    public void beforeEach(){
        WebDriverFactory.createChromeDriver();
    }
    @After("@uiChrome")
    public void afterEach(){
        WebDriverFactory.cleanUpDriver();
    }

}
