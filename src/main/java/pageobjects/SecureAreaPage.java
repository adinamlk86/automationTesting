package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends PageBase {
    protected By textLocator = By.xpath("//*[contains(text(),'Secure Area')]");

    public SecureAreaPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkIfPageIsLoaded() {
        super.checkIfPageIsLoaded(textLocator, "Secure area page was loaded");
    }
}
