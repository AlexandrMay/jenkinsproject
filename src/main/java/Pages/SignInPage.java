package Pages;

import Pages.Page;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

public class SignInPage extends Page {

    public SignInPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "co.spacein.mobile.spacepass:id/title")
    private MobileElement heading;

    @AndroidFindBy(id = "co.spacein.mobile.spacepass:id/skip_button")
    private MobileElement skipButton;

    @AndroidFindBy(id = "co.spacein.mobile.spacepass:id/text_input_layout_mail")
    private MobileElement emailField;

    @AndroidFindBy(id = "co.spacein.mobile.spacepass:id/et_mail")
    private MobileElement emailInput;

    @AndroidFindBy(id = "co.spacein.mobile.spacepass:id/text_input_layout_password")
    private MobileElement passwordField;

    @AndroidFindBy(className = "android.widget.EditText")
    private List<MobileElement> passwordInput;

    @AndroidFindBy(accessibility = "Toggle password visibility")
    private MobileElement eyeButton;

    @AndroidFindBy(id = "co.spacein.mobile.spacepass:id/bt_forgot")
    private MobileElement forgotPassButton;

    @AndroidFindBy(id = "co.spacein.mobile.spacepass:id/bt_sign_in")
    private MobileElement signInButton;

    @AndroidFindBy(id = "co.spacein.mobile.spacepass:id/facebook_bt_sign_in")
    private MobileElement facebookButton;

    @AndroidFindBy(id = "co.spacein.mobile.spacepass:id/google_bt_sign_in")
    private MobileElement googleButton;

    @AndroidFindBy(id = "co.spacein.mobile.spacepass:id/tv_sign_up")
    private MobileElement signUpButton;


    public String headingText = getText(heading);

    public String skipText = getText(skipButton);

    public String emailFieldText = getText(emailField);

    public String passwordFieldText = getText(passwordField);

    public boolean eyeButtonVisibility() {return eyeButton.isDisplayed();}

    public String forgotButtonText = getText(forgotPassButton);

    public String signInButtonText = getText(signInButton);

    public String facebookButtonText = getText(facebookButton);

    public String googleButtonText = getText(googleButton);

    public String signUpButtonText = getText(signUpButton);

    public String getEmailErrorText() {return driver.findElementByXPath("//android.widget.TextView[@text='Wrong format of email']").getText();}

    public String getPasswordErrorText() {return driver.findElementByXPath("//android.widget.TextView[@text='Wrong login or password']").getText();}

    public String passwordText() {return driver.findElementsByClassName("android.widget.EditText").get(1).getText();}

}
