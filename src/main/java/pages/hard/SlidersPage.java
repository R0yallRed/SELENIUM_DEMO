package pages.hard;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.basePage.BasePage;


public class SlidersPage extends BasePage {
    public SlidersPage(WebDriver webDriver) {
        super(webDriver);
    }

    private final By greySliderPath = By.xpath("//div[@class='range']/*[1]");
    private final By greyValue = By.xpath("//div[@class='range']/*[2]");
    public WebElement greySlider = webDriver.findElement(greySliderPath);

    private final By blueSliderPath = By.xpath("//div[@class='range range-primary']/*[1]");
    private final By blueValue = By.xpath("//div[@class='range range-primary']/*[2]");
    public WebElement blueSlider = webDriver.findElement(blueSliderPath);


    public String getGreyValue() {
        return webDriver.findElement(greyValue).getText();
    }
    public String getBlueValue() {
        return webDriver.findElement(blueValue).getText();
    }

    public SlidersPage moveGreySlider() {
        Actions action = new Actions(webDriver);
        String initialValue = getGreyValue();
        action.dragAndDropBy(greySlider, 30, 0).perform();
        String firstValue = getGreyValue();
        Assertions.assertNotEquals("Values must NOT be equal", initialValue, firstValue);
        action.dragAndDropBy(greySlider, -50, 0).perform();
        String secondValue = getGreyValue();
        Assertions.assertNotEquals("Values must NOT be equal", firstValue, secondValue);
        action.dragAndDropBy(greySlider, 70, 0).perform();
        action.dragAndDropBy(greySlider, -150, 0).perform();
        return  this;
    }


    public SlidersPage moveBlueSlider() {
        Actions action = new Actions(webDriver);
        String initialValue = getBlueValue();
        action.dragAndDropBy(blueSlider, 30, 0).perform();
        String firstValue = getGreyValue();
        Assertions.assertNotEquals("Values must NOT be equal", initialValue, firstValue);
        action.dragAndDropBy(blueSlider, -50, 0).perform();
        String secondValue = getGreyValue();
        Assertions.assertNotEquals("Values must NOT be equal", firstValue, secondValue);
        action.dragAndDropBy(blueSlider, 70, 0).perform();
        action.dragAndDropBy(blueSlider, -150, 0).perform();
        return  this;
    }

}



