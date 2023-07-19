package tests;

import io.cucumber.java.en.*;
import org.junit.Assert;
import utils.CommonMethods;

public class CreateAccountNegativeTest extends CommonMethods {
    @When("user clicks the sign up button")
    public void user_clicks_the_sign_up_button() {
        createAccount.signUpButtons ();
    }

    @When("user enter invalid {string} {string} {string} {string}")
    public void user_enter_invalid(String email, String confEmail, String pass, String confirmPass) {
        sendText ( createAccount.getEmail (), email );
        sendText ( createAccount.confirmEmail, confEmail );
        sendText ( createAccount.password, pass );
        sendText ( createAccount.passwordConfirmation, confirmPass );
        pressTAB ();
    }

    @Then("user gets warning message")
    public void user_gets_warning_message() {
        //Assertion of the email box
        if (createAccount.getEmail ().getAttribute ( "value" ).isEmpty ()) {
            Assert.assertEquals ( createAccount.getEmailError ().getText ().trim (), "Email Address is required." );
        } else {
            Assert.assertEquals ( createAccount.getEmailError ().getText ().trim (), "Does not conform to the \"email\" format." );
        }
        //Assertion of the email confirmation box
        if (createAccount.confirmEmail.getAttribute ( "value" ).isEmpty ()) {
            Assert.assertEquals ( createAccount.getConfirmEmailError ().getText ().trim (), "Confirm Email Address is required." );
        } else {
            Assert.assertEquals ( createAccount.getConfirmEmailError ().getText ().trim (), "Confirm Email Address does not match Email Address entered above." );
        }
        //Assertion of the password box
        if (createAccount.password.getAttribute ( "value" ).isEmpty ()) {
            Assert.assertEquals ( createAccount.getPasswordError ().getText ().trim (), "Password is required." );
        } else if (createAccount.password.getAttribute ( "value" ).length () < 8) {
            Assert.assertTrue ( createAccount.passwordLengthError.getText ().contains ( "Does not meet minimum length of 8." ) );
        } else {
            Assert.assertEquals ( createAccount.passwordLengthError.getText ().trim (), "Password does not meet all character requirements." );
        }
        //Assertion of the password confirmation box
        if (createAccount.getConfirmPass ().getAttribute ( "value" ).isEmpty ()) {
            Assert.assertEquals ( createAccount.confirmPassError.getText ().trim (), "Confirm Password is required." );
        } else {
            Assert.assertEquals ( createAccount.confirmPassError.getText ().trim (), "Confirm Password does not match Password entered above." );
        }

    }
}
