import com.seleniumEasy.ListBoxPage;
import com.seleniumEasy.SubmitFormPage;
import org.junit.jupiter.api.*;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MediumDifficultyTests extends BaseUITest {


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


/*
            List<WebElement> elementName = driver.findElements(By.LocatorStrategy("LocatorValue"));

            // new WebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));

    Вам нужно создать ArrayList с элементами типа WebElement - засадить туда функцию драйвера findelements, так как она возвращает ArrayList.
        Потом вы просто манипулируете элементами списка, в цикле для каждого елемента ставите свои проверки, цикл естественно будет идти от 0 до размера списка найденных элементов.

        ArrayList <WebElement> list = new ArrayList <WebElements>();
        list = findElement(By.cssSelector("div.SAInfo div i.sex"));

        for (int i=0;i<list.size();i++){
// проверки для каждого элемента отдельно: list.get(i) - вернет і-тый элемент списка всех элементов

----------------
Мне когда то нужно было посчитать количество строк в таблице. Я сделал это так:
int recordsCount = driver.FindElement(By.Id("id_tb")).FindElements(By.TagName("tr")).Count;
----------------
Сделал проще, без всякого цикла

List<WebElement> list = wd.findElements(By.cssSelector("div.SAInfo div i.sex"));
assertThat(12, equalTo(list.size()));
----------------
Если Вам нужно только количество элементов, почему не сделать так:

int i = wd.findElements(By.cssSelector("div.SAInfo div i.sex")).Count;
        }*/
