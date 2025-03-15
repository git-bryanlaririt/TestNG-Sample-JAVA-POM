package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); //initialize page factory
    }
            //Locate login page web elements using page factory @FindBy annotation
            @FindBy(id = "user-name")
            private WebElement usernameField;

            @FindBy(id = "password")
            private WebElement passwordField;

            @FindBy(id = "login-button")
            private WebElement loginButton;

            @FindBy(className = "error-message-container")
            private WebElement lockedUserErrorMessage;

            @FindBy(className = "app_logo")
            private WebElement appHeader;

            //Login page web element interaction methods
            public void inputUsername(String username){
               usernameField.sendKeys(username);
            }

            public void inputPassword(String password){
                passwordField.sendKeys(password);
            }

            public void clickLoginButton(){
                loginButton.click();
            }
           public String getLockUserErrorMsg(){
                return lockedUserErrorMessage.getText();
           }
           public String verifyPageHeader(){
               return appHeader.getText();
           }
           public void loginAsValidUser(){
               inputUsername("standard_user");
                inputPassword("secret_sauce");
                clickLoginButton();
           }
           public void loginAsLockedUser(){
               inputUsername("locked_out_user");
               inputPassword("secret_sauce");
               clickLoginButton();
           }
}
