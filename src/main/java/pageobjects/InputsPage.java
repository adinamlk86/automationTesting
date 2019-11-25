package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class InputsPage extends PageBase {

    protected By textLocator = By.xpath("//*[text()='Inputs']");
    protected By inputBoxLocator = By.xpath("//*[@id='content']//input");

    public InputsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkIfPageIsLoaded() {
        super.checkIfPageIsLoaded(textLocator, "Inputs page did not load");
    }

    public void inputNumber(String number) {
        webDriver.findElement(inputBoxLocator).sendKeys(number);
    }

    public void clearInputBox() {
        webDriver.findElement(inputBoxLocator).clear();
    }

}
