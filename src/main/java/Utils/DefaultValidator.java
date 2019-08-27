package Utils;

import Tests.DefaultTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class DefaultValidator
{
    public static boolean isElementPresent(By locatorKey)
    {
        try
        {
            DefaultTest.driver.findElement(locatorKey);
            return true;
        }
        catch (NoSuchElementException e)
        {
            return false;
        }
    }

    public static void changeLanguageToPl()
    {
        WebElement languageIcon = DefaultTest.driver.findElement(By.xpath("/html/body/footer/span[5]/a/img"));

        if (isElementPresent(By.xpath("/html/body/footer/span[5]/a/img")));
        {
            if (languageIcon.getAttribute("alt").equals("polski"))
            {
                languageIcon.click();
            }
        }
    }
}
