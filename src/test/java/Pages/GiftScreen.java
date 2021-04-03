package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class GiftScreen {

    private static WebElement element = null;

    public static void selectBusiness (WebDriver driver) {

        element = driver.findElement(By.partialLinkText("מסעדת יאקימונו רוטשילד"));
        element.click();
    }

    public static void EnterAmount(WebDriver driver) {

        element=driver.findElement(By.cssSelector("input[data-parsley-type='number']"));
        element.sendKeys("500");
    }

    public static void pressSubmit(WebDriver driver){
        element = driver.findElement(By.cssSelector("div>button[type='submit']:nth-child(1)"));
        element.click();

    }

}
