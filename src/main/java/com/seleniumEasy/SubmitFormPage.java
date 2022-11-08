package com.seleniumEasy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubmitFormPage {
    private final WebDriver webDriver;

    public SubmitFormPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private final By name = By.id("title");
    private final By comment = By.id("description");
    private final By submitButton = By.id("btn-submit");
    private final By submitText = By.id("submit-control");

    public  SubmitFormPage enterName(String newName){
        webDriver.findElement(name).sendKeys(newName);
        return  this;
    }

    public  SubmitFormPage enterComment(String newComment){
        webDriver.findElement(comment).sendKeys(newComment);
        return  this;
    }
    public  SubmitFormPage clickSubmit( ){
        webDriver.findElement(submitButton).click();
        return  this;
    }

    public  boolean resultIsDisplayed( ){
        return webDriver.findElement(submitText).isDisplayed();
    }
    public  String resultText( ){
        return webDriver.findElement(submitText).getText();
    }
}
