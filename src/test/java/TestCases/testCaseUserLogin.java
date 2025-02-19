package TestCases;


import Pages.LoginPage;
import Settings.testSetup;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import Listeners.testListeners;

@Listeners(testListeners.class)

public class testCaseUserLogin extends testSetup{

    private WebDriver driver;

    @BeforeMethod
    public void validUserLoginSetup(){
        driver = testSetup.driverSetup(); // Initialize WebDriver
        testListeners.setupDriver(driver); // Pass WebDriver to the listener
    }

    @Test
    public void validUserLogin() {
        //test setup
        LoginPage UserLogin = new LoginPage(driver);

        //test actions
        UserLogin.loginAsValidUser();

        //verification
        String actualPageHeader = UserLogin.verifyPageHeader();
        String expectedPageHeader = "Swag Labs";
        Assert.assertEquals(actualPageHeader, expectedPageHeader,"Login success");
    }

    @Test
    public void lockUserLogin(){
        //test setup
        LoginPage lockUserLogin = new LoginPage(driver);

        //test actions
       lockUserLogin.loginAsLockedUser();

        //verification
        String expectedLockedErrorMsg = "Epic sadface: Sorry, this user has been locked out.";
        String actualLockedErrorMsg = lockUserLogin.GetLockUserErrorMsg();
        Assert.assertEquals(expectedLockedErrorMsg, actualLockedErrorMsg, " " + actualLockedErrorMsg);
    }

    @AfterMethod
    public void teardownUserLogin(){
        testSetup.testTearDown();
    }
}
