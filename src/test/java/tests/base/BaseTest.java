package tests.base;

import com.github.javafaker.Faker;
import common.CommonActions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.mainPage.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.WebStorage;

import java.io.File;
import java.net.MalformedURLException;
import java.time.LocalTime;
import java.util.Objects;

import static common.Config.*;
import static constants.Constant.Urls.MAIN_PAGE_URL;

@ExtendWith(Listener.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected static WebDriver webDriver;

    static {
        try {
            webDriver = CommonActions.createDriver();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    protected MainPage mainPage = new MainPage(webDriver);
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);
    public static Faker faker;


    private static void CleanOldStuff() {
        LOGGER.info("START TIME" + LocalTime.now());
        LOGGER.info("START clear reports dir:: build/reports/test");
        File allureResults = new File("target/allure-results");
        if (allureResults.isDirectory()) {
            for (File item : Objects.requireNonNull(allureResults.listFiles()))
                item.delete();
        }
        if (CLEAR_REPORTS_DIR) {
            File allureScreenshots = new File("build/reports/tests");
            if (allureScreenshots.isDirectory()) {
                for (File item : Objects.requireNonNull(allureScreenshots.listFiles()))
                    item.delete();
            }
        }
    }

    @BeforeAll
    public static void setUp() {
        if (!BROWSER_AND_PLATFORM.equals("REMOTE")){
            CleanOldStuff();
        }
        faker = Faker.instance();
    }

    @BeforeEach
    public void goToMainPage() {
        webDriver.get(MAIN_PAGE_URL);
    }

    @AfterEach
    public void clearCookies() {
        if (CLEAR_COOKIES && !BROWSER_AND_PLATFORM.equals("REMOTE") ) {
            webDriver.manage().deleteAllCookies();
            ((WebStorage) webDriver).getSessionStorage().clear();
            ((WebStorage) webDriver).getLocalStorage().clear();
        }

    }

    @AfterAll
    public static void quit() {
        if (!HOLD_BROWSER_OPEN) {
            webDriver.quit();
        }
    }
}
