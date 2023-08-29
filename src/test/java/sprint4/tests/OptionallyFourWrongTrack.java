package sprint4.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sprint4.pom.HeaderPage;
import sprint4.pom.HomePageScooter;
import sprint4.pom.TrackOrderPage;
import static org.junit.Assert.assertTrue;
import static sprint4.pom.TrackOrderPage.IMG_NOT_FOUND;

public class OptionallyFourWrongTrack {
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
    public void findOrder_WithWrongTrack_ExpectNotFound() {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.openMainPage();

        HeaderPage objHeaderPage = new HeaderPage(driver);
        objHeaderPage.clickToStatusOrder();
        objHeaderPage.setTrackAndClickGoButton("123");

        TrackOrderPage objTrackOrder = new TrackOrderPage(driver);
        objTrackOrder.waitSeeButton();

        assertTrue(driver.findElement(IMG_NOT_FOUND).isDisplayed());
    }
}