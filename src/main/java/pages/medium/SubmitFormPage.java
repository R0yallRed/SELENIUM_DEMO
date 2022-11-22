package pages.medium;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.basePage.BasePage;

import static constants.Constant.timeoutVariables.EXPLICIT_WAIT;

public class SubmitFormPage extends BasePage {
    public SubmitFormPage(WebDriver webDriver) {
        super(webDriver);
    }

    private final By name = By.id("title");
    private final By comment = By.id("description");
    private final By submitButton = By.id("btn-submit");
    private final By submitText = By.id("submit-control");

    @Step
    public SubmitFormPage enterName(String newName) {
        webDriver.findElement(name).sendKeys(newName);
        return this;
    }

    @Step
    public SubmitFormPage enterComment(String newComment) {
        webDriver.findElement(comment).sendKeys(newComment);
        return this;
    }

    @Step
    public SubmitFormPage clickSubmit() {
        webDriver.findElement(submitButton).click();
        return this;
    }

    public boolean resultIsDisplayed() {
        return webDriver.findElement(submitText).isDisplayed();
    }

    public String resultText() {
        return webDriver.findElement(submitText).getText();
    }

    public boolean elementChangedText(String newText) {
        return new WebDriverWait(webDriver, EXPLICIT_WAIT).until(ExpectedConditions.textToBePresentInElement(webDriver.findElement(submitText), newText));

    }
}
