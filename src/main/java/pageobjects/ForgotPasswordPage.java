package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends PageBase {

    protected By textLocator = By.xpath("//*[text()='Forgot Password']");
    protected By emailLocator = By.id("email");
    protected By buttonLocator = By.xpath("//button");

    public ForgotPasswordPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkIfPageIsLoaded() {
        super.checkIfPageIsLoaded(textLocator, "Forgot Password page did not load");
    }

    public void enterEmail(String email) {
        webDriver.findElement(emailLocator).sendKeys(email);
        webDriver.findElement(buttonLocator).click();
    }
}
