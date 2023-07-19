package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.CreateAccountTest;
import utils.CommonMethods;

public class CreateAccountPage extends CommonMethods {

    @FindBy(css = ".btn-primary")
    private WebElement signUpButton;
    @FindBy(css = ".epbc > .signin-box__text")
    private WebElement createAccountEPBC;
    @FindBy(id = "root_accountCreation_username")
    private WebElement email;
    @FindBy(id = "root_accountCreation_username-error")
    private WebElement emailError;
    @FindBy(id = "root_accountCreation_confirmUsername-error")
    private WebElement confirmEmailError;
    @FindBy(id = "root_accountCreation_password-error")
    private WebElement passwordError;
    @FindBy(id = "root_accountCreation_password-error")
    public WebElement passwordLengthError;
    @FindBy(id = "root_accountCreation_confirmPassword")
    private WebElement confirmPass;
    @FindBy(id = "root_accountCreation_confirmPassword-error")
    public WebElement confirmPassError;
    @FindBy(id = "root_accountCreation_confirmUsername")
    public WebElement confirmEmail;
    @FindBy(id = "root_accountCreation_password")
    public WebElement password;
    @FindBy(id = "root_accountCreation_confirmPassword")
    public WebElement passwordConfirmation;
    @FindBy(id = "root_consent_userConsent")
    private WebElement consentCheckBox;
    @FindBy(xpath = "//button[text()='Create Account']")
    private WebElement createAccountBtn;
    @FindBy(css = ".alert-success > .alert-title > div")
    public WebElement registrationSuccesMessage;

    public CreateAccountPage() {
        PageFactory.initElements ( driver, this );
    }

    public void signUpButtons(){
        signUpButton.click ();
        createAccountEPBC.click ();
    }

    public void emailAndPassword(){
        long timestamp = System.currentTimeMillis ();
        CreateAccountTest.randomEmail = "test" + timestamp + "@educationplannerbc.ca";
        email.sendKeys ( CreateAccountTest.randomEmail );
        confirmEmail.sendKeys ( CreateAccountTest.randomEmail );
        password.sendKeys ( CreateAccountTest.password );
        passwordConfirmation.sendKeys ( CreateAccountTest.password );
    }

    public void authorizeEpbcCheckBox(){
        if (!consentCheckBox.isSelected ()) {
            consentCheckBox.click ();
            consentCheckBox.click ();
        }
        createAccountBtn.click ();
    }
    public WebElement getConsentCheckBox() {
        return consentCheckBox;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getEmailError() {
        return emailError;
    }

    public WebElement getConfirmEmailError() {
        return confirmEmailError;
    }

    public WebElement getPasswordError() {
        return passwordError;
    }
    public WebElement getConfirmPass() {
        return confirmPass;
    }

}
