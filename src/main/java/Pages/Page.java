package Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public abstract class Page {

    public Page(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }

    protected AndroidDriver driver;


    public String getText(MobileElement element) {
        return element.getText();
    }

    public void buttonClick(MobileElement element) {
        element.click();
    }

    public void typeText(MobileElement element, String text) {
        element.sendKeys(text);
    }

    public void cleanField(MobileElement element) {element.clear();}

    public boolean isElementPresent(String xpath) {
        try {
            driver.findElementByXPath(xpath);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementInPluralIsPresent(String classname, int index) {
        try {
            driver.findElementsByClassName(classname).get(index);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void alertVisibility() {
        boolean i = isElementPresent("//android.widget.TextView[@text='Разрешить приложению SpacePass доступ к данным о местоположении устройства?']");
        if (i == true) {
            driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
        }
    }

    public void swipeDown() throws InterruptedException {
        Dimension size = driver.manage().window().getSize();
        int x = size.getWidth()/2;
        int y1 = (int)(size.getHeight()*0.60);
        int y2 = (int)(size.getHeight()*0.10);
        driver.swipe(x, y1,x, y2, 750);
        Thread.sleep(1000);
    }

    public String currentDate() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("E, MMM dd, yyyy");
        return format.format(date);
    }

    public void swipeUp() throws InterruptedException {
        Dimension size = driver.manage().window().getSize();
        int x = size.getWidth()/2;
        int y1 = (int)(size.getHeight()*0.50);
        int y2 = (int)(size.getHeight()*0.70);
        driver.swipe(x, y1,x, y2, 750);
        Thread.sleep(1000);
    }

}

