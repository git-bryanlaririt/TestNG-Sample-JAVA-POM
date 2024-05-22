package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryPage {
    private final WebDriver driver;

    public InventoryPage (WebDriver driver){
        this.driver = driver;
    }

    By appLogo = By.className("app_logo");
    By shoppingCartLink = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    By hamburgerMenu = By.id("react-burger-menu-btn");
    By userLogoutLnk = By.xpath("//*[@id=\"logout_sidebar_link\"]");
    By sauceLabsBackPack = By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");
    By sauceLabsBikeLight = By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]");
    By removeItemBikeLight = By.id("remove-sauce-labs-bike-light");
    By removeItemBackPack = By.id("remove-sauce-labs-backpack");
    By cartBadge = By.id("shopping_cart_badge");
    By secondaryPageHeader = By.className("title");

    public void ClickHamburgerMenu(){
        driver.findElement(hamburgerMenu).click();
    }

    public void ClickLogoutLink(){
        WebDriverWait waitElement = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clickLogoutLink = waitElement.until(ExpectedConditions.presenceOfElementLocated(userLogoutLnk));
        clickLogoutLink.findElement(userLogoutLnk).click();
    }

    public void gotoCart(){
        WebDriverWait clickCartIcon = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cartLink = clickCartIcon.until(ExpectedConditions.presenceOfElementLocated(shoppingCartLink));
        cartLink.findElement(shoppingCartLink).click();
    }

    public void addToCartBackPack(){
        WebDriverWait backPackAddBtn = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement backPackBtn = backPackAddBtn.until(ExpectedConditions.presenceOfElementLocated(sauceLabsBackPack));
        backPackBtn.findElement(sauceLabsBackPack).click();
    }

    public void setRemoveItemBackPack(){
        driver.findElement(removeItemBackPack).click();
    }

    public WebElement removeItemBackPackbtn(){
        return driver.findElement(removeItemBackPack);
    }

    public void addToCartBikeLight(){
        WebDriverWait waitbikeLightBtn = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement bikeLightBtn = waitbikeLightBtn.until(ExpectedConditions.presenceOfElementLocated(sauceLabsBikeLight));
        bikeLightBtn.findElement(sauceLabsBikeLight).click();
    }

    public void removeBikeLightfromCart(){
        driver.findElement(removeItemBikeLight).click();
    }

    public WebElement secondaryPageTitleisDisplayed(){
        return driver.findElement(secondaryPageHeader);
    }
}
