package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class checkOutCompletePage {
    private final WebDriver driver;

    public checkOutCompletePage(WebDriver driver){
        this.driver = driver;
    }

    By secondaryPageTitle = By.className("title");
    By backToProductsButton = By.id("back-to-products");
    By completedOrderHeader = By.className("complete-header");
    By completedOrderText = By.className("complete-text");

    public WebElement getSecondaryPageTitle(){
        return driver.findElement(secondaryPageTitle);
    }

    public void clickBacktoProductButton(){
        driver.findElement(backToProductsButton).click();;
    }

    public WebElement getCompletedOrderHeader(){
        return driver.findElement(completedOrderHeader);
    }

    public WebElement getCompletedOrderText(){
        return driver.findElement(completedOrderText);
    }
}
