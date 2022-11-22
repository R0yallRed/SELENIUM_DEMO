package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import pages.Easy.SimpleFormPage;
import pages.medium.SubmitFormPage;
import org.junit.jupiter.api.*;
import tests.base.BaseTest;

import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class SeleniumEasyTests extends BaseTest {

    @BeforeEach
    public void chooseIntermediateDifficulty() {
        mainPage.clickIntermediateButton();
    }

    @Test
    @DisplayName("Input form positiveTest")
    @Epic(value = "Intermediate forms")
    @Feature(value = "Input form")
    public void inputFormWithValidationsPositiveTest() {
        mainPage.clickInputForm()
                .enterFirstName(faker.name().firstName())
                .enterLastName(faker.name().lastName())
                .enterEmail(faker.name().firstName() + "@gmail.com")
                .enterPhone(faker.phoneNumber().subscriberNumber(10))
                .enterAddress(faker.address().fullAddress())
                .enterCity(faker.address().city())
                .chooseState((int) (Math.random() * 50))
                .enterZip(randomNumeric(4, 6))
                .enterWebsite(randomAlphabetic(8) + ".com")
                .enterButtonYes()
                .enterDescription(randomAlphabetic(15))
                .clickSend();
    }

    @Test
    @DisplayName("Submit form positive Test")
    @Epic(value = "Intermediate forms")
    @Feature(value = "Submit form")
    public void submitFormPositiveTest() {
        SubmitFormPage submitFormPage = mainPage.clickSubmitFormButton()
                .enterName(faker.name().name())
                .enterComment(randomAlphabetic(20))
                .clickSubmit();

        assertAll(

                () -> assertTrue(submitFormPage.resultIsDisplayed()),
                () -> assertThat(submitFormPage.resultText(), equalTo("Ajax Request is Processing!")),
                () -> assertTrue(submitFormPage.elementChangedText("Form submited Successfully!"))
        );
    }

    @Test
    @DisplayName("Dropdown selection forms positive Test")
    @Epic(value = "Intermediate forms")
    @Feature(value = "Dropdown selection form")
    public void dropdownFormsPositiveTest() {
        mainPage.clickSelectDropdown()
                .selectCountry((int) (Math.random() * 10))
                .selectStateMulti((int) (Math.random() * 50), (int) (Math.random() * 50))
                .selectWithDisabledValues()
                .selectWithCategoryOptions();
    }

    @Test
    @DisplayName("Dual List Box positive Test")
    public void dualListBoxPositiveTest() {
        mainPage.clickSelectDualListBox()
                .selectAndMoveAllFromLeftBox()
                .selectAndMoveAllFromRightBox()
                .deselectAllFromLeftBox()
                .moveUsingSearchLeftBox();

    }

    @Test
    @DisplayName("Simple form test INTENTIONALLY BROKEN FOR SCREENSHOT")
    @Epic(value = "Basic forms")
    @Feature(value = "Input calculation form")
    public void inputFormCalculation() {
        mainPage.clickEasyButton();
        mainPage.clickSimpleForm();
        SimpleFormPage simpleFormPage = new SimpleFormPage(webDriver);
        String message = faker.harryPotter().character();
        simpleFormPage.enterMessage(message);
        String returnedMessage = simpleFormPage.getReturnedText();
        assertEquals(message, returnedMessage);
        simpleFormPage.EnterNumbers(randomNumeric(1, 3), randomNumeric(1, 3));
        String returnedSum = simpleFormPage.getReturnedSum();
        assertEquals(returnedSum, randomNumeric(1, 3));
    }

    @Test
    @DisplayName("Drag and drop grey slider")
    @Epic(value = "Advanced forms")
    @Feature(value = "Input calculation form")
    public void DragAndDropGreySlider() {
        mainPage.clickHardButton();
        mainPage.clickDragAndDropSliders()
                .moveGreySlider();
    }
}

