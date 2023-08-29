package sprint4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TrackOrderPage {
    private WebDriver driver;
    public TrackOrderPage(WebDriver driver) {this.driver = driver;}
    private By seeButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    public static final By IMG_NOT_FOUND = By.xpath(".//div[@class='Track_NotFound__6oaoY']");

    public void waitSeeButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(seeButton));
    }
}