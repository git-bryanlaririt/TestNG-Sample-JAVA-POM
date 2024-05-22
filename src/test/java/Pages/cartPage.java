package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cartPage {
    private final WebDriver driver;

    public cartPage(WebDriver driver){
        this.driver = driver;
    }
    By checkOutBtn = By.id("checkout");
    By removeItemBackPack = By.id("remove-sauce-labs-backpack");
    By pageTitle = By.className("header_secondary_container");
    By cartQuantity = By.className("cart_quantity");
    By inventoryItemPrice = By.className("inventory_item_price");
    By inventoryItemName = By.className("inventory_item_name");
    By continueShopping = By.id("continue-shopping");

    public void removeBackPackinCart(){
        driver.findElement(removeItemBackPack).click();
    }

    public void goContinueShopping(){
        driver.findElement(continueShopping).click();
    }

    public void checkOutItem(){
        driver.findElement(checkOutBtn).click();
    }

    public String getCartPageHeader() {
        return driver.findElement(pageTitle).getText();
    }

    public By verifyItemisRemoved(){
        return (By) driver.findElement(inventoryItemName);
    }

}
