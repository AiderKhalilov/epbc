package tests;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utils.CommonMethods;

public class InvalidDOBTest extends CommonMethods {
    @When("user logs in to the account")
    public void user_logs_in_to_the_account() {
        login.loginToEPBCaccountBtn.click ();
        login.loginUsername.sendKeys ( "test1@example.ca" );
        login.loginPassword.sendKeys ( "MyInterview2023!" );
        login.loginBTN.click ();
    }

    @When("user enters personal information, invalid DOB and clicks save button")
    public void user_enters_personal_information_invalid_dob_and_clicks_save_button() {
        profile.personalInfo.click ();
        profile.firstName.clear ();
        profile.firstName.sendKeys ( "Testname" );
        profile.lastName.clear ();
        profile.lastName.sendKeys ( "TestLastName" );
        reactDropdown ( profile.yearOfBirth, "1990" );
        String divSelector = ".css-1uccc91-singleValue";
        int desiredYear = 2011;
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String script = "document.querySelector(arguments[0]).textContent = arguments[1];";
        jsExecutor.executeScript ( script, divSelector, String.valueOf ( desiredYear ) );
        Actions action = new Actions ( driver );
        action.sendKeys ( Keys.ENTER ).perform ();

        reactDropdown ( profile.birthMonth, "Jan" );
        reactDropdown ( profile.birthDay, "01" );

        if (!profile.maleCheckBox.isSelected ()) {
            profile.maleCheckBox.click ();
        }

        if (!profile.genderAssignment.isSelected ()) {
            profile.genderAssignment.click ();
        }
        reactDropdown ( profile.studentPrimaryLang, "French" );
        reactDropdown ( profile.studentCitizenship, "Canada" );

        profile.personalInfoSaveBtn.click ();

    }

    @Then("verify that the invalid DOB was not saved")
    public void verify_that_the_invalid_dob_was_not_saved() {
        driver.navigate ().refresh ();
        profile.personalInfo.click ();
        String actualValue = driver.findElement
                ( By.cssSelector ( "#date-of-birth-year .css-1uccc91-singleValue" ) ).getText ();
        String expectedValue = "1990";
        Assert.assertEquals ( expectedValue, actualValue );
    }

}
