package Pages;

import Helper.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendGift {
    private static WebElement element = null;

    public static void selectForWho(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(Constants.SELECT_FOR_WHO));//SELECT_FOR_WHO
        driver.findElement(Constants.SELECT_FOR_SOME_ONE).click();//SELECT_FOR_SOME_ONE
    }

    public static void enterName(WebDriver driver){
        element = driver.findElement(Constants.SELECT_FOR_WHO_LINE);
        element.sendKeys(Constants.NAME_RECIPIENT);
    }

    public static void pressEvent(WebDriver driver) {

        element = driver.findElement(Constants.WHAT_A_CELEBRATION);
        element.click();

    }
    public static void selectEvent(WebDriver driver){
        element = driver.findElement(Constants.SELECT_TO_CONGRATULATE);
        element.click();
    }

    public static void cleanAndSendBlessing(WebDriver driver) {
        element = driver.findElement(Constants.SELECT_THE_BLESSING_PLACE);
        element.clear();
        element.sendKeys(Constants.SEND_THE_BLESSING);//SEND_THE_BLESSING

    }

    public static void uploadImage(WebDriver driver) {
        driver.findElement(Constants.SELECT_UPLOAD_IMAGE_PLACE).sendKeys(Constants.SEND_THE_IMAGE);

    }


    public static void pressNext(WebDriver driver){
        element = driver.findElement(Constants.PRESS_NEXT_BUTTON);
        element.click();
    }


    public static void SelectWhen(WebDriver driver) {
        element = driver.findElement(Constants.SELECT_WHEN);
        element.click();

    }

    public static void howToSend(WebDriver driver) {
        element = driver.findElement(Constants.SELECT_HOW_TO_SEND);//SELECT_HOW_TO_SEND
        element.click();

    }


    public static void enterTelephoneFor (WebDriver driver) {
        element = driver.findElement(Constants.SELECT_PHONE_PLACE);
        element.sendKeys(Constants.SEND_PHONE_NUMBER);

    }

    public static void nameFromWho(WebDriver driver){
        element = driver.findElement(Constants.SELECT_FROM_WHO_PLACE);
        element.sendKeys(Constants.SEND_NAME_FROM_WHO);
    }

    public static void enterTelephoneFrom (WebDriver driver) {
        element = driver.findElement(Constants.SELECT_FROM_WHO_PHONE_PLACE);
        element.sendKeys(Constants.SEND_PHONE_FROM_WHO);

    }

    public static void continueToPay(WebDriver driver){
        element = driver.findElement(Constants.CONTINUE_TO_PAY);
        element.click();
    }
}