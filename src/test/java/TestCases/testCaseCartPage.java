package TestCases;

import Pages.InventoryPage;
import Pages.LoginPage;
import Pages.cartPage;
import Pages.checkOutFirstStepPage;
import Settings.testSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import Listeners.testListeners;
import static org.testng.Assert.assertTrue;

@Listeners(testListeners.class)

public class testCaseCartPage {

    private WebDriver driver;

    @BeforeMethod
    public void setupCartTest(){
        driver = testSetup.driverSetup(); // Initialize WebDriver
        testListeners.setupDriver(driver); // Pass WebDriver to the listener
    }

    @Test
    public void verifyCartPageSecondaryTitle(){

        LoginPage userLogin = new LoginPage(driver);
        userLogin.loginAsValidUser();

        InventoryPage addtoCart = new InventoryPage(driver);
        addtoCart.addToCartBackPack();
        addtoCart.gotoCart();

        //Page Title Verification
        String expectedCartPageTitle = "Your Cart";
        cartPage cartItems = new cartPage(driver);
        String actualCartPageHeader = cartItems.getCartPageHeader();
        Assert.assertEquals(actualCartPageHeader, expectedCartPageTitle);
    }
    
    @Test
    public void removeCartItem(){

        LoginPage userLogin = new LoginPage(driver);
        userLogin.loginAsValidUser();

        InventoryPage addToCartItems = new InventoryPage(driver);
        addToCartItems.addToCartBackPack();
        addToCartItems.gotoCart();

        cartPage addQuantity = new cartPage(driver);
        addQuantity.removeBackPackinCart();

        //Verify if the item already removed after clicking the button
        By cartItemName = By.className("inventory_item_name");
        boolean isDisplayed = itemRemoved(cartItemName);
        Assert.assertFalse(isDisplayed, "Item Removed");
    }

    private boolean itemRemoved(By locator){
        try{
            WebElement cartItem = driver.findElement(locator);
            return cartItem.isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        }
    }

    @Test
    public void goBackShopping(){

        LoginPage userLogin = new LoginPage(driver);
        userLogin.loginAsValidUser();

        InventoryPage addToCart = new InventoryPage(driver);
        addToCart.addToCartBackPack();
        addToCart.gotoCart();

        cartPage cartPage = new cartPage(driver);
        cartPage.goContinueShopping();

        //Verify if the user has successfully returned to inventory page
        assertTrue(addToCart.removeItemBackPackbtn().isDisplayed());
        assertTrue(addToCart.secondaryPageTitleisDisplayed().isDisplayed());
        
    }
    @Test
    public void proceedToCheckOutPage(){

        LoginPage userLogin = new LoginPage(driver);
        userLogin.loginAsValidUser();

        InventoryPage addToCart = new InventoryPage(driver);
        addToCart.addToCartBackPack();
        addToCart.gotoCart();

        cartPage cartPage = new cartPage(driver);
        cartPage.checkOutItem();

        //To verify that the is already on the first part of checkout page
        checkOutFirstStepPage checkOut = new checkOutFirstStepPage(driver);
        assertTrue(checkOut.secondaryPageHeader().isDisplayed());

    }
    @AfterMethod
    public void endCartTest(){
        testSetup.testTearDown();
    }


}
