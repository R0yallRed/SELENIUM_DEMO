package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class InputFormsPage extends BasePage {

    public InputFormsPage(WebDriver webDriver) {
        super(webDriver);
    }

    private final By firstName = By.xpath("//input[@name = 'first_name']");
    private final By lastName = By.xpath("//input[@name = 'last_name']");
    private final By email = By.xpath("//input[@name = 'email']");
    private final By phone = By.xpath("//input[@name = 'phone']");
    private final By address = By.xpath("//input[@name = 'address']");
    private final By city = By.xpath("//input[@name = 'city']");
    private final By state = By.xpath("//select[@name = 'state']");
    private final By zip = By.xpath("//input[@name = 'zip']");
    private final By website = By.xpath("//input[@name = 'website']");
    private final By buttonYes = By.xpath("//input[@value= 'yes']");
    private final By description = By.xpath("//textarea[@name = 'comment']");
    private final By send = By.xpath("//button[text() ='Send ']");


    @Step
    public InputFormsPage enterFirstName(String newFirstName) {
        webDriver.findElement(firstName).sendKeys(newFirstName);
        return  this;
    }
    @Step
    public InputFormsPage enterLastName(String newLastName) {
        webDriver.findElement(lastName).sendKeys(newLastName);
        return  this;
    }
    @Step
    public InputFormsPage enterEmail(String newEmail) {
        webDriver.findElement(email).sendKeys(newEmail);
        return  this;
    }
    @Step
    public InputFormsPage enterPhone(String newPhone) {
        webDriver.findElement(phone).sendKeys(newPhone);
        return  this;
    }
    @Step
    public InputFormsPage enterAddress(String newAddress) {
        webDriver.findElement(address).sendKeys(newAddress);
        return  this;
    }
    @Step
    public InputFormsPage enterCity(String newCity) {
        webDriver.findElement(city).sendKeys(newCity);
        return  this;
    }
    @Step
    public InputFormsPage chooseState(int stateIndex) {
        WebElement stateChooser = webDriver.findElement(state);
        Select selectState = new Select(stateChooser);
        selectState.selectByIndex(stateIndex);
        return  this;
    }
    @Step
    public InputFormsPage enterZip(String newZip) {
        webDriver.findElement(zip).sendKeys(newZip);
        return  this;
    }
    @Step
    public InputFormsPage enterWebsite(String newWebsite) {
        webDriver.findElement(website).sendKeys(newWebsite);
        return  this;
    }
    @Step
    public InputFormsPage enterButtonYes() {
        webDriver.findElement(buttonYes).click();
        return  this;
    }
    @Step
    public InputFormsPage enterDescription(String newDescription) {
        webDriver.findElement(description).sendKeys(newDescription);
        return  this;
    }
    @Step
    public void clickSend() {
        webDriver.findElement(send).click();
    }
}



