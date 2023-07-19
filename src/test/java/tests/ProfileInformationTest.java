package tests;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.CommonMethods;

public class ProfileInformationTest extends CommonMethods {
    @Then("user enters personal information and clicks save button")
    public void user_enters_personal_information_and_clicks_save_button() {
        profile.personalInfo.click ();
        profile.firstName.sendKeys ( "Testname" );
        profile.lastName.sendKeys ( "TestLastName" );

        reactDropdown ( profile.yearOfBirth, "2010" );
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

    @Then("verify that personal info is successfully saved")
    public void verify_that_personal_info_is_successfully_saved() {
        System.out.println ( "Checked 2" );
        getWait ().until ( ExpectedConditions.visibilityOfElementLocated
                ( By.xpath ( "//span[text()='a few seconds ago']" ) ) );
    }

}
