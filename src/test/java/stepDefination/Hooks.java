package stepDefination;

import Pages.WelcomePage;
import Properties.Caps;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;

public class Hooks extends Caps {

    private static AndroidDriver driver;
    private WelcomePage welcomePage;

    @Before
    public void beforeValidation() throws MalformedURLException {
        driver= Caps.capabilities();
        welcomePage = new WelcomePage(driver);
    }

    @After
    public void afterValidation() {
            driver.quit();
    }


}