package TestCases;

import Pages.*;
import Settings.testSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import Listeners.testListeners;
import static org.testng.Assert.assertTrue;

@Listeners(testListeners.class)

public class testCaseCheckOut {

    private WebDriver driver;

    @BeforeMethod
    public void testBrowserSetup(){
        driver = testSetup.driverSetup(); // Initialize WebDriver
        testListeners.setupDriver(driver); // Pass WebDriver to the listener
    }
    
    @Test
    public void completeCheckoutSingletItem(){
        //Login as valid user
        LoginPage userLogin = new LoginPage(driver);
        userLogin.loginAsValidUser();

        //Add to cart Item for checkout
        InventoryPage addToCart = new InventoryPage(driver);
        addToCart.addToCartBackPack();
        addToCart.gotoCart();


        //Proceed to checkout
        cartPage gotoCheckoutPage = new cartPage(driver);
        gotoCheckoutPage.checkOutItem();

        //Fill out user details then proceed to next step
        checkOutFirstStepPage userDetails = new checkOutFirstStepPage(driver);
        userDetails.fillOutFirstName();
        userDetails.fillOutLastName();
        userDetails.fillOutPostalCode();
        userDetails.clickContinueButton();

        //Finalize item checkout
        checkOutSecondStepPage completeCheckout = new checkOutSecondStepPage(driver);
        completeCheckout.clickFinishButton();

        //Verify if the checkout process it success
        checkOutCompletePage checkOutSuccess = new checkOutCompletePage(driver);

        assertTrue(checkOutSuccess.getSecondaryPageTitle().isDisplayed());
        assertTrue(checkOutSuccess.getCompletedOrderHeader().isDisplayed());
        assertTrue(checkOutSuccess.getCompletedOrderText().isDisplayed());

    }
    @AfterMethod
    public void browserTearDown(){
        //End test
        testSetup.testTearDown();
    }

}
