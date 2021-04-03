package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Registration {
    private static WebElement element = null;

    public static void openLink (WebDriver driver){
        element=driver.findElement(By.partialLinkText("כניסה"));//Sign in or registration
        element.click();

    }

    public static void enterName (WebDriver driver){
        element = driver.findElement(By.cssSelector("input[placeholder='שם פרטי']"));
        element.sendKeys("Alex Alex");//Name
    }

    public static void enterEmail (WebDriver driver){
        element = driver.findElement(By.cssSelector("input[placeholder='מייל']"));
        element.sendKeys("dollar1306@gmail.com");//Email
    }

    public static void enterPassword (WebDriver driver){
        element = driver.findElement(By.cssSelector("input[placeholder='סיסמה']"));
        element.sendKeys("Alex1234");//Password
    }

    public static void enterPasswordAgain (WebDriver driver){
        element = driver.findElement(By.cssSelector("input[placeholder='אימות סיסמה']"));
        element.sendKeys("Alex1234");//Password Authentication
    }

    public static void registrationButton (WebDriver driver){
        element = driver.findElement(By.cssSelector("button[gtm='הרשמה ל-BUYME']"));//registration button
        element.click();
    }

    public static void pressSubmit (WebDriver driver){
        element = driver.findElement(By.cssSelector("button[gtm='כניסה ל-BUYME']"));//submit button
        element.click();
    }

}
