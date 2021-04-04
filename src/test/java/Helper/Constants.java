package Helper;


import org.openqa.selenium.By;

public class Constants {

    public static final String OPEN_URL = "websiteURL";
    //public static final String IMAGES_PATH = "files/ScreenShot";
    public static final String CONFIG_XML_FILE ="src\\main\\resources\\data.xml";

    //Registration
    public static final By PRESS_REGISTRATION_LINK = By.partialLinkText("כניסה");//PRESS_REGISTRATION_LINK
    public static final By ENTER_NAME = By.cssSelector("input[placeholder='שם פרטי']");//ENTER_NAME
    public static final String NAME = "Alex Alex";
    public static final By ENTER_EMAIL = By.cssSelector("input[placeholder='מייל']");//ENTER_EMAIL
    public static final String EMAIL_FOR_SEND = "dollar1306@gmail.com";
    public static final By ENTER_PASSWORD = By.cssSelector("input[placeholder='סיסמה']");//ENTER_PASSWORD
    public static final String PASSWORD = "Alex1234";
    public static final By ENTER_PASSWORD_AGAIN = By.cssSelector("input[placeholder='אימות סיסמה']");//ENTER_PASSWORD_AGAIN
    public static final By REGISTRATION_BUTTON = By.cssSelector("button[gtm='הרשמה ל-BUYME']");//REGISTRATION_BUTTON
    public static final By SUBMIT_BUTTON = By.cssSelector("button[gtm='כניסה ל-BUYME']");//SUBMIT_BUTTON



    //HomeScreen
    public static final By PRESS_ON_PRICE = By.partialLinkText("סכום");//PRESS_ON_PRICE
    public static final By SELECT_PRICE = By.xpath("//li[@data-option-array-index='5']");//SELECT_PRICE
    public static final By PRESS_AREA = By.partialLinkText("אזור");//PRESS_AREA
    public static final By SELECT_AREA = By.xpath("//li[@data-option-array-index='1']");//SELECT_AREA
    public static final By PRESS_TYPE = By.partialLinkText("קטגוריה");//PRESS_TYPE
    public static final By SELECT_TYPE = By.xpath("//li[@data-option-array-index='2']");//SELECT_TYPE
    public static final By PRESS_NEXT = By.partialLinkText("תמצאו לי מתנה");//PRESS_NEXT


    //SendGift
    public static final By SELECT_FOR_WHO = By.className("button-forSomeone");
    public static final By SELECT_FOR_SOME_ONE = By.className("button-forSomeone");//SELECT_FOR_SOME_ONE
    public static final By SELECT_FOR_WHO_LINE = By.cssSelector("input[data-parsley-required-message='מי הזוכה המאושר? יש להשלים את שם המקבל/ת']");//SELECT_FOR_WHO_LINE
    public static final String NAME_RECIPIENT = "Elena";//NAME_RECIPIENT
    public static final By WHAT_A_CELEBRATION = By.cssSelector("div[class='selected-name']");//WHAT_A_CELEBRATION
    public static final By SELECT_TO_CONGRATULATE = By.cssSelector("span[alt='סתם כי בא לי לפנק']");//SELECT_TO_CONGRATULATE
    public static final By SELECT_THE_BLESSING_PLACE = By.xpath("//textarea[@rows='4']");//SELECT_THE_BLESSING_PLACE
    public static final String SEND_THE_BLESSING = "Love you to the moon and back";
    public static final By SELECT_UPLOAD_IMAGE_PLACE = By.cssSelector("input[type='file']");//SELECT_UPLOAD_IMAGE_PLACE
    public static final String SEND_THE_IMAGE = "files/animal.jpg";
    public static final By PRESS_NEXT_BUTTON = By.cssSelector("button[gtm='המשך']");//PRESS_NEXT
    public static final By SELECT_WHEN = By.className("button-now");//SELECT_WHEN
    public static final By SELECT_HOW_TO_SEND = By.cssSelector("svg[gtm='method-sms']");//SELECT_HOW_TO_SEND
    public static final By SELECT_PHONE_PLACE = By.xpath("//input[@data-parsley-mobile='mobile']");//SELECT_PHONE_PLACE
    public static final String SEND_PHONE_NUMBER = "0559960996";//SEND_PHONE_NUMBER
    public static final By SELECT_FROM_WHO_PLACE = By.xpath("//input[@data-parsley-required-message='למי יגידו תודה? שכחת למלא את השם שלך']");//SELECT_FROM_WHO_PLACE
    public static final String SEND_NAME_FROM_WHO = "Alex";//SEND_NAME_FROM_WHO
    public static final By SELECT_FROM_WHO_PHONE_PLACE = By.cssSelector("input[placeholder='מספר נייד']");//SELECT_FROM_WHO_PHONE_PLACE
    public static final String SEND_PHONE_FROM_WHO = "0502448568";//SEND_PHONE_FROM_WHO
    public static final By CONTINUE_TO_PAY = By.cssSelector("button[gtm='המשך לתשלום']");//CONTINUE_TO_PAY

    //GiftScreen
    public static final By SELECT_BUSINESS = By.partialLinkText("מסעדת יאקימונו רוטשילד");
    public static final By ENTER_AMOUNT_FOR_PRESENT = By.cssSelector("input[data-parsley-type='number']");
    public static final String AMOUNT = "500";
    public static final By PRESS_SUBMIT = By.cssSelector("div>button[type='submit']:nth-child(1)");
}
