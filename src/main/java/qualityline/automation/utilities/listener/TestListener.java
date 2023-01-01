package qualityline.automation.utilities.listener;


import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import qualityline.automation.annotations.IgnoreLogin;
import qualityline.automation.annotations.Login;
import qualityline.automation.utilities.helpers.LogColor;
import qualityline.automation.utilities.helpers.LoginSteps;

import java.lang.reflect.Method;

@Log4j2
public class TestListener implements ITestListener, IInvokedMethodListener {

    public static WebDriver driver;
    private static String testName;

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(LogColor.ANSI_RED + " *************************");
        log.info(LogColor.ANSI_RED + "Test '" + getTestMethodName(result) + "' FAILED");
        log.info(LogColor.ANSI_RED + "Priority of this method is " + result.getMethod().getPriority());
        log.info(LogColor.ANSI_RED + "Class test name : " + result.getTestClass().getName());
        System.out.println(LogColor.ANSI_RED + " *************************");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(LogColor.ANSI_YELLOW + " *************************");
        log.info(LogColor.ANSI_YELLOW + "Test '" + result.getName() + "' SKIPPED");
        log.info(
                LogColor.ANSI_YELLOW + "Priority of this method is " + result.getMethod().getPriority());
        log.info(LogColor.ANSI_YELLOW + "Class test name : " + result.getTestClass().getName());
        System.out.println(LogColor.ANSI_YELLOW + " *************************");
    }

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(LogColor.ANSI_GREEN + " *************************");
        log.info(LogColor.ANSI_GREEN + "Test '" + getTestMethodName(result) + "' PASSED");
        log.info(
                LogColor.ANSI_GREEN + "Priority of this method is " + result.getMethod().getPriority());
        log.info(LogColor.ANSI_GREEN + "Class test name : " + result.getTestClass().getName());
        System.out.println(LogColor.ANSI_GREEN + " *************************");
    }

    @Override
    public void beforeInvocation(
            IInvokedMethod invokedMethod, ITestResult testResult, ITestContext context) {
        Class<?> cls =
                invokedMethod.getTestMethod().getConstructorOrMethod().getMethod().getDeclaringClass();
        Method method = invokedMethod.getTestMethod().getConstructorOrMethod().getMethod();
        Login login = cls.getAnnotation(Login.class);
        IgnoreLogin ignoreLogin = method.getAnnotation(IgnoreLogin.class);
        if (login != null && ignoreLogin == null) {
            startLogin(login);
        }
    }

    private void startLogin(Login login) {
        try {
            LoginSteps loginSteps = login.value().getConstructor(WebDriver.class).newInstance(driver);
            loginSteps.getDriver().navigate().to(loginSteps.getUrl());
            loginSteps.getEmailElement().sendKeys(loginSteps.getEmail());
            loginSteps.getPasswordElement().sendKeys(loginSteps.getPassword());
            loginSteps.click();
        } catch (Exception exception) {
        }
    }
}
