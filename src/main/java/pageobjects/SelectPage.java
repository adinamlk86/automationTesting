package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SelectPage extends PageBase {

    protected By textLocator = By.xpath("//*[text()='Dropdown List']");
    protected By selectLocator = By.id("dropdown");

    public SelectPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkIfPageIsLoaded() {
        super.checkIfPageIsLoaded(textLocator, "Select page was not loaded");
    }

    public void selectByVisibleText(String selectText, String assertText) {

        Select select = new Select(webDriver.findElement(selectLocator));
        System.out.println("Selecting by visible text");

        select.selectByVisibleText(selectText);
        Assert.assertEquals(select.getAllSelectedOptions().get(0).getText(), assertText);
    }

    public void selectByIndex(int index, String assertText) {
        Select select = new Select(webDriver.findElement(selectLocator));
        System.out.println("Selecting by index");

        select.selectByIndex(index);
        Assert.assertEquals(select.getAllSelectedOptions().get(0).getText(), assertText);
    }

    public void selectByValue(String selectValue, String assertText) {
        Select select = new Select(webDriver.findElement(selectLocator));
        System.out.println("Selecting by value");

        select.selectByValue(selectValue);
        Assert.assertEquals(select.getAllSelectedOptions().get(0).getText(), assertText);
    }

}
