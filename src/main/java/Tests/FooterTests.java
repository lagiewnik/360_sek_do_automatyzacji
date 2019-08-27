package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class FooterTests extends DefaultTest // Location parrameter: absolute xpath, cssSelector;
{
    @Test(priority = 1)
    public void openDashboardPageTest()
    {
        driver.findElement(By.xpath("/html/body/footer/span[1]/a")).click();

        Assert.assertTrue(driver.findElement(By.xpath("/html/body/footer/span[2]/a")).isDisplayed());
    }

    @Test(priority = 2)
    public void openRegulationsPageTest()
    {
        WebElement footerRegulations = driver.findElement(By.cssSelector("#footer_static > span:nth-child(2) > a"));

        footerRegulations.click();

        assertEquals(driver.getCurrentUrl(), "http://demo.testarena.pl/regulamin");
    }
}
