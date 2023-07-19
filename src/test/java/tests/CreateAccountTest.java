package tests;

import io.cucumber.java.en.*;
import org.junit.Assert;
import utils.CommonMethods;

public class CreateAccountTest extends CommonMethods {

    public static String randomEmail;
    public static String password = "Epbc2023!";

    @When("user clicks the sign up button and registers with the SPBC")
    public void user_clicks_the_sign_up_button_and_registers_with_the_spbc() {
        createAccount.signUpButtons ();
    }

    @When("user fills in the email and password")
    public void user_fills_in_the_email_and_password() {
        createAccount.emailAndPassword ();
    }

    @When("user authorizes EPBC to use personal information")
    public void user_authorizes_epbc_to_use_personal_information() {
        createAccount.authorizeEpbcCheckBox ();
        Assert.assertTrue ( createAccount.getConsentCheckBox ().isSelected () );
    }

    @Then("verify successful registration")
    public void verify_successful_registration() {
        Assert.assertTrue ( createAccount.registrationSuccesMessage.isDisplayed () );
    }

}
