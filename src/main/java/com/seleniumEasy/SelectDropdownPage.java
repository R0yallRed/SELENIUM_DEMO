package com.seleniumEasy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdownPage {
    private final WebDriver webDriver;

    public SelectDropdownPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private final By selectCountryButton = By.xpath("//span[@class='select2-selection select2-selection--single']");
    private final By countriesList = By.id("country");
    private final By selectStateMultiSearchField = By.xpath("//input[@class= 'select2-search__field']");
    private final By selectStateMultiDropDown = By.xpath("//select[@class= 'js-example-basic-multiple select2-hidden-accessible']");
    private final By outlyingTerritories = By.xpath("//select[@class='js-example-disabled-results select2-hidden-accessible']");
    private final By file = By.id("files");


    public SelectDropdownPage selectCountry(int index) {
        webDriver.findElement(selectCountryButton).click();
        WebElement countyChooser = webDriver.findElement(countriesList);
        Select selectCountry = new Select(countyChooser);
        selectCountry.selectByIndex(index);
        webDriver.findElement(selectCountryButton).click();
        return this;
    }

    public SelectDropdownPage selectStateMulti(int index, int index2) {
        webDriver.findElement(selectStateMultiSearchField).click();
        WebElement stateChooser = webDriver.findElement(selectStateMultiDropDown);
        Select selectCountry = new Select(stateChooser);
        selectCountry.selectByIndex(index);
        webDriver.findElement(selectStateMultiSearchField).click();
        selectCountry.selectByIndex(index2);
        return this;
    }

    public SelectDropdownPage selectWithDisabledValues() {
        WebElement territoryChooser = webDriver.findElement(outlyingTerritories);
        Select selectTerritory = new Select(territoryChooser);
        selectTerritory.selectByIndex(3);
        return this;
    }

    public SelectDropdownPage selectWithCategoryOptions() {
        WebElement fileChooser = webDriver.findElement(file);
        Select chooseFile = new Select(fileChooser);
        chooseFile.selectByIndex(2);
        return this;
    }

}



