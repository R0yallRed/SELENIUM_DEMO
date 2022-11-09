package tests.base;

import com.github.javafaker.Faker;
import common.CommonActions;
import org.junit.jupiter.api.TestInstance;
import pages.BasePage;
import pages.ListBoxPage;
import pages.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.WebStorage;

import static common.Config.CLEAR_COOKIES;
import static common.Config.HOLD_BROWSER_OPEN;
import static constants.Constant.Urls.MAIN_PAGE_URL;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {


    protected static WebDriver webDriver = CommonActions.createDriver();
    protected MainPage mainPage = new MainPage(webDriver);
    // protected BasePage basePage = new BasePage(webDriver);
   // protected ListBoxPage listBoxPage = new ListBoxPage(webDriver);

    public static Faker faker;

    @BeforeAll
    public static void setUp() {
        //webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        webDriver.get(MAIN_PAGE_URL);
        faker = Faker.instance();
    }

    @AfterEach
    public void clearCookiesAndGoToMainPage(){
        if (CLEAR_COOKIES){
            webDriver.manage().deleteAllCookies();
            ((WebStorage) webDriver).getSessionStorage().clear();
            ((WebStorage) webDriver).getLocalStorage().clear();
        }
        webDriver.get(MAIN_PAGE_URL);
    }

    @AfterAll
    public static void quit() {
        if (!HOLD_BROWSER_OPEN){
            webDriver.quit();
        }
    }
}
