package Tests;

import Configuration.DefaultTestConfiguration;
import Configuration.DefaultTestData;
import Utils.DefaultValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTests extends DefaultTest // Location parrameter: id, name, className, relative xpath;
{
    private WebElement emailField, passwordField, loginButton;
    DefaultTestData defaultTestData = new DefaultTestData();

    @BeforeMethod
    public void setUp()
    {
        DefaultValidator.changeLanguageToPl();

        // emailField = driver.findElement(By.id("email"));

        emailField = driver.findElement(By.cssSelector("#email")); //css
        passwordField = driver.findElement(By.xpath("//*[@id=\"text-2\"] / div / form / div[3] / span / input"));
        loginButton = driver.findElement(By.name("login"));
    }

    @AfterMethod
    public void tearDown()
    {
        DefaultTestConfiguration.logOut();
    }

    @Test(priority = 1)
    public void successLoginWithDataTest()
    {
        emailField.sendKeys(defaultTestData.adminLogin);
        passwordField.sendKeys(defaultTestData.adminPassword);

        loginButton.click();

        assertEquals(driver.getTitle(), defaultTestData.defaultTitle);
    }

    @Test(priority = 2)
    public void failedLoginWithoutDataTest()
    {
        loginButton.click();

        assertEquals(driver.findElement(By.className("login_form_error")).getText(), "Pole wymagane");
    }

    @Test(priority = 3)
    public void failedLoginWithFilledAndClearedDataTest()
    {
        emailField.sendKeys("administrator@testarena.pl");
        emailField.clear();

        passwordField.sendKeys("sumXQQ72$L");
        passwordField.clear();

        loginButton.click();

        assertEquals(driver.findElement(By.className("login_form_error")).getText(), "Pole wymagane");
    }
}