import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver webDriver = null;

    @BeforeTest
    @Parameters({"browser"})
    public void setUp(String browser){

        if(browser.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", ".//drivers//geckodriver.exe");
            webDriver = new FirefoxDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
            webDriver = new ChromeDriver();
        }

        webDriver.manage().window().fullscreen();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(5,TimeUnit.SECONDS);

    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.close();
        webDriver.quit();
    }

    public void goTo(String url){
        webDriver.get(url);
    }
}
