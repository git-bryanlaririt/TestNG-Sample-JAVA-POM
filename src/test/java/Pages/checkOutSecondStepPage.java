package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class checkOutSecondStepPage {
    private final WebDriver driver;

    public checkOutSecondStepPage(WebDriver driver){
        this.driver = driver;
    }

    By secondaryPageTitle = By.className("title");
    By cancelButton = By.id("cancel");
    By finishButton = By.id("finish");

    public WebElement verifySecondaryPageTitle(){
        return driver.findElement(secondaryPageTitle);
    }

    public void clickCancelButton(){
        driver.findElement(cancelButton).click();
    }

    public void clickFinishButton(){
        driver.findElement(finishButton).click();
    }
}
