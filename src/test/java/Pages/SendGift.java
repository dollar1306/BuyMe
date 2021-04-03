package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendGift {
    private static WebElement element = null;

    public static void selectForWho(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("button-forSomeone")));
        driver.findElement(By.className("button-forSomeone")).click();
    }

    public static void enterName(WebDriver driver){
        element = driver.findElement(By.cssSelector("input[data-parsley-required-message='מי הזוכה המאושר? יש להשלים את שם המקבל/ת']"));
        element.sendKeys("Elena");
    }

    public static void pressEvent(WebDriver driver) {

        element = driver.findElement(By.cssSelector("div[class='selected-name']"));//לאיזה אירוע?
        element.click();

    }
    public static void selectEvent(WebDriver driver){
        element = driver.findElement(By.cssSelector("span[alt='סתם כי בא לי לפנק']"));
        element.click();
    }

    public static void cleanAndSendBlessing(WebDriver driver) {
        element = driver.findElement(By.xpath("//textarea[@rows='4']"));
        element.clear();
        element.sendKeys("Love you to the moon and back");

    }

    public static void uploadImage(WebDriver driver) {
        element = driver.findElement(By.cssSelector("input[type='file']"));
        element.sendKeys("files/animal.jpg");
    }


    public static void pressNext(WebDriver driver){
        element = driver.findElement(By.cssSelector("button[gtm='המשך']"));
        element.click();
    }


    public static void SelectWhen(WebDriver driver) {
        element = driver.findElement(By.className("button-now"));
        element.click();

    }

    public static void howToSend(WebDriver driver) {
        element = driver.findElement(By.cssSelector("svg[gtm='method-sms']"));
        element.click();

    }


    public static void enterTelephoneFor (WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@data-parsley-mobile='mobile']"));
        element.sendKeys("0559960996");

    }

    public static void nameFromHow(WebDriver driver){
        element = driver.findElement(By.xpath("//input[@data-parsley-required-message='למי יגידו תודה? שכחת למלא את השם שלך']"));
        element.sendKeys("Alex");
    }

    public static void enterTelephoneFrom (WebDriver driver) {
        element = driver.findElement(By.cssSelector("input[placeholder='מספר נייד']"));
        element.sendKeys("0502448568");

    }

    public static void continueToPay(WebDriver driver){
        element = driver.findElement(By.cssSelector("button[gtm='המשך לתשלום']"));
        element.click();
    }
}