package pages.mainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.basePage.BasePage;
import pages.medium.InputFormsPage;
import pages.medium.ListBoxPage;
import pages.medium.SelectDropdownPage;
import pages.medium.SubmitFormPage;

public class MainPage extends BasePage {

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    private final By intermediateFormsButton =  By.xpath("//span[@class='round-tabs three']");
    private final By easyFormsButton =  By.xpath("//span[@class='round-tabs two']");
    private final By inputFormWithValidations = By.xpath("//div[@class = 'tab-pane fade active in']/*[4] /*[1] ");
    private final By submitForm = By.xpath("//div[@class = 'tab-pane fade active in']/*[4] /*[2] ");
    private final By dropdownSelect = By.xpath("//div[@class = 'tab-pane fade active in']/*[4] /*[3] ");
    private final By dualListBoxSelect = By.xpath("//div[@class = 'tab-pane fade active in']/*[4] /*[4] ");
    private final By simpleForm = By.xpath("//div[@id= 'basic']/*[4]/*[1]");





    public void clickIntermediateButton(){
        webDriver.findElement(intermediateFormsButton).click();

    }

    public InputFormsPage clickInputForm(){
        webDriver.findElement(inputFormWithValidations).click();
        return new InputFormsPage(webDriver);
    }

    public SubmitFormPage clickSubmitFormButton(){
        webDriver.findElement(submitForm).click();
        return  new SubmitFormPage(webDriver);
    }

    public SelectDropdownPage clickSelectDropdown() {
        waitElementIsVisible(webDriver.findElement(dropdownSelect));
        webDriver.findElement(dropdownSelect).click();
        return new SelectDropdownPage(webDriver);
    }

    public ListBoxPage clickSelectDualListBox() {
        webDriver.findElement(dualListBoxSelect).click();
        return  new ListBoxPage(webDriver);
    }

    public void clickEasyButton() {
        webDriver.findElement(easyFormsButton).click();
    }
    public void clickSimpleForm() {
        webDriver.findElement(simpleForm).click();
       // return  new SimpleFormPage(webDriver);
    }
}
