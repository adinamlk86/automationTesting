package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends PageBase {

    protected By textLocator = By.xpath("//*[text()='Welcome to the-internet']");
    protected By selectPageLocator = By.xpath("//*[text()='Dropdown']");
    protected By loginPageLocator = By.xpath("//*[text()='Form Authentication']");
    protected By forgotPasswordPageLocator = By.xpath("//*[text()='Forgot Password']");
    protected By checkboxesPageLocator = By.xpath("//*[text()='Checkboxes']");
    protected By inputsPageLocator = By.xpath("//*[text()='Inputs']");

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkIfPageIsLoaded() {
        super.checkIfPageIsLoaded(textLocator, "Initial page was not loaded");
    }

    public void goToSelectPage() {
        webDriver.findElement(selectPageLocator).click();
    }

    public void goToLoginPage() {
        webDriver.findElement(loginPageLocator).click();
    }

    public void goToForgotPasswordPage() {
        webDriver.findElement(forgotPasswordPageLocator).click();
    }

    public void goToCheckboxesPage() {
        webDriver.findElement(checkboxesPageLocator).click();
    }

    public void goToInputsPage(){
        webDriver.findElement(inputsPageLocator).click();
    }


}
