import com.github.javafaker.Faker;
import com.seleniumEasy.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.WebStorage;

import java.util.concurrent.TimeUnit;

public class BaseUITest {
    protected static WebDriver webDriver;
    static MainPage mainPage;
    static Faker faker;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        webDriver.get("https://demo.seleniumeasy.com/");
        mainPage =new MainPage(webDriver);
        faker = Faker.instance();
    }

    @AfterEach
    public void goToMainPage(){
        webDriver.manage().deleteAllCookies();
        ((WebStorage) webDriver).getSessionStorage().clear();
        ((WebStorage) webDriver).getLocalStorage().clear();
        webDriver.get("https://demo.seleniumeasy.com/");
    }

    @AfterAll
    public static void quit() {
        webDriver.quit();
    }
}
