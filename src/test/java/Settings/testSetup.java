package Settings;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
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
    // Check if driver is already initialized to avoid redundant instances
        if (driver == null) {
            // Use Selenium Manager to automatically resolve the ChromeDriver path
            WebDriverManager.chromedriver().setup();

            // Create ChromeOptions instance for additional configurations
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");  // Allow cross-origin requests if needed
            options.addArguments("--user-data-dir=" + System.getProperty("java.io.tmpdir") + "/chrome-user-data"); // Disable the use of user data directory or set a unique one 

            // Initialize ChromeDriver with options
            driver = new ChromeDriver(options);

            // Pass the driver instance to the testListeners for reporting/logging
            testListeners.setupDriver(driver);

            // Maximize browser window for consistent viewport during test execution
            driver.manage().window().maximize();

            // Open the target website before tests start
            driver.get("https://www.saucedemo.com/");
    }
    return driver;  // Return the WebDriver instance for use in tests
}
    @AfterTest
    public static void testTearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
