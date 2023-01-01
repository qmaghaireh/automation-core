package qualityline.automation.web.core.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import qualityline.automation.common.BaseDriver;

public class BaseChromeDriver extends BaseDriver<ChromeDriver> {

    @Override
    public WebDriverManager getDriverManager() {
        return WebDriverManager.chromedriver();
    }

    @Override
    public DesiredCapabilities getDesiredCapabilities() {
        return null;
    }

    @Override
    public ChromeDriver createDriver() {
        return new ChromeDriver(getService(), getOptions());
    }

    private ChromeDriverService getService() {
        return new ChromeDriverService.Builder().usingAnyFreePort().build();
    }

    private ChromeOptions getOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("-incognito");
        return options;
    }
}
