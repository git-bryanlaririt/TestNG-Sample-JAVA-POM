package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage{

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
            private final By UserName = By.id("user-name");
            private final By Password = By.id("password");
            private final By LoginBtn = By.id("login-button");
            private final By LockUserErrorMsg = By.className("error-message-container");
            private final By inventoryPageHeader = By.className("app_logo");

            public void enterUsername(String username){
                driver.findElement(UserName).sendKeys(username);
            }

            public void enterPassword(String password){
                driver.findElement(Password).sendKeys(password);
            }

            public void ClickBTN(){
                driver.findElement(LoginBtn).click();
            }
           public String GetLockUserErrorMsg(){
                return driver.findElement(LockUserErrorMsg).getText();
           }
           public String verifyPageHeader(){
               return driver.findElement(inventoryPageHeader).getText();
           }
           public void loginAsValidUser(){
                enterUsername("standard_user");
                enterPassword("secret_sauce");
                ClickBTN();
           }
           public void loginAsLockedUser(){
               enterUsername("locked_out_user");
               enterPassword("secret_sauce");
               ClickBTN();
           }
}
