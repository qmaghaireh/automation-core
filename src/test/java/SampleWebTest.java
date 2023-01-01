import org.testng.annotations.Test;
import qualityline.automation.web.core.drivers.BaseChromeDriver;

public class SampleWebTest extends BaseChromeDriver {

    @Test
    public void SampleTest() throws InterruptedException {
        System.out.println("Hi there!");
        createDriver();
        getDriver().navigate().refresh();
        Thread.sleep(4000);
    }
}
