package qualityline.automation.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import qualityline.automation.annotations.AfterDriver;
import qualityline.automation.mobile.core.drivers.BaseAndroidDriver;
import qualityline.automation.mobile.core.drivers.BaseIosDriver;
import qualityline.automation.utilities.helpers.ConfigKey;
import qualityline.automation.utilities.helpers.config.ProfilesConfigReader;
import qualityline.automation.web.core.drivers.BaseChromeDriver;
import qualityline.automation.web.core.drivers.BaseFirefoxDriver;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    private static final Map<Drivers, BaseDriver<?>> drivers = new HashMap<>();
    private static final Drivers driverType =
            EnumParsers.parseBrowsers(
                    (ProfilesConfigReader.getInstance().getPropValue(ConfigKey.PLATFORM_NAME)));

    public BaseTest() {
        drivers.put(Drivers.CHROME, new BaseChromeDriver());
        drivers.put(Drivers.FIREFOX, new BaseFirefoxDriver());
        drivers.put(Drivers.ANDROID, new BaseAndroidDriver());
        drivers.put(Drivers.IOS, new BaseIosDriver());
    }

    @SneakyThrows
    @BeforeMethod
    public void setupClass() {
        WebDriverManager driverManager = getBaseDriver().getDriverManager();
        if (driverManager != null) {
            driverManager.setup();
        } else {
            getBaseDriver().setup();
            Method[] methods = this.getClass().getDeclaredMethods();
            for (Method method : methods) {
                AfterDriver afterDriver = method.getAnnotation(AfterDriver.class);
                if (afterDriver != null) {
                    method.invoke(this);
                }
            }
        }
    }

    private BaseDriver getBaseDriver() {
        return drivers.get(driverType);
    }

    @AfterClass
    public void tearDown() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
        }
    }

    public <T extends WebDriver> T getDriver() {
        return (T) getBaseDriver().getDriver();
    }
}

