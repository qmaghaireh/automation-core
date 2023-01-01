package qualityline.automation.mobile.core.drivers;

import io.appium.java_client.ios.IOSDriver;
import lombok.SneakyThrows;
import org.openqa.selenium.remote.DesiredCapabilities;
import qualityline.automation.common.BaseDriver;
import qualityline.automation.mobile.core.models.DeviceWrapper;

import java.net.URL;

public class BaseIosDriver extends BaseDriver<IOSDriver> {

    @SneakyThrows
    public IOSDriver createDriver() {
        return new IOSDriver (new URL(getAppiumUrl()), getDesiredCapabilities());
    }

    @Override
    public DesiredCapabilities getDesiredCapabilities() {
        DeviceWrapper deviceWrapper = DeviceWrapper.create();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", deviceWrapper.getIos().getPlatformName());
        desiredCapabilities.setCapability(
                "platformVersion", deviceWrapper.getIos().getPlatformVersion());
        desiredCapabilities.setCapability("deviceName", deviceWrapper.getIos().getDeviceName());
        desiredCapabilities.setCapability("udid", deviceWrapper.getIos().getUdid());
        desiredCapabilities.setCapability("app", deviceWrapper.getIos().getApp());
        desiredCapabilities.setCapability("automationName", deviceWrapper.getIos().getAutomationName());
        return desiredCapabilities;
    }
}
