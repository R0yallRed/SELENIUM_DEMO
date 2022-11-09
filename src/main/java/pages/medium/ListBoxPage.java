package pages.medium;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.basePage.BasePage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;

public class ListBoxPage extends BasePage {

    public ListBoxPage(WebDriver webDriver) {
        super(webDriver);
    }

    private final By searchFieldLeft = By.xpath("//div[@class= 'well text-right']/*[1]/*[1]/*[1]/*[2]");
    private final By selectAllLeft = By.xpath("//div[@class= 'well text-right']/*[1]/*[2]/*[1]/*[1]");
    private final By arrowLeft = By.xpath("//button[@class = 'btn btn-default btn-sm move-left']");
    private final By listLeft = By.xpath("//div[@class= 'well text-right']/*[2]/*");

    private final By listLeftFirstItem = By.xpath("//div[@class= 'well text-right']/*[2]/*[1]");
    private final By listLeftLastItem = By.xpath("//div[@class= 'well text-right']/*[2]/*[last()]");
    private final By searchFieldRight = By.xpath("//div[@class= 'dual-list list-right col-md-5']/*[1]/*[1]/*[2]/*[1]/*[1]");
    private final By selectAllRight = By.xpath("//div[@class= 'dual-list list-right col-md-5']/*[1]/*[1]/*[1]/*[1]/*[1]");
    private final By arrowRight = By.xpath("//button[@class = 'btn btn-default btn-sm move-right']");
    private final By listRight = By.xpath("//div[@class = 'dual-list list-right col-md-5']/*[1]/*[2]/*");
    private final String nthLeftElement = "//div[@class= 'well text-right']/*[2]/*[";
    private final String nthRightElement = "//div[@class = 'dual-list list-right col-md-5']/*[1]/*[2]/*[";


    public int getListLeftCount() {
        List<WebElement> leftListElements = webDriver.findElements(listLeft);
        return leftListElements.size();
    }

    public int getListRightCount() {
        List<WebElement> rightListElements = webDriver.findElements(listRight);
        return rightListElements.size();
    }

    @Step
    public ListBoxPage selectAndMoveAllFromLeftBox() {
        List<WebElement> leftListElements = webDriver.findElements(listLeft);
        for (int i = 1; i <= leftListElements.size(); i++) {
            webDriver.findElement(By.xpath(nthLeftElement + i + "]")).click();
        }
        clickArrowRight();
        List<WebElement> newLeftListElements = webDriver.findElements(listLeft);
        assertTrue(newLeftListElements.isEmpty());
        return this;
    }

    @Step
    public ListBoxPage selectAndMoveAllFromRightBox() {
        List<WebElement> rightListElements = webDriver.findElements(listRight);
        String uncheckedItemClassName = "list-group-item";

        for (int i = 1; i <= rightListElements.size(); i++) {
            String className = webDriver.findElement(By.xpath(nthRightElement + i + "]")).getAttribute("class");
            if (className.equals(uncheckedItemClassName)) {
                webDriver.findElement(By.xpath(nthRightElement + i + "]")).click();
            }
        }
        clickArrowLeft();
        //assert
        List<WebElement> newRightListElements = webDriver.findElements(listRight);
        assertTrue(newRightListElements.isEmpty());
        return this;
    }

    @Step
    public ListBoxPage deselectAllFromLeftBox() {
        List<WebElement> leftListElements = webDriver.findElements(listLeft);
        String checkedItemClassName = "list-group-item active";

        for (int i = 1; i <= leftListElements.size(); i++) {
            String className = webDriver.findElement(By.xpath(nthLeftElement + i + "]")).getAttribute("class");
            if (className.equals(checkedItemClassName)) {
                webDriver.findElement(By.xpath(nthLeftElement + i + "]")).click();
            }
        }
        return this;
    }

    @Step
    public void clickArrowRight() {
        webDriver.findElement(arrowRight).click();

    }

    @Step
    public void clickArrowLeft() {
        webDriver.findElement(arrowLeft).click();

    }


    @Step
    public ListBoxPage moveUsingSearchLeftBox() {
        webDriver.findElement(searchFieldLeft).click();
        //first element
        String firstItem = webDriver.findElement(listLeftFirstItem).getText();
        webDriver.findElement(searchFieldLeft).sendKeys(firstItem);
        webDriver.findElement(listLeftFirstItem).click();
        webDriver.findElement(searchFieldLeft).clear();
        clickArrowRight();
        webDriver.findElement(searchFieldLeft).sendKeys(Keys.ENTER);
        //last element
        String lastItem = webDriver.findElement(listLeftLastItem).getText();
        webDriver.findElement(searchFieldLeft).sendKeys(lastItem);
        webDriver.findElement(listLeftLastItem).click();
        webDriver.findElement(searchFieldLeft).clear();
        clickArrowRight();
        webDriver.findElement(searchFieldLeft).sendKeys(Keys.ENTER);

        List<WebElement> rightListElements = webDriver.findElements(listRight);
        List<WebElement> leftListElements = webDriver.findElements(listLeft);


        assertAll(
                () -> assertTrue(rightListElements.stream().anyMatch(x -> firstItem.equals(x.getText()))),
                () -> assertTrue(rightListElements.stream().anyMatch(x -> lastItem.equals(x.getText()))),
                () -> assertTrue(leftListElements.stream().noneMatch(x -> firstItem.equals(x.getText()))),
                () -> assertTrue(leftListElements.stream().anyMatch(x -> lastItem.equals(x.getText())))
        );
        return this;
    }
}

 /* import static org.assertj.core.api.Assertions;

        Assertions.assertThat(myClass.getMyItems())
                .hasSize(2)
                .extracting(MyItem::getName)
                .containsExactlyInAnyOrder("foo", "bar");*/


//List<WebElement> visibleElements = webDriver.findElements(listLeft);
//assertThat();

