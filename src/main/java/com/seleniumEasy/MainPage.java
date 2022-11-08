package com.seleniumEasy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {


    private final WebDriver webDriver;

    private final By intermediateFormsButton =  By.xpath("//span[@class='round-tabs three']");
    private final By inputFormWithValidations = By.xpath("//div[@class = 'tab-pane fade active in']/*[4] /*[1] ");
    private final By submitForm = By.xpath("//div[@class = 'tab-pane fade active in']/*[4] /*[2] ");
    private final By dropdownSelect = By.xpath("//div[@class = 'tab-pane fade active in']/*[4] /*[3] ");
    private final By dualListBoxSelect = By.xpath("//div[@class = 'tab-pane fade active in']/*[4] /*[4] ");



    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickIntermediateButton(){
        webDriver.findElement(intermediateFormsButton).click();

    }

    public  InputFormsPage clickInputForm(){
        webDriver.findElement(inputFormWithValidations).click();
        return new InputFormsPage(webDriver);
    }

    public  SubmitFormPage clickSubmitFormButton(){
        webDriver.findElement(submitForm).click();
        return  new SubmitFormPage(webDriver);
    }

    public SelectDropdownPage clickSelectDropdown() {
        webDriver.findElement(dropdownSelect).click();
        return new SelectDropdownPage(webDriver);
    }

    public void clickSelectDualListBox() {
        webDriver.findElement(dualListBoxSelect).click();
       // return new ListBoxPage(webDriver);
    }
}
