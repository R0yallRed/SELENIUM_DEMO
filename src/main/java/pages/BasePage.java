package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static constants.Constant.timeoutVariables.EXPLICIT_WAIT;

public class BasePage {
    protected final WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void goToUrl(String url){
        webDriver.get(url);
    }

    public void waitElementIsVisible (WebElement webElement){
        new WebDriverWait(webDriver,EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(webElement));
    }

}
