package sprint4.tests;

import sprint4.pom.HeaderPage;
import sprint4.pom.HomePageScooter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import sprint4.pom.MakeOrderPage;

import static org.hamcrest.CoreMatchers.containsString;
import static sprint4.pom.HomePageScooter.DOWN_ORDER_BUTTON_1;


public class MakeOrderTests extends MakeOrderPage {
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
    public void createOrderWithUpButtonAndBlackScooter() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.openMainPage();

        HeaderPage objHeaderPage = new HeaderPage(driver);
        objHeaderPage.clickUpOrderButton();

        MakeOrderPage objMakeOrder = new MakeOrderPage(driver);
        objMakeOrder.completeFirstOrderPage("Семён", "Горбунков", "Бульвар Рандеву, 27", metroStationCherkizovskaya, "89991234567");
        objMakeOrder.completeSecondOrderPage("14.07.2023", rentTime2Days, blackColor, "Семён заказал черный самокатик");

        String actualTextInOrder = driver.findElement(orderMakedModal).getText();
        String expectedTextInOrder = "Заказ оформлен";

        Assert.assertThat(actualTextInOrder, containsString(expectedTextInOrder));
    }

    @Test
    public void createOrderWithDownButtonAndGreyScooter() {
        HomePageScooter objHomePage = new HomePageScooter(driver);

        objHomePage.openMainPage();
        WebElement element = driver.findElement(DOWN_ORDER_BUTTON_1);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        objHomePage.clickDownOrderButton();

        MakeOrderPage objMakeOrder = new MakeOrderPage(driver);
        objMakeOrder.completeFirstOrderPage("Игорь", "Николаев", "Светланская, 54", metroStationRedGates, "89882427819");
        objMakeOrder.completeSecondOrderPage("14.07.2023", rentTime5Days, greyColor, "Игьрь заказал серый самокатик");

        String actualTextInOrder = driver.findElement(orderMakedModal).getText();
        String expectedTextInOrder = "Заказ оформлен";

        Assert.assertThat(actualTextInOrder, containsString(expectedTextInOrder));
    }
}
