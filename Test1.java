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

public class Test1 {
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
    		report = new ExtentReports(System.getProperty("C:\\Users\\monika.moolya\\Downloads\\")+"ExtentReportTest1Results.html");
    		test = report.startTest("Test1");
    		}
    }

    @Test
    public void testWebsiteElements() throws InterruptedException {

//1.Design a test to check that all elements on screen are correct,such as positioning, colour, text etc. 
        WebElement logoImage = driver.findElement(By.className("logo"));
        // Check the title
		assertEquals("Packt Subscription | Advance your knowledge in tech", driver.getTitle());
		System.out.println("Packt Title is getting displayed");
		if(driver.getTitle().equals("Packt Subscription | Advance your knowledge in tech"))
		{
		test.log(LogStatus.PASS, "Packt Title is getting displayed");
		}
		else
		{
		test.log(LogStatus.FAIL, "Test Failed");
		}
        // Find and check the search bar
       WebElement searchBox = driver.findElement(By.name("query"));
       assertTrue(searchBox.isDisplayed());
	   System.out.println("Searchbox is getting displayed");
	   

        // Check the background color
       String backgroundColor = searchBox.getCssValue("color");
        assertEquals("rgb(73, 80, 87)", backgroundColor);
 	   System.out.println("Background color for search is done");
  

         //Check the placeholder text
       String placeholderText = searchBox.getAttribute("placeholder");
       assertEquals("Search titles …", placeholderText);
 	   System.out.println("Placeholder is getting displayed");
 	  if(driver.getCurrentUrl().equals("https://subscription.packtpub.com/"))
		{
		test.log(LogStatus.PASS, "Search titles … is getting displayed");
		}
		else
		{
		test.log(LogStatus.FAIL, "Test Failed");
		}
    }


    @After
    public void tearDown() throws InterruptedException {
    	Thread.sleep(3000);
    	report.endTest(test);
    	report.flush();
       driver.quit();
    }
}