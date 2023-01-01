package qualityline.automation.mobile.core.drivers;


import io.appium.java_client.android.AndroidDriver;
import lombok.SneakyThrows;
import org.openqa.selenium.remote.DesiredCapabilities;
import qualityline.automation.common.BaseDriver;
import qualityline.automation.mobile.core.models.DeviceWrapper;

import java.net.URL;

public class BaseAndroidDriver extends BaseDriver<AndroidDriver> {

    @SneakyThrows
    public AndroidDriver createDriver() {
        return new AndroidDriver(new URL(getAppiumUrl()), getDesiredCapabilities());
    }

    @Override
    public DesiredCapabilities getDesiredCapabilities() {
        DeviceWrapper deviceWrapper = DeviceWrapper.create();
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(
                "platformVersion", deviceWrapper.getAndroid().getPlatformName());
        desiredCapabilities.setCapability("deviceName", deviceWrapper.getAndroid().getDeviceName());
        desiredCapabilities.setCapability(
                "appPackage", deviceWrapper.getAndroid().getAndroidAppPackage());
        desiredCapabilities.setCapability(
                "appActivity", deviceWrapper.getAndroid().getAndroidAppActivity());
        desiredCapabilities.setCapability(
                "automationName", deviceWrapper.getAndroid().getAutomationName());
        desiredCapabilities.setCapability("fullReset", deviceWrapper.getAndroid().getFullReset());
        return desiredCapabilities;
    }
}