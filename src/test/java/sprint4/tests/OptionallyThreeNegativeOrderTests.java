package sprint4.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sprint4.pom.HeaderPage;
import sprint4.pom.HomePageScooter;
import sprint4.pom.MakeOrderPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OptionallyThreeNegativeOrderTests extends MakeOrderPage {
    private WebDriver driver;
    @Before
    public void setUp() {
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        //driver = new EdgeDriver();
    }
    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkNullClientNameInOrder() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.openMainPage();

        HeaderPage objHeaderPage = new HeaderPage(driver);
        objHeaderPage.clickUpOrderButton();

        MakeOrderPage objMakeOrder = new MakeOrderPage(driver);
        objMakeOrder.completeFirstOrderPage("", "Горбунков", "Бульвар Рандеву, 27", metroStationCherkizovskaya, "89991234567");

        assertTrue(driver.findElement(nameInputError).isDisplayed());
        String expectedNameErrorMessage = "Введите корректное имя";
        assertEquals(expectedNameErrorMessage, driver.findElement(nameInputError).getText());
    }
    @Test
    public void checkShortClientNameInOrder() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.openMainPage();

        HeaderPage objHeaderPage = new HeaderPage(driver);
        objHeaderPage.clickUpOrderButton();

        MakeOrderPage objMakeOrder = new MakeOrderPage(driver);
        objMakeOrder.completeFirstOrderPage("К", "Горбунков", "Бульвар Рандеву, 27", metroStationCherkizovskaya, "89991234567");

        assertTrue(driver.findElement(nameInputError).isDisplayed());
        String expectedNameErrorMessage = "Введите корректное имя";
        assertEquals(expectedNameErrorMessage, driver.findElement(nameInputError).getText());
    }
    @Test
    public void checkLongClientNameInOrder() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.openMainPage();

        HeaderPage objHeaderPage = new HeaderPage(driver);
        objHeaderPage.clickUpOrderButton();

        MakeOrderPage objMakeOrder = new MakeOrderPage(driver);
        objMakeOrder.completeFirstOrderPage("Иммануиловоимечк", "Горбунков", "Бульвар Рандеву, 27", metroStationCherkizovskaya, "89991234567");

        assertTrue(driver.findElement(nameInputError).isDisplayed());
        String expectedNameErrorMessage = "Введите корректное имя";
        assertEquals(expectedNameErrorMessage, driver.findElement(nameInputError).getText());
    }
    @Test
    public void checkEngClientNameInOrder() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.openMainPage();

        HeaderPage objHeaderPage = new HeaderPage(driver);
        objHeaderPage.clickUpOrderButton();

        MakeOrderPage objMakeOrder = new MakeOrderPage(driver);
        objMakeOrder.completeFirstOrderPage("John", "Горбунков", "Бульвар Рандеву, 27", metroStationCherkizovskaya, "89991234567");

        assertTrue(driver.findElement(nameInputError).isDisplayed());
        String expectedNameErrorMessage = "Введите корректное имя";
        assertEquals(expectedNameErrorMessage, driver.findElement(nameInputError).getText());
    }
    @Test
    public void checkNullClientSurnameInOrder() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.openMainPage();

        HeaderPage objHeaderPage = new HeaderPage(driver);
        objHeaderPage.clickUpOrderButton();

        MakeOrderPage objMakeOrder = new MakeOrderPage(driver);
        objMakeOrder.completeFirstOrderPage("Игорь", "", "Бульвар Рандеву, 27", metroStationCherkizovskaya, "89991234567");

        assertTrue(driver.findElement(surnameInputError).isDisplayed());
        String expectedSurnameErrorMessage = "Введите корректную фамилию";
        assertEquals(expectedSurnameErrorMessage, driver.findElement(surnameInputError).getText());
    }
    @Test
    public void checkShortClientSurnameInOrder() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.openMainPage();

        HeaderPage objHeaderPage = new HeaderPage(driver);
        objHeaderPage.clickUpOrderButton();

        MakeOrderPage objMakeOrder = new MakeOrderPage(driver);
        objMakeOrder.completeFirstOrderPage("Игорь", "Ф", "Бульвар Рандеву, 27", metroStationCherkizovskaya, "89991234567");

        assertTrue(driver.findElement(surnameInputError).isDisplayed());
        String expectedSurnameErrorMessage = "Введите корректную фамилию";
        assertEquals(expectedSurnameErrorMessage, driver.findElement(surnameInputError).getText());
    }

    @Test
    public void checkEngClientSurnameInOrder() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.openMainPage();

        HeaderPage objHeaderPage = new HeaderPage(driver);
        objHeaderPage.clickUpOrderButton();

        MakeOrderPage objMakeOrder = new MakeOrderPage(driver);
        objMakeOrder.completeFirstOrderPage("Игорь", "Williams", "Бульвар Рандеву, 27", metroStationCherkizovskaya, "89991234567");

        assertTrue(driver.findElement(surnameInputError).isDisplayed());
        String expectedSurnameErrorMessage = "Введите корректную фамилию";
        assertEquals(expectedSurnameErrorMessage, driver.findElement(surnameInputError).getText());
    }

    //Фамилия клиента на русском языке - без ограничений колличества символов на фронте
    // Адрес является не обязательным на фронте. Колличество символов и их вид - не делал тесты.


    @Test
    public void checkNullMetroStationInOrder() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.openMainPage();

        HeaderPage objHeaderPage = new HeaderPage(driver);
        objHeaderPage.clickUpOrderButton();

        MakeOrderPage objMakeOrder = new MakeOrderPage(driver);

        objMakeOrder.completeFirstOrderPageWithoutStation("Игорь", "Николаев", "Бульвар Рандеву, 27", "89991234567");

        assertTrue(driver.findElement(metroStationInputError).isDisplayed());
        String expectedSurnameErrorMessage = "Выберите станцию";
        assertEquals(expectedSurnameErrorMessage, driver.findElement(metroStationInputError).getText());
    }
    @Test
    public void checkNullTelephoneInOrder() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.openMainPage();

        HeaderPage objHeaderPage = new HeaderPage(driver);
        objHeaderPage.clickUpOrderButton();

        MakeOrderPage objMakeOrder = new MakeOrderPage(driver);

        objMakeOrder.completeFirstOrderPage("Игорь", "Николаев", "Бульвар Рандеву, 27", metroStationCherkizovskaya, "");

        assertTrue(driver.findElement(telephoneInputError).isDisplayed());
        String expectedSurnameErrorMessage = "Введите корректный номер";
        assertEquals(expectedSurnameErrorMessage, driver.findElement(telephoneInputError).getText());
    }
    @Test
    public void checkShortTelephoneInOrder() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.openMainPage();

        HeaderPage objHeaderPage = new HeaderPage(driver);
        objHeaderPage.clickUpOrderButton();

        MakeOrderPage objMakeOrder = new MakeOrderPage(driver);

        objMakeOrder.completeFirstOrderPage("Игорь", "Николаев", "Бульвар Рандеву, 27", metroStationCherkizovskaya, "89882");

        assertTrue(driver.findElement(telephoneInputError).isDisplayed());
        String expectedSurnameErrorMessage = "Введите корректный номер";
        assertEquals(expectedSurnameErrorMessage, driver.findElement(telephoneInputError).getText());
    }
    @Test
    public void checkLongTelephoneInOrder() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.openMainPage();

        HeaderPage objHeaderPage = new HeaderPage(driver);
        objHeaderPage.clickUpOrderButton();

        MakeOrderPage objMakeOrder = new MakeOrderPage(driver);

        objMakeOrder.completeFirstOrderPage("Игорь", "Николаев", "Бульвар Рандеву, 27", metroStationCherkizovskaya, "84991234567890");

        assertTrue(driver.findElement(telephoneInputError).isDisplayed());
        String expectedSurnameErrorMessage = "Введите корректный номер";
        assertEquals(expectedSurnameErrorMessage, driver.findElement(telephoneInputError).getText());
    }

    // Дата доставки и срок аренды - обязательные поля. Ошибки не отображаются. Кнопка Заказать тупо не отрабатывает.
    // Комментарий не обязательный и можно ввести любые символы и их колличество
    // Цвет самоката - необязательное, можно выбрать 0,1,2 цвета.

}