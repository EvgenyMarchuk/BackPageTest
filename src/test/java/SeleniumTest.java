import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/");
    }

    @Test
    public void caseOneTest(){
        driver.findElement(By.linkText("Status Codes")).click();
        List<WebElement> links = driver.findElements(By.cssSelector(".example>ul>li>a"));
        int count = links.size();
        for (int i = 0; i < count; i++) {
            links.get(i).click();
            driver.navigate().back();
        }
    }

    @Test
    public void caseTwoTest(){
        driver.findElement(By.linkText("Status Codes")).click();
        List<WebElement> links = driver.findElements(By.cssSelector(".example>ul>li>a"));
        int count = links.size();
        for (int i = 0; i < count; i++) {
            driver.findElements(By.cssSelector(".example>ul>li>a")).get(i).click();
            driver.navigate().back();
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
        driver = null;
    }
}
