package qualityline.automation.utilities.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementUtils {

  private final WebDriver driver;

  public ElementUtils(WebDriver driver) {
    this.driver = driver;
  }

  public boolean waitForElementDisappear(By element) {
    try {
      new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfElementLocated(element));
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }
}
