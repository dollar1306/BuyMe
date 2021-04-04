package Pages;

import Helper.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Registration {
    private static WebElement element = null;

    public static void openLink (WebDriver driver){
        element=driver.findElement(Constants.PRESS_REGISTRATION_LINK);
        element.click();

    }

    public static void enterName (WebDriver driver){
        element = driver.findElement(Constants.ENTER_NAME);
        element.sendKeys(Constants.NAME);//Name
    }

    public static void enterEmail (WebDriver driver){
        element = driver.findElement(Constants.ENTER_EMAIL);
        element.sendKeys(Constants.EMAIL_FOR_SEND);//Email
    }

    public static void enterPassword (WebDriver driver){
        element = driver.findElement(Constants.ENTER_PASSWORD);
        element.sendKeys(Constants.PASSWORD);//Password
    }

    public static void enterPasswordAgain (WebDriver driver){
        element = driver.findElement(Constants.ENTER_PASSWORD_AGAIN);
        element.sendKeys(Constants.PASSWORD);//Password Authentication
    }

    public static void registrationButton (WebDriver driver){
        element = driver.findElement(Constants.REGISTRATION_BUTTON);
        element.click();
    }

    public static void pressSubmit (WebDriver driver){
        element = driver.findElement(Constants.SUBMIT_BUTTON);
        element.click();
    }

}
