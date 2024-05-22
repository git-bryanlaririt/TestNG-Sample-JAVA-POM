package Listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import Settings.screenshotSetUp;

public class testListeners implements ITestListener {

    private static WebDriver driver;

    public static void setupDriver(WebDriver webDriver){
        driver = webDriver;
    }

    @Override
    public void onTestSuccess(ITestResult result){
        screenshotSetUp.captureTestScreenshot(driver, result.getTestName());
    }

    @Override
    public void onTestFailure(ITestResult result){
        screenshotSetUp.captureTestScreenshot(driver, result.getTestName());
    }

    @Override
    public void onTestSkipped(ITestResult result){
        screenshotSetUp.captureTestScreenshot(driver, result.getTestName());
    }

}
