package pages.Easy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.basePage.BasePage;

public class SimpleFormPage extends BasePage {

    public SimpleFormPage(WebDriver webDriver) {
        super(webDriver);
    }

    private final By enterMessageField = By.xpath("//form[@id= 'get-input']/*[1]/*[2]");
    private final By showMessageButton = By.xpath("//form[@id= 'get-input']/*[2]");
    private final By savedMessage = By.xpath("//span[@id ='display']");
    private final By aValue = By.id("sum1");
    private final By bValue = By.id("sum2");
    private final By getTotalButton = By.xpath("//button[text() = \"Get Total\"]");
    private final By totalResult = By.xpath("//span[@id ='displayvalue']");

    public void enterMessage(String message) {
        webDriver.findElement(enterMessageField).sendKeys(message);
        webDriver.findElement(showMessageButton).click();
        System.out.println(webDriver.findElement(savedMessage).getText());
    }

    public String getReturnedText() {
        return webDriver.findElement(savedMessage).getText();
    }


    public void EnterNumbers(String a, String b) {
        webDriver.findElement(aValue).sendKeys(a);
        webDriver.findElement(bValue).sendKeys(b);
        webDriver.findElement(getTotalButton).click();
    }

    public String getReturnedSum() {
        return webDriver.findElement(totalResult).getText();
    }
}

