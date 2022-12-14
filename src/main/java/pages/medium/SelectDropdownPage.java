package pages.medium;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.basePage.BasePage;

import static constants.Constant.timeoutVariables.EXPLICIT_WAIT;

public class SelectDropdownPage extends BasePage {

    public SelectDropdownPage(WebDriver webDriver) {
        super(webDriver);
    }

    private final By selectCountryButton = By.xpath("//span[@class='select2-selection select2-selection--single']");
    private final By countriesList = By.xpath("//select[@id = 'country']");
    private final By selectStateMultiSearchField = By.xpath("//input[@class= 'select2-search__field']");
    private final By selectStateMultiDropDown = By.xpath("//select[@class= 'js-example-basic-multiple select2-hidden-accessible']");
    private final By outlyingTerritories = By.xpath("//select[@class='js-example-disabled-results select2-hidden-accessible']");
    private final By file = By.id("files");


    @Step
    public SelectDropdownPage selectCountry(int index) {
        waitElementIsVisible(webDriver.findElement(selectCountryButton));
        webDriver.findElement(selectCountryButton).click();
        waitElementIsVisible(webDriver.findElement(countriesList));
        WebElement countyChooser = webDriver.findElement(countriesList);
       waitElementIsVisible(countyChooser);
        Select selectCountry = new Select(countyChooser);
        selectCountry.selectByIndex(index);
        webDriver.findElement(selectCountryButton).click();
        return this;
    }

    @Step
    public SelectDropdownPage selectStateMulti(int index, int index2) {
        webDriver.findElement(selectStateMultiSearchField).click();
        WebElement stateChooser = webDriver.findElement(selectStateMultiDropDown);
        Select selectCountry = new Select(stateChooser);
        selectCountry.selectByIndex(index);
        webDriver.findElement(selectStateMultiSearchField).click();
        selectCountry.selectByIndex(index2);
        return this;
    }

    @Step
    public SelectDropdownPage selectWithDisabledValues() {
        WebElement territoryChooser = webDriver.findElement(outlyingTerritories);
        Select selectTerritory = new Select(territoryChooser);
        selectTerritory.selectByIndex(3);
        return this;
    }

    @Step
    public void selectWithCategoryOptions() {
        WebElement fileChooser = webDriver.findElement(file);
        Select chooseFile = new Select(fileChooser);
        chooseFile.selectByIndex(2);
    }

}



