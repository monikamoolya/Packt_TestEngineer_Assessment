package Pack;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.util.List;
import java.util.Set;

public class Test2 {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentTest test;
    static ExtentReports report;


    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\Eclipse Workspace\\Drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        // Navigate to the website
        driver.get("https://subscription.packtpub.com/");
    	driver.manage().window().maximize();
    	wait = new WebDriverWait(driver, 10);
    	{
    		report = new ExtentReports(System.getProperty("C:\\Users\\monika.moolya\\Downloads\\")+"ExtentReportTest2Results.html");
    		test = report.startTest("Test2");
    		}
    }

    @Test
    public void testWebsiteElements() throws InterruptedException {

 //2.Design a test to check that the top nav bar, and their sub options go to the correct pages. 
 	  // Check the top navigation bar options and their destinations
    	Thread.sleep(3000);
       WebElement navBar = driver.findElement(By.className("nav-link"));
       navBar.click();
       wait.until(ExpectedConditions.urlToBe("https://subscription.packtpub.com/search"));
       assertEquals("Search | Packt Subscription", driver.getTitle());
 	   System.out.println("Top Navigation bar is displayed");
 	  if(driver.getTitle().equals("Search | Packt Subscription"))
		{
		test.log(LogStatus.PASS, "Search | Packt Subscription Title is getting displayed");
		}
		else
		{
		test.log(LogStatus.FAIL, "Test Failed");
		}
 		Thread.sleep(8000);
 		
 	   // Check the sub-options
       WebElement selectElement = driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[1]/div[2]/div[2]/div[1]/div[1]"));
       selectElement.click();
       
 	   System.out.println("Sub Option i.e. Book is displayed");
		Thread.sleep(8000);

 	   // Check the sub-options
 	  WebElement selectBook = driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[2]/div[1]/div[1]/a[2]/div[2]/div[1]"));
	  selectBook.click(); 
	  System.out.println((selectBook).getText());
	 Thread.sleep(8000);
	 Set<String> windowHandles = driver.getWindowHandles();

     // Switch to the first tab
	 String firstTab = (String) windowHandles.toArray()[0];
     driver.switchTo().window(firstTab);
    
    }

    @After
    public void tearDown() throws InterruptedException {
    	Thread.sleep(3000);
    	report.endTest(test);
    	report.flush();
       driver.quit();
    }
}
