package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class checkOutFirstStepPage {
    WebDriver driver;

    public checkOutFirstStepPage(WebDriver driver){
        this.driver = driver;
    }

    By checkoutSecondaryPageHeader = By.className("title");
    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By postalCodeField = By.id("postal-code");
    By continueButton = By.id("continue");
    By cancelButton = By.id("cancel");

    public void fillOutFirstName(){
        driver.findElement(firstNameField).sendKeys("Test First Name");
    }

    public void fillOutLastName(){
        driver.findElement(lastNameField).sendKeys("Test Last Name");
    }

    public void fillOutPostalCode(){
        driver.findElement(postalCodeField).sendKeys("1234");
    }

    public WebElement secondaryPageHeader(){
        return driver.findElement(checkoutSecondaryPageHeader);
    }

    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }

    public void clickCancelButton(){
        driver.findElement(cancelButton).click();
    }

}
