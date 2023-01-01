package qualityline.automation.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import qualityline.automation.utilities.helpers.ConfigKey;
import qualityline.automation.utilities.helpers.config.ProfilesConfigReader;

public abstract class BaseDriver<D extends WebDriver> {

    private final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public abstract D createDriver();

    public WebDriverManager getDriverManager() {
        return null;
    }

    public WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public abstract DesiredCapabilities getDesiredCapabilities();

    public void setup() {
        driverThreadLocal.set(createDriver());
    }

    protected String getAppiumUrl() {
        return ProfilesConfigReader.getInstance().getPropValue(ConfigKey.APPIUM_URL);
    }
}