import Helper.Constants;
import Helper.DriverSingleton;

import Helper.TakeTheImage;
import Helper.XMLHandler;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.FileAssert.fail;

public class Extras {
    private static WebElement element = null;
    private static WebDriver driver;
    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeClass
    public void runBefore(){

        String cwd = System.getProperty("user.dir");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("Buy-Me-Extras ", "Extras");
        extent.setSystemInfo("Environment", "Production");
        extent.setSystemInfo("Tester", "Alex");
        test.log(Status.INFO, "@Before class");

        boolean driverEstablish = false;
        try {
            driver = DriverSingleton.getDriverInstance();
            driver.get(XMLHandler.getData(Constants.OPEN_URL));   //OPEN_URL
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driverEstablish = true;

        } catch (Exception e) {
            e.printStackTrace();
            fail("Cant connect chromeDriver");
            test.log(Status.FAIL, "Driver Connection Failed! " + e.getMessage());
            driverEstablish = false;

        } finally {
            if (driverEstablish) {
                test.log(Status.PASS, "Driver established successfully");
            }
        }
    }


    @Test
    public void extrasTest_1(){

        element = driver.findElement(Constants.PRESS_REGISTRATION_LINK);
        element.click();

        element = driver.findElement(Constants.SUBMIT_BUTTON);
        element.click();

        //element.getText("li[class='parsley-required']")
        String strToAssert = "כל המתנות מחכות לך! אבל קודם צריך מייל וסיסמה";
        String result = driver.findElement(By.cssSelector("li[class='parsley-required']")).getText();
        try {
            Assert.assertEquals(strToAssert, result);
            System.out.println("Equal");

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("ASSERT_FAIL");

        } finally {
            System.out.println("ASSERT_SUCCESSFUL");

        }
        TakeTheImage.setTest(test);
        TakeTheImage.setDriver(driver);
        TakeTheImage.takeTheImage();
    }
    @Test
    public void extrasTest_2(){
        driver.get("https://buyme.co.il/search?budget=6&category=16&region=11");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,1500)");
        TakeTheImage.setTest(test);
        TakeTheImage.setDriver(driver);
        TakeTheImage.takeTheImage();
    }

    @Test
    public void extrasTest_3(){

        driver.get("https://buyme.co.il/money/1933847?price=500");
        String textColor = driver.findElement(By.cssSelector("div[class='step active ']")).getCssValue("background-color");
        String buttonTextColor = driver.findElement(By.cssSelector("div[class='step active ']")).getCssValue("color");
        System.out.println("Button color: " + textColor);
        System.out.println("Text color " + buttonTextColor);
        String color = driver.findElement(By.xpath("//*[@id=\"ember1098\"]/div/div[2]/div[1]/div[1]")).getCssValue("color");
        System.out.println(color);
    }

}
