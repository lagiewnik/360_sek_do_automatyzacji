package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RecoveryPasswordTests extends DefaultTest // Location parrameter: linkText, partialLinkText;
{
    @Test(priority = 1)
    public void openRecoveryPasswordPageTest()
    {
        driver.findElement(By.linkText("Nie pamiętam hasła")).click();

        assertEquals(driver.getTitle(),"Odzyskaj hasło - TestArena Demo");
    }
}