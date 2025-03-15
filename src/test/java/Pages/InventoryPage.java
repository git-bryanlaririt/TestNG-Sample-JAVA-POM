package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class InventoryPage {
    private final WebDriver driver;
    private WebDriverWait wait;

    // Constructor initializes WebDriver and PageFactory
    public InventoryPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // WebElements for the page
    @FindBy(className = "app_logo")
    private WebElement appLogo;

    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    private WebElement shoppingCartLink;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement hamburgerMenu;

    @FindBy(xpath = "//*[@id=\"logout_sidebar_link\"]")
    private WebElement userLogoutLnk;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    private WebElement sauceLabsBackPack;

    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")
    private WebElement sauceLabsBikeLight;

    @FindBy(id = "remove-sauce-labs-bike-light")
    private WebElement removeItemBikeLight;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeItemBackPack;

    @FindBy(id = "shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(className = "title")
    private WebElement secondaryPageHeader;

    // Helper method to wait and click an element
    private void waitForAndClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    // Actions
    public void clickHamburgerMenu() {
        waitForAndClick(hamburgerMenu);
    }

    public void clickLogoutLink() {
        waitForAndClick(userLogoutLnk);
    }

    public void gotoCart() {
        waitForAndClick(shoppingCartLink);
    }

    public void addToCartBackPack() {
        waitForAndClick(sauceLabsBackPack);
    }

    public WebElement removeItemBackPack() {
        return removeItemBackPack;
    }

    public void addToCartBikeLight() {
        waitForAndClick(sauceLabsBikeLight);
    }

    public void removeBikeLightFromCart() {
        waitForAndClick(removeItemBikeLight);
    }

    // Getter for secondary page header (if needed for validation)
    public WebElement getSecondaryPageHeader() {
        return secondaryPageHeader;
    }
}
