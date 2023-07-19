package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.InitializePages;

import java.util.concurrent.TimeUnit;

public class CommonMethods extends InitializePages {
    public static WebDriver driver;

    public static void launchBrowser() {
        ConfigReader.readProperties ( Constants.CONFIGURATION_FILEPATH );
        switch ( ConfigReader.getPropertyValue ( "browser" ) ) {
            //Headless browser
            /*case "chrome":
                WebDriverManager.chromedriver ().setup ();
                ChromeOptions chromeOptions=new ChromeOptions();
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.setHeadless(true);
                driver = new ChromeDriver (chromeOptions);
                break;*/
            case "chrome":
                WebDriverManager.chromedriver ().setup ();
                driver = new ChromeDriver ();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver ().setup ();
                driver = new FirefoxDriver ();
                break;
            case "edge":
                WebDriverManager.edgedriver ().setup ();
                driver = new EdgeDriver ();
                break;
            default:
                throw new RuntimeException ( "Wrong browser name" );
        }
        driver.manage ().window ().maximize ();
        driver.get ( ConfigReader.getPropertyValue ( "url" ) );
        driver.manage ().timeouts ().implicitlyWait ( Constants.IMPLICIT_WAIT, TimeUnit.SECONDS );

        // Initialize locators in the "Pages" package
        intializeObjects ();
    }

    public static void closeBrowser() {
        driver.quit ();
    }

    public void pressTAB() {
        Actions action = new Actions ( driver );
        action.sendKeys ( Keys.TAB ).perform ();
    }

    public void moveToElement(WebElement myWebElement) {
        Actions actions = new Actions ( driver );
        actions.moveToElement ( myWebElement ).perform ();
    }

    public static void sendText(WebElement element, String textToSend) {
        element.clear ();
        element.sendKeys ( textToSend );
    }

    public static void reactDropdown(WebElement ele, String value) {
        ele.clear ();
        ele.sendKeys ( value );
        Actions action = new Actions ( driver );
        action.sendKeys ( Keys.ENTER ).perform ();
    }

    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait ( driver, Constants.EXPLICIT_WAIT );
        return wait;
    }

}
