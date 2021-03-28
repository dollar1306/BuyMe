import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomeScreen {
    private static WebElement element = null;

    public static void pressPrice (WebDriver driver) {

        element=driver.findElement(By.partialLinkText("סכום"));//click for link text
        element.click();

    }

    public static void selectPrice(WebDriver driver){
        element = driver.findElement(By.xpath("//li[@data-option-array-index='5']"));//choose price
        element.click();
    }

    public static void pressArea(WebDriver driver){
        element=driver.findElement(By.partialLinkText("אזור"));//press place
        element.click();

    }

    public static void selectArea(WebDriver driver){
        element = driver.findElement(By.xpath("//li[@data-option-array-index='1']"));//choose place
        element.click();
    }

    public static void pressType(WebDriver driver) {
        element=driver.findElement(By.partialLinkText("קטגוריה"));//press type
        element.click();

    }

    public static void selectType(WebDriver driver){
        element = driver.findElement(By.xpath("//li[@data-option-array-index='2']"));//choose type
        element.click();
    }

    public static void pressSubmit(WebDriver driver){
        element=driver.findElement(By.partialLinkText("תמצאו לי מתנה"));// press submit
        element.click();
    }
}
