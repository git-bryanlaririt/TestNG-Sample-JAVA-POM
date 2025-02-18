package Settings;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class screenshotSetUp {

    // Generate a unique timestamp for each CI run to organize screenshots by test session
    private static final String RUN_TIMESTAMP = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

    public static void captureTestScreenshot(WebDriver driver, String testName) {
        // Generate a timestamp for the current screenshot
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String screenshotTimestamp = dateFormatter.format(new Date());

        // Convert WebDriver instance to TakesScreenshot for capturing the screen
        TakesScreenshot captureScreenshot = (TakesScreenshot) driver;
        File source = captureScreenshot.getScreenshotAs(OutputType.FILE);

        // Get project root directory dynamically (avoids hardcoded paths)
        String projectPath = System.getProperty("user.dir");

        // Define the directory structure: screenshots/Run_YYYYMMDD_HHMMSS
        String screenshotDir = projectPath + File.separator + "screenshots" + File.separator + "Run_" + RUN_TIMESTAMP;

        // Define the full path for the screenshot file
        String destination = screenshotDir + File.separator + testName + "_" + screenshotTimestamp + ".png";

        // Create the screenshot directory if it doesn't exist
        File directory = new File(screenshotDir);
        if (!directory.exists() && directory.mkdirs()) {
            System.out.println("✅ Screenshots directory created: " + screenshotDir);
        }

        // Save the screenshot in the specified directory
        File fileDestination = new File(destination);
        try {
            FileHandler.copy(source, fileDestination);
            System.out.println("📸 Screenshot Captured: " + fileDestination.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
