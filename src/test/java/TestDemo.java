import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.*;

public class TestDemo extends TestBase {

    MainPage mainPage;
    SelectPage selectPage;
    LoginPage loginPage;
    SecureAreaPage secureAreaPage;
    ForgotPasswordPage forgotPasswordPage;
    EmailSentPage emailSentPage;
    CheckboxesPage checkboxesPage;
    InputsPage inputsPage;

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

    @Test
    @Parameters({"email"})
    public void forgotPasswordTest(String email) {
        mainPage = new MainPage(webDriver);
        goTo("http://the-internet.herokuapp.com/");

        mainPage.checkIfPageIsLoaded();
        mainPage.goToForgotPasswordPage();

        forgotPasswordPage = new ForgotPasswordPage(webDriver);
        forgotPasswordPage.checkIfPageIsLoaded();
        forgotPasswordPage.enterEmail(email);

        emailSentPage = new EmailSentPage(webDriver);
        emailSentPage.checkIfPageIsLoaded();

        webDriver.navigate().back();
        webDriver.navigate().back();
        mainPage.checkIfPageIsLoaded();
    }

    @Test
    public void checkboxesTest() {
        mainPage = new MainPage(webDriver);
        goTo("http://the-internet.herokuapp.com/");
        mainPage.checkIfPageIsLoaded();
        mainPage.goToCheckboxesPage();

        checkboxesPage = new CheckboxesPage(webDriver);
        checkboxesPage.checkIfPageIsLoaded();
        checkboxesPage.checkBoxes();
        checkboxesPage.unCheckBoxes();

        webDriver.navigate().back();
    }

    @Test
    public void inputsTest() throws InterruptedException {
        mainPage = new MainPage(webDriver);
        goTo("http://the-internet.herokuapp.com/");
        mainPage.checkIfPageIsLoaded();
        mainPage.goToInputsPage();

        inputsPage = new InputsPage(webDriver);
        inputsPage.checkIfPageIsLoaded();
        inputsPage.inputNumber("12345");
        System.out.println("Number was written in box.");
        Thread.sleep(2000);
        inputsPage.clearInputBox();
        inputsPage.inputNumber("abcd");
        System.out.println("Letters were not written in box");
        Thread.sleep(2000);
        inputsPage.clearInputBox();
        inputsPage.inputNumber("eeeee");
        System.out.println("Letter 'e' may be written in box. Possible site bug");
        Thread.sleep(2000);
        inputsPage.clearInputBox();

        webDriver.navigate().back();
    }

}
