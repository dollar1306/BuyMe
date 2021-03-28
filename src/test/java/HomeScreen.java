import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomeScreen {
    private static WebElement element = null;

    public static void pressPrice (WebDriver driver) {

        element=driver.findElement(By.partialLinkText("סכום"));
        element.click();

    }

    public static void selectPrice(WebDriver driver){
        element = driver.findElement(By.xpath("//li[@data-option-array-index='5']"));
        element.click();
    }

    public static void pressArea(WebDriver driver){
        element=driver.findElement(By.partialLinkText("אזור"));
        element.click();

    }

    public static void selectArea(WebDriver driver){
        element = driver.findElement(By.xpath("//li[@data-option-array-index='1']"));
        element.click();
    }

    public static void pressType(WebDriver driver) {
        element=driver.findElement(By.partialLinkText("קטגוריה"));
        element.click();

    }

    public static void selectType(WebDriver driver){
        element = driver.findElement(By.xpath("//li[@data-option-array-index='2']"));
        element.click();
    }

    public static void pressSubmit(WebDriver driver){
        element=driver.findElement(By.partialLinkText("תמצאו לי מתנה"));
        element.click();
    }
}
