import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.rules.TestName;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.FileAssert.fail;

public class Run {
    private static WebDriver driver;
    private static ExtentReports extent;
    private static ExtentTest test;
    public TestName name = new TestName();
    private static WebElement element = null;

    @BeforeClass
    public void runBefore(){

        String cwd = System.getProperty("user.dir");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\extent.html");
        // attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // name your test and add description
        test = extent.createTest("MyFirstTestProject", "Sample description");
        // add custom system info
        extent.setSystemInfo("Environment", "Production");
        extent.setSystemInfo("Tester", "Alex");
        // log results
        test.log(Status.INFO, "@Before class");

        boolean driverEstablish = false;
        try {
            driver = DriverSingleton.getDriverInstance();
            driver.get("https://buyme.co.il/");
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

    private static String getData (String keyName) throws IOException, SAXException, ParserConfigurationException {
        File configXmlFile = new File("C:\\Users\\Alex\\IdeaProjects\\BuyMe\\src\\main\\resources\\data.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(configXmlFile);

        if (doc != null) {
            doc.getDocumentElement().normalize();
        }
        assert doc != null;
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }

    @Test
    public void testOpen(){
        boolean pageOpened = false;
        try {
            driver.navigate().to(getData("browserType"));
            String firstWindowString = driver.getWindowHandle();
            System.out.println("Window String: " + firstWindowString);
            pageOpened = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.
                    createScreenCaptureFromPath(takeScreenShot(timeNow)).build());

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "buy-me page was not found " + e.getMessage());
            pageOpened = false;

        } finally {
            if (pageOpened) {
                test.log(Status.PASS, "Open webpage " + "Webpage opened successfully");
            }
        }
        test.pass("Registration page with credentials",
                MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot
                        ("\\.png"
                                + name.getMethodName())).build());
    }

