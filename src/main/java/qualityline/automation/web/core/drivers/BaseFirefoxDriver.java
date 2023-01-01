package qualityline.automation.web.core.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import qualityline.automation.common.BaseDriver;

public class BaseFirefoxDriver extends BaseDriver<FirefoxDriver> {

    @Override
    public WebDriverManager getDriverManager() {
        return WebDriverManager.firefoxdriver();
    }

    @Override
    public FirefoxDriver createDriver() {
        return new FirefoxDriver(getService(), getOptions());
    }

    @Override
    public DesiredCapabilities getDesiredCapabilities() {
        return null;
    }

    private GeckoDriverService getService() {
        return new GeckoDriverService.Builder().usingAnyFreePort().build();
    }

    private FirefoxOptions getOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");
        options.addArguments("-incognito");
        return options;
    }
}
