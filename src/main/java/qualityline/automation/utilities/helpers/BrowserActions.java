package qualityline.automation.utilities.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class BrowserActions {

  private final WebDriver driver;

  public BrowserActions(WebDriver driver) {
    this.driver = driver;
  }

  public void openNewTabBrowser(String url) {
    ((JavascriptExecutor) driver).executeScript("window.open('" + url + "');");
  }

  public void closeTheCurrentTabBrowser() {
    String mainWindow = driver.getWindowHandle();
    Set<String> windowHandles = driver.getWindowHandles();
    Iterator<String> iterator = windowHandles.iterator();
    while (iterator.hasNext()) {
      String childWindow = iterator.next();
      if (!mainWindow.equalsIgnoreCase(childWindow)) {
        driver.switchTo().window(childWindow);
        driver.close();
      }
    }
  }

  public void acceptBrowserAlert() {
    try {
      driver.switchTo().alert().accept();
    } catch (RuntimeException e) {
      throw new RuntimeException(e);
    }
  }

  public void refreshWindow() {
    driver.navigate().refresh();
  }
}
