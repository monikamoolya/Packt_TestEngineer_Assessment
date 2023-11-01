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

public class Test3 {
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
//3.In the “your suggested titles” section, design automated tests to click the titles in the carousel below the main title, and ensure that they appear correctly as the main title.      

     Thread.sleep(3000);
 
     JavascriptExecutor js = (JavascriptExecutor) driver;
     js.executeScript("window.scrollBy(0,550)", ""); 
     // Click the "your suggested titles" section to expand it
     //Title 1
     WebElement suggestedTitlesSection1 = driver.findElement(By.xpath("/html/body/div[1]/div/main/section[2]/div[3]/div[3]/div/div/div/div[2]/div/div"));
     suggestedTitlesSection1.click();
     Thread.sleep(3000);
     assertTrue(suggestedTitlesSection1.isDisplayed());
     System.out.println((suggestedTitlesSection1).getText());
     
     JavascriptExecutor js1 = (JavascriptExecutor) driver;
     js1.executeScript("window.scrollBy(0,350)", ""); 
     
     // Click the "your suggested titles" section to expand it
     //Title 2
     WebElement suggestedTitlesSection2 = driver.findElement(By.xpath("/html/body/div[1]/div/main/section[2]/div[3]/div[3]/div/div/div/div[3]/div/div"));
     suggestedTitlesSection2.click();
     Thread.sleep(3000);
     JavascriptExecutor js2 = (JavascriptExecutor) driver;
     js2.executeScript("window.scrollBy(0,-450)", ""); 
     assertTrue(suggestedTitlesSection2.isDisplayed());
     System.out.println((suggestedTitlesSection2).getText());
     
    }

    @After
    public void tearDown() throws InterruptedException {
    	Thread.sleep(3000);
       driver.quit();
    }
}
