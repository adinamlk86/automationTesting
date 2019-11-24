import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import pageobjects.MainPage;
import pageobjects.SecureAreaPage;
import pageobjects.SelectPage;

public class TestDemo extends TestBase {

    MainPage mainPage;
    SelectPage selectPage;
    LoginPage loginPage;
    SecureAreaPage secureAreaPage;

    @Test
    public void Test() {

        mainPage = new MainPage(webDriver);

        goTo("http://the-internet.herokuapp.com/");

        mainPage.checkIfPageIsLoaded();
        mainPage.goToSelectPage();

        selectPage = new SelectPage(webDriver);
        selectPage.checkIfPageIsLoaded();

        selectPage.selectByVisibleText("Option 1", "Option 1");
        selectPage.selectByIndex(2, "Option 2");
        selectPage.selectByValue("1", "Option 1");

        webDriver.navigate().back();
        mainPage.goToLoginPage();

        loginPage = new LoginPage(webDriver);
        loginPage.checkIfPageIsLoaded();

        loginPage.enterCredentials("tomsmith", "SuperSecretPassword!");

        secureAreaPage = new SecureAreaPage(webDriver);
        secureAreaPage.checkIfPageIsLoaded();

        webDriver.navigate().back();

        loginPage.checkIfPageIsLoaded();
        loginPage.enterCredentials("tomsmith", "daiuhfuehd");

        loginPage.checkLoginError();
    }

    @Test
    public void selectTest() {
        mainPage = new MainPage(webDriver);

        goTo("http://the-internet.herokuapp.com/");

        mainPage.checkIfPageIsLoaded();
        mainPage.goToSelectPage();

        selectPage = new SelectPage(webDriver);
        selectPage.checkIfPageIsLoaded();

        selectPage.selectByVisibleText("Option 1", "Option 1");
        selectPage.selectByIndex(2, "Option 2");
        selectPage.selectByValue("1", "Option 1");

        webDriver.navigate().back();
    }

    @Test
    @Parameters({"username", "password"})
    public void loginSuccessfulTest(String username, String password) {
        mainPage = new MainPage(webDriver);

        goTo("http://the-internet.herokuapp.com/");

        mainPage.checkIfPageIsLoaded();
        mainPage.goToLoginPage();

        loginPage = new LoginPage(webDriver);
        loginPage.checkIfPageIsLoaded();

        loginPage.enterCredentials(username, password);

        secureAreaPage = new SecureAreaPage(webDriver);
        secureAreaPage.checkIfPageIsLoaded();

        webDriver.navigate().back();
    }

    @Test
    @Parameters({"username", "password"})
    public void loginFailedTest(String username, String password) {
        mainPage = new MainPage(webDriver);

        goTo("http://the-internet.herokuapp.com/");

        mainPage.checkIfPageIsLoaded();
        mainPage.goToLoginPage();
        loginPage = new LoginPage(webDriver);
        loginPage.checkIfPageIsLoaded();
        loginPage.enterCredentials(username, password);

        loginPage.checkLoginError();
    }
}
