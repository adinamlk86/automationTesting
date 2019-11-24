package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends PageBase {

    protected By textLocator = By.xpath("//*[text()='Login Page']");
    protected By username = By.id("username");
    protected By password = By.id("password");
    protected By loginButton = By.xpath("//button");
    protected By errorLocator = By.xpath("//*[@class='flash error']");

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkIfPageIsLoaded() {
        super.checkIfPageIsLoaded(textLocator, "Login page was not loaded");
    }

    public void enterCredentials(String user, String pass) {
        webDriver.findElement(username).sendKeys(user);
        webDriver.findElement(password).sendKeys(pass);
        webDriver.findElement(loginButton).click();
    }

    public void checkLoginError() {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);

        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(errorLocator));
        } catch (Exception e) {
            System.out.print(e.getMessage());
            Assert.assertTrue(1 == 2, "Error is not present");
        }

    }
}
