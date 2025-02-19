package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import Settings.testSetup;
import Pages.InventoryPage;
import Pages.LoginPage;
import Listeners.testListeners;

@Listeners(testListeners.class)

public class testCaseInventory extends testSetup{

    private WebDriver driver;

    @BeforeMethod
    public void browserDriverSetup(){
        //Test Setup
        driver = testSetup.driverSetup(); // Initialize WebDriver
        testListeners.setupDriver(driver); // Pass WebDriver to the listener
    }
    
    @Test
    public void addtoCartSingleItem(){
        //User login
        LoginPage userLogin = new LoginPage(driver);
        userLogin.loginAsValidUser();

        //Add items to cart
        InventoryPage addItems = new InventoryPage(driver);
        addItems.addToCartBackPack();
    }

    @Test
    public void addtoCartMultipleItem(){
        //User Login
        LoginPage userLogin = new LoginPage(driver);
        userLogin.loginAsValidUser();

        //Add to cart multiple item
        InventoryPage addItems = new InventoryPage(driver);
        addItems.addToCartBackPack();
        addItems.addToCartBikeLight();
    }

    @Test
    public void removeSingleItem() {
        LoginPage userLogin = new LoginPage(driver);
        userLogin.loginAsValidUser();

        InventoryPage removeSingleItem = new InventoryPage(driver);
        removeSingleItem.addToCartBackPack();
        removeSingleItem.setRemoveItemBackPack();
    }

    @Test
    public void removeMultipleItem() {
        LoginPage userLogin = new LoginPage(driver);
        userLogin.loginAsValidUser();

        InventoryPage removeMultiple = new InventoryPage(driver);
        removeMultiple.addToCartBackPack();
        removeMultiple.addToCartBikeLight();
        removeMultiple.removeBikeLightfromCart();
        removeMultiple.setRemoveItemBackPack();
    }

    @AfterMethod
    public void browserTearDown(){
        //End test
        testSetup.testTearDown();
    }
}
