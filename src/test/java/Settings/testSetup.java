package Settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import Listeners.testListeners;

public class testSetup {

    private static WebDriver driver;

    @BeforeTest
    public static WebDriver driverSetup() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "C://Users//Bryan//OneDrive//Documents//IntelliJ Projects//chromedriver-win32//chromedriver-win32//chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            testListeners.setupDriver(driver);
            driver.manage().window().maximize();
            driver.get("https://www.saucedemo.com/");
        }
        return driver;
    }

    @AfterTest
    public static void testTearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