    @Test
    public void clickLink(){
        boolean openLink = false;
        try {
            Registration.openLink(driver);
            openLink = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.
                    createScreenCaptureFromPath(takeScreenShot(timeNow)).build());

        } catch (Exception e) {

            e.printStackTrace();
            test.log(Status.FAIL, "Entrance/LogIn page was not found" + e.getMessage());
            openLink = false;

        } finally {
            if (openLink) {
                test.log(Status.PASS, "Entrance/LogIn page opened successfully");

            }
        }
        test.pass("Registration page with credentials",
                MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot
                        ("\\.png"
                                + name.getMethodName())).build());
    }

    @Test
    public void testSignIn(){
        boolean signIn = false;
        try {

            Registration.enterEmail(driver);
            Registration.enterPassword(driver);
            Registration.pressSubmit(driver);
            signIn = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.
                    createScreenCaptureFromPath(takeScreenShot(timeNow)).build());

        } catch (Exception e) {

            e.printStackTrace();
            test.log(Status.FAIL, "SignIn page was not found" + e.getMessage());
            signIn = false;
        } finally {
            if (signIn) {
                test.log(Status.PASS, "SignIn page opened successfully");

            }
        }
        test.pass("Registration page with credentials",
                MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot
                        ("\\.png"
                                + name.getMethodName())).build());
    }


    @Test
    public void testRegistration(){
        boolean registration = false;
        try{
            Registration.enterName(driver);
            Registration.enterEmail(driver);
            Registration.enterPassword(driver);
            Registration.enterPasswordAgain(driver);
            Registration.registrationButton(driver);
            registration = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.
                    createScreenCaptureFromPath(takeScreenShot(timeNow)).build());

        } catch (Exception e) {

            e.printStackTrace();
            test.log(Status.FAIL, "Registration fail" + e.getMessage());
            registration = false;
        } finally {
            if (registration) {
                test.log(Status.PASS, "Registration pass");
            }
        }

        test.pass("Registration page with credentials",
                MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot
                        ("\\.png"
                                + name.getMethodName())).build());
    }



    @Test
    public void testHomeScreen(){
        boolean homeScreen = false;
        try {
            HomeScreen.pressPrice(driver);
            HomeScreen.selectPrice(driver);
            HomeScreen.pressArea(driver);
            HomeScreen.selectArea(driver);
            HomeScreen.pressType(driver);
            HomeScreen.selectType(driver);
            HomeScreen.pressSubmit(driver);
            homeScreen = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.
                    createScreenCaptureFromPath(takeScreenShot(timeNow)).build());

        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL , "Home screen drop down fail"+e.getMessage());
            homeScreen = false;
        }finally {
            if(homeScreen){
                test.log(Status.PASS , "Home screen drop down successful");
            }
        }
        test.pass("Registration page with credentials",
                MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot
                        ("\\.png"
                                + name.getMethodName())).build());
    }


    @Test
    public void testAssertUrl(){
        boolean assertURL = false;
        driver.get("https://buyme.co.il/search?budget=6&category=16&region=11");
        try {
            Assert.assertEquals("https://buyme.co.il/search?budget=6&category=16&region=11",
                    driver.getCurrentUrl());
            assertURL = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.
                    createScreenCaptureFromPath(takeScreenShot(timeNow)).build());

        } catch (Exception e) {

            e.printStackTrace();
            test.log(Status.WARNING, "ASSERT_FAIL" + e.getMessage());
            assertURL = false;
        } finally {
            if (assertURL) {
                test.log(Status.PASS, "ASSERT_SUCCESSFUL");

            }
        }
        test.pass("Registration page with credentials",
                MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot
                        ("\\.png"
                                + name.getMethodName())).build());
    }


    @Test
    public void testSelectBusiness(){
        driver.get("https://buyme.co.il/search?budget=6&category=16&region=11");
        boolean selectBusiness = false;
        try {
            GiftScreen.selectBusiness(driver);
            selectBusiness = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.
                    createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
        } catch (Exception e) {

            e.printStackTrace();
            test.log(Status.FAIL, "SELECT_BUSINESS_FAIL" + e.getMessage());
            selectBusiness = false;

        } finally {
            if (selectBusiness) {
                test.log(Status.PASS, "SELECT_BUSINESS_SUCCESSFUL");

            }
        }
        test.pass("Registration page with credentials",
                MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot
                        ("\\.png"
                                + name.getMethodName())).build());
    }

    @Test
    public void testEnterAmountAndSend(){

        boolean sendAmount = false;
        try {
            driver.get("https://buyme.co.il/supplier/1933847?budget=6&category=16&query=&region=11");
            GiftScreen.EnterAmount(driver);
            sendAmount = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.
                    createScreenCaptureFromPath(takeScreenShot(timeNow)).build());

        } catch (Exception e) {

            e.printStackTrace();
            test.log(Status.FAIL, "SEND_AMOUNT_FAIL" + e.getMessage());
            sendAmount = false;
        } finally {
            if (sendAmount) {
                test.log(Status.PASS, "SEND_AMOUNT_SUCCESSFUL");

            }
        }
        test.pass("Registration page with credentials",
                MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot
                        ("\\.png"
                                + name.getMethodName())).build());

        boolean pressSubmit = false;
        try{
            GiftScreen.pressSubmit(driver);
            pressSubmit = true;
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.info("details", MediaEntityBuilder.
                    createScreenCaptureFromPath(takeScreenShot(timeNow)).build());

        }catch (Exception e){

            e.printStackTrace();
            test.log(Status.FAIL, "PRESS_SUBMIT_FAIL" + e.getMessage());
            pressSubmit = false;
        }finally {
            if (pressSubmit) {
                test.log(Status.PASS, "PRESS_SUBMIT_SUCCESSFUL");

            }
        }
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        test.pass("Registration page with credentials",
                MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot
                        ("\\.png"
                                + name.getMethodName())).build());

    }


//    @Test
//    public void testPressSubmit(){
//
//    }




    @AfterClass
    public static void close () {
        test.log(Status.INFO, "@After test " + "After test methods");
        //driver.quit();
        extent.flush();
    }

    private static String takeScreenShot (String ImagesPath){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath +".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath + ".png";
    }
}
