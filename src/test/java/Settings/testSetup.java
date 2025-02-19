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
import java.util.UUID;
import org.apache.commons.io.FileUtils;
import java.io.IOException;

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
            // Clean up any existing user data directory before setting up the new one
            String uniqueUserDataDir = System.getProperty("java.io.tmpdir") + "/chrome-user-data-" + UUID.randomUUID();
            File userDataDir = new File(uniqueUserDataDir);
            
            // Clean up previous directories if they exist
            if (userDataDir.exists()) {
                try {
                    FileUtils.deleteDirectory(userDataDir);  // Use FileUtils from Apache Commons IO
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
            // Create new directory for the test
            if (!userDataDir.exists()) {
                boolean created = userDataDir.mkdirs();
                if (!created) {
                    throw new RuntimeException("Failed to create user data directory at: " + userDataDir.getAbsolutePath());
                }
            }

            // Add unique user data dir argument to Chrome options
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--headless=new");  // Use new headless mode for stability
            options.addArguments("--no-sandbox");   // Required for running as root in CI
            options.addArguments("--disable-dev-shm-usage"); // Helps with shared memory issues in Docker
            // options.addArguments("--user-data-dir=" + userDataDir.getAbsolutePath()); 

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
