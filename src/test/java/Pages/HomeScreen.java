package Pages;

import Helper.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomeScreen {
    private static WebElement element = null;

    public static void pressPrice (WebDriver driver) {

        element=driver.findElement(Constants.PRESS_ON_PRICE);
        element.click();

    }

    public static void selectPrice(WebDriver driver){
        element = driver.findElement(Constants.SELECT_PRICE);
        element.click();
    }

    public static void pressArea(WebDriver driver){
        element=driver.findElement(Constants.PRESS_AREA);
        element.click();

    }

    public static void selectArea(WebDriver driver){
        element = driver.findElement(Constants.SELECT_AREA);
        element.click();
    }

    public static void pressType(WebDriver driver) {
        element=driver.findElement(Constants.PRESS_TYPE);
        element.click();

    }

    public static void selectType(WebDriver driver){
        element = driver.findElement(Constants.SELECT_TYPE);
        element.click();
    }

    public static void pressSubmit(WebDriver driver){
        element=driver.findElement(Constants.PRESS_NEXT);
        element.click();
    }
}
