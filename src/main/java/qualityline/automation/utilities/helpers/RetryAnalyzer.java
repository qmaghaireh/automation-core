package qualityline.automation.utilities.helpers;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class RetryAnalyzer implements IRetryAnalyzer {

  private final int maxRetryCount = 1;
  private int retryCount = 0;

  @Override
  public boolean retry(ITestResult iTestResult) {
    iTestResult.setStatus(iTestResult.isSuccess() ? ITestResult.SUCCESS : ITestResult.FAILURE);
    if (!iTestResult.isSuccess() && retryCount < maxRetryCount) {
      String message =
          Thread.currentThread().getName()
              + ": Error in "
              + iTestResult.getName()
              + " Retrying "
              + (maxRetryCount + 1 - retryCount)
              + " more times";
      Reporter.log(message);
      retryCount++;
      return true;
    }
    return false;
  }
}
