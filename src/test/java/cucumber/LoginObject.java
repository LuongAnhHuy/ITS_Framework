package cucumber;

import common.AbstractPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginObject extends AbstractPage {
    WebDriver driver;

    public static final String USER_ID = "//input[@name='uid']";
    public static final String PASSWORD_TEXTBOX = "//input[@name='password']";
    public static final String LOGIN_BUTTON = "//input[@name='btnLogin']";
    public static final String HEADING = "//marquee[@class='heading3']";
    @When("I open page on Guru {string}")
    public void iOpenPageOnGuru(String pageURL) {
        openUrl(driver, pageURL);
    }

    @And("I fill {string} to username")
    public void iFillToUsername(String username) {
        sendkeyToElement(driver, USER_ID, username);
    }

    @And("I fill {string} to password")
    public void iFillToPassword(String password) {
        sendkeyToElement(driver, PASSWORD_TEXTBOX, password);
    }

    @And("I click to login button")
    public void iClickToLoginButton() {
        clickToElement(driver, LOGIN_BUTTON);
    }

    @Then("I verify homepage name {string}")
    public void iVerifyHomepageName(String expected) {
        String actual = getTextElement(driver, HEADING);
        Assert.assertEquals(actual, expected);
    }
}
