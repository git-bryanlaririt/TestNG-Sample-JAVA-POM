package Settings;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import Listeners.testListeners;

public class testSetup {

    private static WebDriver driver;

    @BeforeTest
    public static WebDriver driverSetup() {
    if (driver == null) {
            // Setup WebDriverManager to download and setup the ChromeDriver
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            // Generate a unique user-data directory using timestamp
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String timestamp = dateFormatter.format(new Date());
            
            // Create a temporary directory for user data in the system's temp directory
            String uniqueUserDataDir = System.getProperty("java.io.tmpdir") + "chrome-user-data-" + timestamp;
            File userDataDir = new File(uniqueUserDataDir);
            if (!userDataDir.exists()) {
                userDataDir.mkdirs(); // Create the directory if it doesn't exist
            }

            // Add unique user data dir argument to Chrome options
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--user-data-dir=" + userDataDir.getAbsolutePath());

            // Initialize ChromeDriver with the configured options
            driver = new ChromeDriver(options);

            // Maximize window
            driver.manage().window().maximize();

            // Launch the desired URL
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
