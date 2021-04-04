import Helper.Constants;
import Helper.DriverSingleton;
import Helper.TakeTheImage;
import Helper.XMLHandler;
import Pages.GiftScreen;
import Pages.HomeScreen;
import Pages.Registration;
import Pages.SendGift;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.junit.Assert;

import org.openqa.selenium.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;
import static org.testng.FileAssert.fail;


public class Run {
    private static WebDriver driver;
    private static ExtentReports extent;
    private static ExtentTest test;


    @BeforeClass
    public void runBefore(){

        String cwd = System.getProperty("user.dir");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("Buy-Me ", "Second Project");
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
    public void testOpen(){
        boolean pageOpened = false;
        try {
            driver.navigate().to(XMLHandler.getData("browserType"));
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            pageOpened = true;

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "buy-me page was not found " + e.getMessage());
            pageOpened = false;

        } finally {
            if (pageOpened) {
                test.log(Status.PASS, "Open webpage " + "Webpage opened successfully");
            }
        }
        TakeTheImage.setTest(test);
        TakeTheImage.setDriver(driver);
        TakeTheImage.takeTheImage();
    }



    @Test
    public void clickLink(){
        boolean openLink = false;
        try {
            Registration.openLink(driver);
            openLink = true;
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        } catch (Exception e) {

            e.printStackTrace();
            test.log(Status.FAIL, "Entrance/LogIn page was not found" + e.getMessage());
            openLink = false;

        } finally {
            if (openLink) {
                test.log(Status.PASS, "Entrance/LogIn page opened successfully");

            }
        }
        TakeTheImage.setTest(test);
        TakeTheImage.setDriver(driver);
        TakeTheImage.takeTheImage();
    }



    @Test
    public void testSignIn(){
        boolean signIn = false;
        try {
            driver.get("https://buyme.co.il/?modal=login");
            Registration.enterEmail(driver);
            Registration.enterPassword(driver);
            Registration.pressSubmit(driver);
            signIn = true;
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        } catch (Exception e) {

            e.printStackTrace();
            test.log(Status.FAIL, "SignIn page was not found" + e.getMessage());
            signIn = false;

        } finally {
            if (signIn) {
                test.log(Status.PASS, "SignIn page opened successfully");

            }
        }
        TakeTheImage.setTest(test);
        TakeTheImage.setDriver(driver);
        TakeTheImage.takeTheImage();
    }


