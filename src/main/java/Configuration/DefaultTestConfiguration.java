package Configuration;

import Tests.DefaultTest;
import Utils.DefaultValidator;
import org.openqa.selenium.By;

public class DefaultTestConfiguration extends DefaultTest
{
    public static void logOut()
    {
        if (DefaultValidator.isElementPresent(By.className("icons-switch")))
        {
            driver.findElement(By.className("icons-switch")).click();
        }
    }
}
