package Settings;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.util.UUID;
import org.apache.commons.io.FileUtils;
import java.io.IOException;

public class testSetup {

    private static WebDriver driver;

    @BeforeTest
    public static WebDriver driverSetup() {
        System.out.println("[DEBUG] driverSetup() called");
        if (driver == null) {
            System.out.println("[DEBUG] Initializing WebDriver");
            
            // Setup WebDriverManager to download and setup the ChromeDriver
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            // Generate a unique user-data directory using timestamp
            String uniqueUserDataDir = "/tmp/chrome-user-data-" + UUID.randomUUID().toString();
            File userDataDir = new File(uniqueUserDataDir);
            
            // Clean up previous directories if they exist
            if (userDataDir.exists()) {
                try {
                    System.out.println("[DEBUG] Deleting existing user data directory");
                    FileUtils.deleteDirectory(userDataDir);
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

            System.out.println("[DEBUG] User data directory created at: " + userDataDir.getAbsolutePath());
            
            // Add unique user data dir argument to Chrome options
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--user-data-dir=" + userDataDir.getAbsolutePath());

            // Initialize ChromeDriver with the configured options
            driver = new ChromeDriver(options);
            System.out.println("[DEBUG] WebDriver initialized successfully");

            // Maximize window
            driver.manage().window().maximize();
            System.out.println("[DEBUG] Window maximized");

            // Launch the desired URL
            driver.get("https://www.saucedemo.com/");
            System.out.println("[DEBUG] Navigated to https://www.saucedemo.com/");
        }
        return driver;
    }
    
    @AfterTest
    public static void testTearDown() {
        System.out.println("[DEBUG] testTearDown() called");
        if (driver != null) {
            System.out.println("[DEBUG] Quitting WebDriver");
            driver.quit();
            driver = null;
        }
    }
}
