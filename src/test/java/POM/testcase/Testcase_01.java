package POM.testcase;

import POM.object.ManagerPageObject;
import POM.object.RegisterPageObject;
import POM.object.LoginPageObject;
import POM.object.NewCustomerPageObject;
import common.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import resources.Log;

public class Testcase_01 extends BaseTest {
    WebDriver driver;

    String loginPageUrl, userID, password;

    LoginPageObject loginPage;
    RegisterPageObject registerPage;
    ManagerPageObject managerPage;
    NewCustomerPageObject newCustomerPage;


    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName);
        Log.info("Pre-conditions - Step 01: Open browser + Navigate to app url");
        openUrl(driver,"https://demo.guru99.com/v4/");
        loginPage = new LoginPageObject(driver);
    }

    @AfterClass
    public void afterClass() {
        closedBrowser();
    }

    @Test
    public void TC_01_Register_To_System() {
        Log.info("Register - Step 01: Get Login Page Url");
        loginPageUrl = loginPage.getLoginPageUrl();

        Log.info("Register - Step 02: Click to 'here' link");
        loginPage.clickToHereLink();

        loginPage.closeIframe();

        registerPage = new RegisterPageObject(driver);

        Log.info("Register - Step 03: Input to Email textbox");
        registerPage.inputToEmailTextbox("automationfc@gmail.com");

        Log.info("Register - Step 04: Click to Submit button");
        registerPage.clickToSubmitButton();

        Log.info("Register - Step 05: Get UserID/ Password information");
        userID = registerPage.getUserIDText();
        password = registerPage.getPasswordText();
    }

    @Test
    public void TC_02_Login_To_System() {
        Log.info("Login - Step 01: Open Login Page");
        registerPage.openLoginPage(loginPageUrl);

        loginPage = new LoginPageObject(driver);

        Log.info("Login - Step 02: Input to UserID/ Password textbox");
        loginPage.inputToUserIDTextbox(userID);
        loginPage.inputToPasswordTextbox(password);

        Log.info("Login - Step 03: Click to Login button");
        loginPage.clickToLoginButton();

        managerPage = new ManagerPageObject(driver);

        Log.info("Login - Step 04: Navigate to Home Page");
        Assert.assertEquals(managerPage.getWelcomeMessageText(), "Welcome To Manager's Page of Guru99 Bank");
    }

    @Test
    public void TC_03_New_Customer() {
        Log.info("NewCustomer - Step 01: Open new Customer Page");
        managerPage.openNewCustomerPage();
        newCustomerPage = new NewCustomerPageObject(driver);

        Log.info("NewCustomer - Step 02: Input to Name textbox ");
        newCustomerPage.inputToNameTextbox("Jonh Roonet");

        Log.info("NewCustomer - Step 03: Input to Date of Birth textbox");
        newCustomerPage.inputToDOBTextbox("01/01/1990");

        Log.info("NewCustomer - Step 04: Input to Address area");
        newCustomerPage.inputToAddressTextArea("226 PO Address");

        Log.info("NewCustomer - Step 05: Input to City textbox");
        newCustomerPage.inputToCityTextbox("Califolina");

        Log.info("NewCustomer - Step 06: Input to State textbox");
        newCustomerPage.inputToStateTextbox("NewYork");

        Log.info("NewCustomer - Step 07: Input to Pin textbox");
        newCustomerPage.inputToPinTextbox("567889");

        Log.info("NewCustomer - Step 08: Input to Phone textbox");
        newCustomerPage.inputToPhoneTextbox("0978687125");

        Log.info("NewCustomer - Step 09: Input to Email textbox");
        newCustomerPage.inputToEmailTextbox("automationfc" + randomNumber() + "@gmail.com");

        Log.info("NewCustomer - Step 10: Input to Password textbox");
        newCustomerPage.inputToPasswordTextbox("haha123456");

        Log.info("NewCustomer - Step 11: Click to Submit button");
        newCustomerPage.clickToSubmitButton();

        Log.info("NewCustomer - Step 12: Verify success message");
        Assert.assertEquals(newCustomerPage.getSuccessMessage(), "Customer Registered Successfully!!!");
    }

    @Test
    public void TC_O4_LogOut() {
        Log.info("LogOut - Step 01: Click to Logout link");
        managerPage = new ManagerPageObject(driver);
        managerPage.clickToLogOutLink();

        Log.info("LogOut - Step 02: Accept Alert");
        managerPage.acceptToAlert();

        loginPage = new LoginPageObject(driver);

        Log.info("LogOut - Step 03: Verify Login Form Displayed");
        Assert.assertTrue(loginPage.isLoginFormDisplayed());

    }


}
