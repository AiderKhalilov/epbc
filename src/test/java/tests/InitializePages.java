package tests;

import pages.CreateAccountPage;
import pages.LoginPage;
import pages.ProfilePage;

public class InitializePages {
    public static CreateAccountPage createAccount;
    public static ProfilePage profile;
    public static LoginPage login;
    public static void intializeObjects() {
        createAccount = new CreateAccountPage ();
        profile = new ProfilePage ();
        login = new LoginPage ();
    }
}
