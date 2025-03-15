package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkOutCompletePage {
    private final WebDriver driver;

    public checkOutCompletePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this); //Initialize page factory annotation
    }
    //Web element locators using page factory @FindBy annotation
    @FindBy (className = "title")
    private WebElement secondaryPageTitle;

    @FindBy (id = "back-to-products")
    private WebElement backToProductsButton;

    @FindBy (className = "complete-header")
    private WebElement completedOrderHeader;

    @FindBy (className = "complete-text")
    private WebElement completedOrderText;

    public WebElement getSecondaryPageTitle(){
        return secondaryPageTitle;
    }

    public void clickBacktoProductButton(){
        backToProductsButton.click();
    }

    public WebElement getCompletedOrderHeader(){
        return completedOrderHeader;
    }

    public WebElement getCompletedOrderText(){
        return completedOrderText;
    }
}
