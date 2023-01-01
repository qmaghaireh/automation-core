package qualityline.automation.utilities.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface LoginSteps {

  String getUrl();

  String getEmail();

  String getPassword();

  WebElement getEmailElement();

  WebElement getPasswordElement();

  void click();

  WebDriver getDriver();
}
