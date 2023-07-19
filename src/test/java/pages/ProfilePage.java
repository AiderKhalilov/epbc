package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class ProfilePage extends CommonMethods {
    @FindBy(css = "#profile--heading .fa-chevron-up")
    public WebElement personalInfo;
    @FindBy(css = "[aria-label='Save']")
    public WebElement personalInfoSaveBtn;
    @FindBy(id = "first-name")
    public WebElement firstName;
    @FindBy(id = "last-name")
    public WebElement lastName;
    @FindBy(xpath = "//input[@value='M']")
    public WebElement maleCheckBox;
    @FindBy(xpath = "(//input[@name='genderAssignmentCode'])[1]")
    public WebElement genderAssignment;
    @FindBy(id = "react-select-2-input")
    public WebElement yearOfBirth;
    @FindBy(id = "react-select-3-input")
    public WebElement birthMonth;
    @FindBy(id = "react-select-4-input")
    public WebElement birthDay;
    @FindBy(id = "react-select-6-input")
    public WebElement studentPrimaryLang;
    @FindBy(id = "react-select-7-input")
    public WebElement studentCitizenship;
    @FindBy(xpath = "//a[contains(text(),'Dismiss')]")
    public WebElement popup;

    public ProfilePage() {
        PageFactory.initElements ( driver, this );
    }
}
