package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckboxesPage extends PageBase {

    protected By textLocator = By.xpath("//*[text()='Checkboxes']");
    protected By checkboxOne = By.xpath("//*[@id='checkboxes']/input[1]");
    protected By checkboxTwo = By.xpath("//*[@id='checkboxes']/input[2]");

    public CheckboxesPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkIfPageIsLoaded() {
        super.checkIfPageIsLoaded(textLocator, "Checkboxes page did not load");
    }

    public void checkBoxes() {
        webDriver.findElement(checkboxOne).click();
        System.out.println("First box checked.");
        webDriver.findElement(checkboxTwo).click();
        System.out.println("Second box checked.");
    }

    public void unCheckBoxes(){
        webDriver.findElement(checkboxOne).click();
        System.out.println("First box unchecked.");
        webDriver.findElement(checkboxTwo).click();
        System.out.println("Second box unchecked.");
    }
}
