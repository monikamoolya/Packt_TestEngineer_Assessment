package Pack;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class TestBase {
static ExtentTest test;
static ExtentReports report;

private WebDriver driver;
@BeforeClass
public static void startTest()
{
report = new ExtentReports(System.getProperty("C:\\Users\\monika.moolya\\Downloads\\")+"ExtentReportResults.html");
test = report.startTest("TestBase");
}
@Test
public void extentReportsDemo()
{
   System.setProperty("webdriver.gecko.driver", "C:\\Eclipse Workspace\\Drivers\\geckodriver.exe");
   driver = new FirefoxDriver();
   driver.get("https://subscription.packtpub.com/");
if(driver.getTitle().equals("Packt Subscription | Advance your knowledge in tech"))
{
test.log(LogStatus.PASS, "Navigated to the specified URL");
}
else
{
test.log(LogStatus.FAIL, "Test Failed");
}
}
@AfterClass
public static void endTest()
{
report.endTest(test);
report.flush();
}
}