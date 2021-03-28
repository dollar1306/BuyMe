import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class GiftScreen {

    private static WebElement element = null;

    public static void selectBusiness (WebDriver driver) {

        element = driver.findElement(By.partialLinkText("מסעדת יאקימונו רוטשילד"));
        element.click();
    }

    public static void EnterAmount(WebDriver driver) {

        element = driver.findElement(By.cssSelector("input[placeholder='הכנס סכום']"));
        element.sendKeys("500");
    }

    public static void pressSubmit(WebDriver driver){
        element = driver.findElement(By.cssSelector("button[gtm='בחירה']"));
        element.click();

    }

}
