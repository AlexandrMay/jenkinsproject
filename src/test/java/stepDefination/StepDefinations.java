package stepDefination;

import Pages.SignInPage;
import Pages.SignUpPage;
import Pages.WelcomePage;
import Properties.Caps;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;


public class StepDefinations extends Caps {

    private static AndroidDriver driver;
    private WelcomePage welcomePage;

    @Before
    public void SetUP() throws MalformedURLException {
        driver=capabilities();
        welcomePage = new WelcomePage(driver);
    }


    @Given("^User is on Welcome Screen$")
    public void user_is_on_welcome_screen() throws MalformedURLException {
        String heading = welcomePage.headingText;
        Assert.assertEquals("Welcome to" + System.lineSeparator() +"SpacePass", heading);
        String startButton = welcomePage.startButtonText;
        String s = startButton.toUpperCase();
        Assert.assertEquals("START", s);
        String signInButton = welcomePage.signInButtonText;
        Assert.assertEquals("Sign In", signInButton);
    }

    @When("^User tap to Sign In Button$")
    public void user_tap_to_sign_in_button() {
        SignInPage signInPage = welcomePage.clickSignInButton();
    }

    @Then("^User is on Sign In screen$")
    public void user_is_on_sign_in_screen() throws Throwable {
        SignInPage signInPage = new SignInPage(driver);
        String heading = signInPage.headingText;
        Assert.assertEquals("Sign In", heading);
        driver.navigate().back();
    }

    @When("^User tap to Start Button$")
    public void user_tap_to_start_button() throws Throwable {
        SignUpPage signUpPage = welcomePage.clickStartButton();
    }

    @Then("^User is on Sign Up screen$")
    public void user_is_on_sign_up_screen() throws Throwable {
        SignUpPage signUpPage = new SignUpPage(driver);
        String heading = signUpPage.headingText;
        Assert.assertEquals("Sign Up", heading);
        driver.navigate().back();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
