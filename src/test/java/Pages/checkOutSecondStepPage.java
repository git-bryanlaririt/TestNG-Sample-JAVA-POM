package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkOutSecondStepPage {
    private final WebDriver driver;

    public checkOutSecondStepPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this); //Initialize page factory annotation
    }
    //Locate web elements using page factory @FindBy annotation
    @FindBy (className = "title")
    private WebElement secondaryPageTitle;

    @FindBy (id = "cancel")
    private WebElement cancelButton;

    @FindBy (id = "finish")
    private WebElement finishButton;

    public WebElement verifySecondaryPageTitle(){
        return secondaryPageTitle;
    }

    public void clickCancelButton(){
        cancelButton.click();
    }

    public void clickFinishButton(){
        finishButton.click();
    }
}
