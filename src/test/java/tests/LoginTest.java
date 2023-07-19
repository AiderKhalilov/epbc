package tests;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import utils.CommonMethods;

public class LoginTest extends CommonMethods {
    String randomEmail = CreateAccountTest.randomEmail;
    String password = CreateAccountTest.password;

    @When("user logs in to their newly created account")
    public void user_logs_in_to_their_newly_created_account() {
        login.loginToEPBCafterRegistration.click ();
        login.loginUsername.sendKeys ( randomEmail );
        login.loginPassword.sendKeys ( password );
        login.loginBTN.click ();
    }

    @Then("user is successfully logged in can view the personal information section")
    public void user_is_successfully_logged_in_can_view_the_personal_information_section() {
        if (profile.popup.isDisplayed ()) {
            profile.popup.click ();
        }
        Assert.assertTrue ( driver.findElement ( By.id ( "apply-header" ) ).isDisplayed () );
    }

}
