package tests.medium;

import pages.ListBoxPage;
import pages.SubmitFormPage;
import org.junit.jupiter.api.*;
import tests.base.BaseTest;

import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MediumDifficultyTests extends BaseTest {


    @BeforeEach
    public void chooseIntermediateDifficulty() {
        mainPage.clickIntermediateButton();
    }

    @Test
    @DisplayName("Input form positiveTest")
    @Order(1)
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
    @Order(2)
    public void submitFormPositiveTest() {
        SubmitFormPage submitFormPage = mainPage.clickSubmitFormButton()
                .enterName(faker.name().name())
                .enterComment(randomAlphabetic(20))
                .clickSubmit();

        assertAll(

                () -> assertTrue(submitFormPage.resultIsDisplayed()),
                () -> assertThat(submitFormPage.resultText(), equalTo("Ajax Request is Processing!")),
                () -> Thread.sleep(1500),
                () -> assertThat(submitFormPage.resultText(), equalTo("Form submited Successfully!"))
        );

    }

    @Test
    @DisplayName("Dropdown selection forms positive Test")
    @Order(3)
    public void dropdownFormsPositiveTest() {
        mainPage.clickSelectDropdown()
                .selectCountry((int) (Math.random() * 10))
                .selectStateMulti((int) (Math.random() * 50), (int) (Math.random() * 50))
                .selectWithDisabledValues()
                .selectWithCategoryOptions();
    }

    @Test
    @DisplayName("Dual List Box positive Test")
    @Order(4)
    public void dualListBoxPositiveTest() {
        ListBoxPage listBoxPage =
                mainPage.clickSelectDualListBox()
                        .selectAndMoveAllFromLeftBox()
                        .selectAndMoveAllFromRightBox()
                        .deselectAllFromLeftBox()
                        .moveUsingSearchLeftBox();

    }
}
