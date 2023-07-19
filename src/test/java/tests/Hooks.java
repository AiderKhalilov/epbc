package tests;

import io.cucumber.java.*;
import utils.CommonMethods;

public class Hooks extends CommonMethods {
    @Before
    public void preCondition(){
        launchBrowser ();
    }
    @After
    public void postCondition(){
        closeBrowser ();
    }
}
