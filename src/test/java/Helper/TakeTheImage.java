package Helper;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TakeTheImage {
    private static ExtentTest test;
    public static TestName name = new TestName();
    private static WebDriver driver;

    static String takeScreenShot(String ImagesPath){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath +".jpg");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath + ".jpg";
    }

    public static void takeTheImage() {
        String timeNow = String.valueOf(System.currentTimeMillis());
        test.info("details", MediaEntityBuilder.createScreenCaptureFromPath(
                takeScreenShot("files/ScreenShot" + timeNow)).build());
        test.pass("Pages.Registration page with credentials",
                MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot
                        ("\\.jpg"
                                + name.getMethodName())).build());
    }

    public static void setDriver(WebDriver driver) {
        TakeTheImage.driver = driver;
    }

    public static void setTest(ExtentTest test) {
        TakeTheImage.test = test;
    }
}
