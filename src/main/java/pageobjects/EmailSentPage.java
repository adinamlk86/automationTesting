package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailSentPage extends PageBase {

    protected By textLocator = By.id("content");

    public EmailSentPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkIfPageIsLoaded() {
        super.checkIfPageIsLoaded(textLocator, "Email Sent page did not load");
    }
}
