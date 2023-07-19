package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {
    @FindBy(id = "signin-username")
    public WebElement loginUsername;
    @FindBy(id = "signin-password")
    public WebElement loginPassword;
    //Login button in the dropdown
    @FindBy(css = "[type='submit']")
    public WebElement loginBTN;

    //Login button which appears on the main page
    @FindBy(css = ".btn-success")
    public WebElement loginToEPBCaccountBtn;
    //Login button which appears after registration procces
    @FindBy(css = ".btn")
    public WebElement loginToEPBCafterRegistration;

    public LoginPage() {
        PageFactory.initElements ( driver, this );
    }
}
