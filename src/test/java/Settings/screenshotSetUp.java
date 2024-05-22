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

    private static final String PROJECT_PATH = "C:/Users/Bryan/OneDrive/Documents/IntelliJ Projects/Selenium-TestNG-Sample-Project";

    public static void captureTestScreenshot(WebDriver driver, String testName){

        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date date = new Date();
        String dateToStr = dateFormatter.format(date);

        TakesScreenshot captureScreenshot = (TakesScreenshot) driver;

        File source = captureScreenshot.getScreenshotAs(OutputType.FILE);

        //String userDir = System.getProperty("user.dir");
        String screenshotDir = PROJECT_PATH + "/screenshots";
        String destination = screenshotDir + "/" + testName + "_" +dateToStr + ".png";

        File directory = new File(screenshotDir);

        if(!directory.exists()){
            boolean folderCreated = directory.mkdirs();
                if(folderCreated){
                    System.out.println("Screenshots directory created at " + destination);
                }else {
                    System.out.println("Folder creation failed");
                    return;
                }
        }else{
            System.out.println("Directory Exist");
        }

        File fileDestination = new File(destination);

            try{
                FileHandler.copy(source, fileDestination);
                System.out.println("Screenshot Captured" + fileDestination);
            } catch (IOException e){
                e.printStackTrace();
            }

    }

}
