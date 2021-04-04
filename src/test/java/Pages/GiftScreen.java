package Pages;

import Helper.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class GiftScreen {

    private static WebElement element = null;

    public static void selectBusiness (WebDriver driver) {

        element = driver.findElement(Constants.SELECT_BUSINESS);//SELECT_BUSINESS
        element.click();
    }

    public static void EnterAmount(WebDriver driver) {

        element=driver.findElement(Constants.ENTER_AMOUNT_FOR_PRESENT);//ENTER_AMOUNT_FOR_PRESENT
        element.sendKeys(Constants.AMOUNT);//Amount
    }

    public static void pressSubmit(WebDriver driver){
        element = driver.findElement(Constants.PRESS_SUBMIT);//PRESS_SUBMIT
        element.click();

    }

}
