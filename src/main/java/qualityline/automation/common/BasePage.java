package qualityline.automation.common;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import qualityline.automation.mobile.core.drivers.BaseAndroidDriver;
import qualityline.automation.mobile.core.drivers.BaseIosDriver;

public class BasePage<D extends WebDriver> {

    private final D driver;

    public BasePage(D driver) {
        this.driver = driver;
        if (driver instanceof BaseIosDriver || driver instanceof BaseAndroidDriver) {
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        } else {
            PageFactory.initElements(driver, this);
        }
    }

    public D getDriver() {
        return driver;
    }
}
