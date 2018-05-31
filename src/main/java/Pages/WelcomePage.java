package Pages;

import Pages.Page;
import Pages.SignInPage;
import Pages.SignUpPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class WelcomePage extends Page {

    public WelcomePage(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "co.spacein.mobile.spacepass:id/bt_start")
    private MobileElement startButton;

    @AndroidFindBy(id = "co.spacein.mobile.spacepass:id/bt_sign_in")
    private MobileElement signInButton;

    @AndroidFindBy(className = "android.widget.TextView")
    private MobileElement heading;


    @Step
    public SignUpPage clickStartButton() {
        buttonClick(startButton);
        return new SignUpPage(driver);
    }
    @Step
    public SignInPage clickSignInButton() {
        buttonClick(signInButton);
        return new SignInPage(driver);
    }

    public String headingText = getText(heading);
    public String startButtonText = getText(startButton);
    public String signInButtonText = getText(signInButton);

}
