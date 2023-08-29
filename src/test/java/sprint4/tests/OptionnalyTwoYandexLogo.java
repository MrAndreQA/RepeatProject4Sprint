package sprint4.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sprint4.pom.HeaderPage;
import sprint4.pom.HomePageScooter;
import sprint4.pom.TrackOrderPage;

import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static sprint4.pom.HomePageScooter.MAIN_PAGE;

public class OptionnalyTwoYandexLogo {
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
    public void check_If_clickTo_YandexLogo_OpensYandexMainPage_InNewTab() throws InterruptedException {
        HomePageScooter objHomePage = new HomePageScooter(driver);
        // fetch all windows before clicking on new window link.
        Set<String> windowHandles = driver.getWindowHandles();
        objHomePage.openMainPage();

        HeaderPage objHeaderPage = new HeaderPage(driver);
        objHeaderPage.clickToStatusOrder();
        objHeaderPage.setTrackAndClickGoButton("123");

        TrackOrderPage objTrackOrder = new TrackOrderPage(driver);
        objTrackOrder.waitSeeButton();

        // Click on link to open new window
        objHeaderPage.clickToYandexLogo();
        Thread.sleep(5000);



        Set<String> updatedWindowHandles = driver.getWindowHandles();
        updatedWindowHandles.removeAll(windowHandles);
        for (String window : updatedWindowHandles) {
            driver.switchTo().window(window);

            assertEquals("https://dzen.ru/?yredirect=true", driver.getCurrentUrl());
        }    }
}