    @Test
    public void testRegistration(){
        boolean registration = false;
        try{
            driver.get("https://buyme.co.il/?modal=login");//url for registration
            Registration.enterName(driver);
            Registration.enterEmail(driver);
            Registration.enterPassword(driver);
            Registration.enterPasswordAgain(driver);
            Registration.registrationButton(driver);
            registration = true;
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        } catch (Exception e) {

            e.printStackTrace();
            test.log(Status.FAIL, "Pages.Registration fail" + e.getMessage());
            registration = false;

        } finally {
            if (registration) {
                test.log(Status.PASS, "Pages.Registration pass");
            }
        }
        TakeTheImage.setTest(test);
        TakeTheImage.setDriver(driver);
        TakeTheImage.takeTheImage();
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
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL , "Home screen drop down fail"+e.getMessage());
            homeScreen = false;
        }finally {
            if(homeScreen){
                test.log(Status.PASS , "Home screen drop down successful");
            }
        }
        TakeTheImage.setTest(test);
        TakeTheImage.setDriver(driver);
        TakeTheImage.takeTheImage();
    }


    @Test
    public void testAssertUrl(){
        boolean assertURL = false;
        driver.get("https://buyme.co.il/search?budget=6&category=16&region=11");//URL_FOR_ASSERT
        try {
            Assert.assertEquals("https://buyme.co.il/search?budget=6&category=16&region=11",//EXPECTED_URL
                    driver.getCurrentUrl());
            assertURL = true;

        } catch (Exception e) {

            e.printStackTrace();
            test.log(Status.WARNING, "ASSERT_FAIL" + e.getMessage());
            assertURL = false;
        } finally {
            if (assertURL) {
                test.log(Status.PASS, "ASSERT_SUCCESSFUL");

            }
        }
        TakeTheImage.setTest(test);
        TakeTheImage.setDriver(driver);
        TakeTheImage.takeTheImage();
    }


    @Test
    public void testSelectBusiness(){
        driver.get("https://buyme.co.il/search?budget=6&category=16&region=11");//SELECT_BUSINESS_URL
        boolean selectBusiness = false;
        try {
            GiftScreen.selectBusiness(driver);
            selectBusiness = true;
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        } catch (Exception e) {

            e.printStackTrace();
            test.log(Status.FAIL, "SELECT_BUSINESS_FAIL" + e.getMessage());
            selectBusiness = false;

        } finally {
            if (selectBusiness) {
                test.log(Status.PASS, "SELECT_BUSINESS_SUCCESSFUL");

            }
        }
        TakeTheImage.setTest(test);
        TakeTheImage.setDriver(driver);
        TakeTheImage.takeTheImage();
    }

    @Test
    public void testEnterAmount(){

        boolean sendAmount = false;
        try {
            driver.get("https://buyme.co.il/supplier/1933847?budget=6&category=16&query=&region=11");//SEND_AMOUNT_URL
            GiftScreen.EnterAmount(driver);
            sendAmount = true;
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        } catch (Exception e) {

            e.printStackTrace();
            test.log(Status.FAIL, "SEND_AMOUNT_FAIL" + e.getMessage());
            sendAmount = false;
        } finally {
            if (sendAmount) {
                test.log(Status.PASS, "SEND_AMOUNT_SUCCESSFUL");

            }
        }
        TakeTheImage.setTest(test);
        TakeTheImage.setDriver(driver);
        TakeTheImage.takeTheImage();
    }


    @Test
    public void testPressSubmit(){
        boolean pressSubmit = false;
        try{
            driver.get("https://buyme.co.il/supplier/1933847?budget=6&category=16&query=&region=11");//PRESS_SUBMIT_URL
            GiftScreen.pressSubmit(driver);
            pressSubmit = true;
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        }catch (Exception e){

            e.printStackTrace();
            test.log(Status.FAIL, "PRESS_SUBMIT_FAIL" + e.getMessage());
            pressSubmit = false;
        }finally {
            if (pressSubmit) {
                test.log(Status.PASS, "PRESS_SUBMIT_SUCCESSFUL");

            }
        }
        TakeTheImage.setTest(test);
        TakeTheImage.setDriver(driver);
        TakeTheImage.takeTheImage();

    }


    @Test
    public void testSendGift(){
        boolean selectForWho = false;
        try{
            driver.get("https://buyme.co.il/money/1933847?price=500");//SEND_GIFT_URL
            SendGift.selectForWho(driver);
            selectForWho = true;
//            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL, "SELECT_FOR_WHO_FAIL" + e.getMessage());
            selectForWho = false;
        }finally {
            if(selectForWho){
                test.log(Status.PASS, "SELECT_FOR_WHO_SUCCESSFUL");
            }
        }
        boolean enterName = false;
        try{
            SendGift.enterName(driver);
            enterName = true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL, "ENTER_NAME_FAIL" + e.getMessage());
            enterName = false;
        }finally {
            if(enterName){
                test.log(Status.PASS, "ENTER_NAME_SUCCESSFUL");
            }
        }
        boolean pressEvent = false;
        try{
            SendGift.pressEvent(driver);
            pressEvent = true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL, "PRESS_EVENT_FAIL" + e.getMessage());
            pressEvent = false;
        }finally {
            if(pressEvent){
                test.log(Status.PASS, "PRESS_EVENT_SUCCESSFUL");
            }
        }
        boolean selectEvent = false;
        try{
            SendGift.selectEvent(driver);
            selectEvent = true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL, "SELECT_EVENT_FAIL" + e.getMessage());
            selectEvent = false;
        }finally {
            if(selectEvent){
                test.log(Status.PASS, "SELECT_EVENT_SUCCESSFUL");
            }
        }
        boolean cleanAndSendBlessing = false;
        try{
            SendGift.cleanAndSendBlessing(driver);
            cleanAndSendBlessing = true;
        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL, "CLEAN_&_SEND_FAIL" + e.getMessage());
            cleanAndSendBlessing = false;
        }finally {
            if(cleanAndSendBlessing){
                test.log(Status.PASS, "CLEAN_&_SEND_SUCCESSFUL");
            }
        }
        boolean uploadImage = false;
        try{
            SendGift.uploadImage(driver);
            uploadImage = true;

        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL, "SELECT_EVENT_FAIL" + e.getMessage());
            uploadImage = false;

        }finally {
            if(uploadImage){
                test.log(Status.PASS, "SELECT_EVENT_SUCCESSFUL");
            }
        }
        boolean pressNext = false;
        try{
            SendGift.pressNext(driver);
            pressNext = true;

        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL, "PRESS_NEXT_FAIL" + e.getMessage());
            pressNext = false;

        }finally {
            if(pressNext){
                test.log(Status.PASS, "PRESS_NEXT_SUCCESSFUL");
            }
        }

        boolean SelectWhen = false;
        try{
            SendGift.SelectWhen(driver);
            SelectWhen = true;

        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL, "SELECT_WHEN_FAIL" + e.getMessage());
            SelectWhen = false;

        }finally {
            if(SelectWhen){
                test.log(Status.PASS, "SELECT_WHEN_SUCCESSFUL");
            }
        }
        boolean howToSend = false;
        try{
            SendGift.howToSend(driver);
            howToSend = true;

        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL, "HOW_TO_SEND_FAIL" + e.getMessage());
            howToSend = false;

        }finally {
            if(howToSend){
                test.log(Status.PASS, "HOW_TO_SEND_SUCCESSFUL");
            }
        }
        boolean enterTelephoneFor = false;
        try{
            SendGift.enterTelephoneFor(driver);
            enterTelephoneFor = true;

        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL, "ENTER_TELEPHONE_FAIL" + e.getMessage());
            enterTelephoneFor = false;

        }finally {
            if(enterTelephoneFor){
                test.log(Status.PASS, "ENTER_TELEPHONE_SUCCESSFUL");
            }
        }
        boolean nameFromHow = false;
        try{
            SendGift.nameFromWho(driver);
            nameFromHow = true;

        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL, "ENTER_TELEPHONE_FAIL" + e.getMessage());
            nameFromHow = false;

        }finally {
            if(nameFromHow){
                test.log(Status.PASS, "ENTER_TELEPHONE_SUCCESSFUL");
            }
        }
        boolean enterTelephoneFrom = false;
        try{
            SendGift.enterTelephoneFrom(driver);
            enterTelephoneFrom = true;

        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL, "ENTER_TELEPHONE_FAIL" + e.getMessage());
            enterTelephoneFrom = false;

        }finally {
            if(enterTelephoneFrom){
                test.log(Status.PASS, "ENTER_TELEPHONE_SUCCESSFUL");
            }
        }

        boolean continueToPay = false;
        try{
            SendGift.continueToPay(driver);
            Registration.enterEmail(driver);
            Registration.enterPassword(driver);
            Registration.pressSubmit(driver);
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            continueToPay = true;

        }catch (Exception e){
            e.printStackTrace();
            test.log(Status.FAIL, "ENTER_TELEPHONE_FAIL" + e.getMessage());
            continueToPay = false;

        }finally {
            if(continueToPay){
                test.log(Status.PASS, "ENTER_TELEPHONE_SUCCESSFUL");
            }
        }
        TakeTheImage.setTest(test);
        TakeTheImage.setDriver(driver);
        TakeTheImage.takeTheImage();
    }

    @AfterClass
    public static void close () {
        TakeTheImage.setTest(test);
        TakeTheImage.setDriver(driver);
        TakeTheImage.takeTheImage();
        test.log(Status.INFO, "@After test " + "After test methods");
        //driver.quit();
        extent.flush();
    }
}
