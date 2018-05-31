package Pages;

import Pages.Page;
import Pages.SignInPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Dimension;

public class SignUpPage extends Page {

    public SignUpPage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sign Up']")
    private MobileElement heading;

    @AndroidFindBy(id = "co.spacein.mobile.spacepass:id/skip_button")
    private MobileElement skipButton;

    @AndroidFindBy(xpath = "//TextInputLayout[@text = 'E-mail']")
    private MobileElement emailField;

    @AndroidFindBy(id = "co.spacein.mobile.spacepass:id/et_mail")
    private MobileElement emailInput;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/TextInputLayout[2]/android.widget.FrameLayout/android.widget.EditText")
    private MobileElement passwordInput;

    @AndroidFindBy(xpath = "//TextInputLayout[@text = 'Password']")
    private MobileElement passwordField;

    @AndroidFindBy(accessibility = "Toggle password visibility")
    private MobileElement eyeButton;

    @AndroidFindBy(id = "co.spacein.mobile.spacepass:id/ch_terms")
    private MobileElement checkBox;

    @AndroidFindBy(id = "co.spacein.mobile.spacepass:id/tv_terms")
    private MobileElement termsLink;

    @AndroidFindBy(id = "co.spacein.mobile.spacepass:id/bt_sign_up")
    private MobileElement signUpButton;

    @AndroidFindBy(id = "co.spacein.mobile.spacepass:id/facebook_bt_sign_in")
    private MobileElement facebookButton;

    @AndroidFindBy(id = "co.spacein.mobile.spacepass:id/google_bt_sign_in")
    private MobileElement googleButton;


    public String headingText = getText(heading);

    public String skipButtonText = getText(skipButton);

    public String emailFieldText = getText(emailField);

    public String passFieldText = getText(passwordField);

    public boolean eyeButtonVisibility() {return eyeButton.isDisplayed();}

    public String termsLinkText = getText(termsLink);

    public String signUpButtonText = getText(signUpButton);

    public String facebookText = getText(facebookButton);

    public String googleButtonText = getText(googleButton);

    public boolean checkboxVisibility() {return checkBox.isDisplayed();}

    public String passwordText() {return driver.findElementByXPath("//android.widget.EditText[@text='12345678']").getText();}

    public void swipeDown() throws InterruptedException {
        Dimension size = driver.manage().window().getSize();
        int x = size.getWidth()/2;
        int y1 = (int)(size.getHeight()*0.60);
        int y2 = (int)(size.getHeight()*0.10);
        driver.swipe(x, y1,x, y2, 750);
        Thread.sleep(1000);
    }
    public String iHaveAnAcctext() {return driver.findElementById("co.spacein.mobile.spacepass:id/bt_have_acc").getText();}

    public SignInPage accButtonClick() {
        driver.findElementById("co.spacein.mobile.spacepass:id/bt_have_acc").click();
        return new SignInPage(driver);
    }
}
