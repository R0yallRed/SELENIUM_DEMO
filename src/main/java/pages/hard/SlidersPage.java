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

    public By getGreySliderPath() {
        return greySliderPath;
    }

    private final By greySliderPath = By.xpath("//div[@class='range']/*[1]");
    public static final By greyValue = By.xpath("//div[@class='range']/*[2]");
    public  WebElement greySlider = webDriver.findElement(greySliderPath);

    public String getGreyValue() {
        return webDriver.findElement(greyValue).getText();
    }

    public void moveGreySlider() {
        Actions action = new Actions(webDriver);
        String initialValue = getGreyValue();
        double randomMoveLeft = Math.random() * 50;
        double randomMoveRight = Math.random() * -50;
        action.dragAndDropBy(greySlider, (int) randomMoveLeft, 0).perform();
        String firstValue = getGreyValue();
        Assertions.assertNotEquals("Values must NOT be equal", initialValue, firstValue);
        action.dragAndDropBy(greySlider, (int) randomMoveRight, 0).perform();
        String secondValue = getGreyValue();
        Assertions.assertNotEquals("Values must NOT be equal", firstValue, secondValue);
        action.dragAndDropBy(greySlider, (int) randomMoveLeft, 0).perform();
        action.dragAndDropBy(greySlider, (int) randomMoveRight, 0).perform();
    }

}



