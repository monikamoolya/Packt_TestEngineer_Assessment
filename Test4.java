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

import java.util.List;
import java.util.Set;

public class Test4 {
    private WebDriver driver;
    private WebDriverWait wait;


    @Before
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\Eclipse Workspace\\Drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        // Navigate to the website
        driver.get("https://subscription.packtpub.com/");
    	driver.manage().window().maximize();
    	wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testWebsiteElements() throws InterruptedException {
//4.Design a test that will click browse In the top nav, then click view all books. This should take you to the browse page. 
    	Thread.sleep(3000);
        WebElement navBar = driver.findElement(By.className("nav-link"));
        navBar.click();
    	Thread.sleep(8000);
        WebElement viewBook = driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[1]/div[2]/div[2]/div[1]/div[2]"));
        viewBook.click();
        System.out.println("All Books are displayed with count as " +(viewBook).getText());
 		Thread.sleep(8000);
//Click to clear any filters that are already set, and then click to set the 2021 filter for publication date. 
 		driver.findElement(By.className("reset-button")).click();
 		System.out.println("Filters are cleared");
 		 JavascriptExecutor js3 = (JavascriptExecutor) driver;
 	     js3.executeScript("window.scrollBy(0,350)", ""); 
//click on published Year and select 2021 	     
 	     WebElement pubYear = driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[1]/div[4]/div[1]/div"));
 	     pubYear.click();
 	    WebElement selectYear = driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[1]/div[4]/div[2]/div[4]/div[1]"));
 	   selectYear.click();
 	   System.out.println("Published Year as " +(selectYear).getText());
 	   Thread.sleep(3000);
 	   
//automate a test that will type the following words into the search bar, and check that all titles found include that search text. 
//Python search 	  
 	   WebElement search = driver.findElement(By.name("query"));
 	  search.sendKeys("Python");
 	 assertTrue(search.isDisplayed());
	   Thread.sleep(3000);
 	  driver.findElement(By.xpath("/html/body/div[1]/div/nav/form/button/i")).click();
 	 System.out.println("Python search text is getting displayed");
//Paint search
	   WebElement search1 = driver.findElement(By.name("query"));
	  search1.sendKeys("Paint");
	 assertTrue(search1.isDisplayed());
	   Thread.sleep(3000);
	  driver.findElement(By.xpath("/html/body/div[1]/div/nav/form/button/i")).click();
	 System.out.println("Paint search text is getting displayed");
//Secure search
	   WebElement search2 = driver.findElement(By.name("query"));
	   search2.sendKeys("Secure");
	 assertTrue(search2.isDisplayed());
	   Thread.sleep(3000);
	  driver.findElement(By.xpath("/html/body/div[1]/div/nav/form/button/i")).click();
	 System.out.println("Secure search text is getting displayed");
//Tableau search
	   WebElement search3 = driver.findElement(By.name("query"));
	   search3.sendKeys("Tableau");
	 assertTrue(search3.isDisplayed());
	   Thread.sleep(3000);
	  driver.findElement(By.xpath("/html/body/div[1]/div/nav/form/button/i")).click();
	 System.out.println("Tableau search text is getting displayed");
    }

    @After
    public void tearDown() throws InterruptedException {
    	Thread.sleep(3000);
      // driver.quit();
    }
}
