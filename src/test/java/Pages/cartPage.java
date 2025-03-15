package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;


public class cartPage {
    private final WebDriver driver;
    private WebDriverWait wait;

    public cartPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // 10 seconds explicit wait
        PageFactory.initElements(driver, this); //Initialize page factory
    }
    //Locate cart page web elements using page factory @FindBy annotation
    @FindBy (id = "checkout")
    private WebElement checkOutButton;

    @FindBy (id = "remove-sauce-labs-backpack")
    private WebElement removeItemBackPackButton;

    @FindBy (className = "header_secondary_container")
    private WebElement secondaryHeaderContainer;

    @FindBy (className = "cart_quantity")
    private WebElement cartQuantity;

    @FindBy (className = "inventory_item_price")
    private WebElement inventoryItemPrice;

    @FindBy (className = "inventory_item_name")
    private WebElement inventoryItemName;

    @FindBy (id = "continue-shopping")
    private WebElement continueShopping;

    public void removeBackPackinCart(){
        removeItemBackPackButton.click();
    }

    public void goContinueShopping(){
        continueShopping.click();
    }

    public void checkOutItem(){
       checkOutButton.click();
    }

    public String getCartPageHeader() {
        WebElement cartPageHeader = wait.until(ExpectedConditions.visibilityOf(secondaryHeaderContainer));
        return secondaryHeaderContainer.getText();
    }

    public String verifyItemisRemoved(){
        return inventoryItemName.getText();
    }

}
