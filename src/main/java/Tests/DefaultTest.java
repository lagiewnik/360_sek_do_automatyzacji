package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public abstract class DefaultTest
{
    public static WebDriver driver;

    @BeforeTest()
    public void BeforeTest()
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://demo.testarena.pl/zaloguj");
    }

    @AfterTest()
    public void AfterSuite()
    {
        //driver.close();
        driver.quit();
    }
}