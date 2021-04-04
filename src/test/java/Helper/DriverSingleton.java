package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DriverSingleton {

    private static WebDriver driver;

    public static WebDriver getDriverInstance() throws IOException, SAXException, ParserConfigurationException {
        switch (XMLHandler.getData("browserType")) {
            case "Chrome": {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            }

            case "Firefox": {
                System.setProperty("webdriver.firefox.driver", "src/main/resources/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            }
        }
        return driver;
    }
}
