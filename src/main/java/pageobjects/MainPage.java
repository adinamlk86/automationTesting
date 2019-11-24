package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends PageBase {
    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    protected By textLocator = By.xpath("//*[text()='Welcome to the-internet']");
    protected By selectPageLocator = By.xpath("//*[text()='Dropdown']");
    protected By loginPageLocator = By.xpath("//*[text()='Form Authentication']");

    public void checkIfPageIsLoaded() {
        super.checkIfPageIsLoaded(textLocator, "Initial page was not loaded");
    }

    public void goToSelectPage() {
        webDriver.findElement(selectPageLocator).click();
    }

    public void goToLoginPage() {
        webDriver.findElement(loginPageLocator).click();
    }

}
