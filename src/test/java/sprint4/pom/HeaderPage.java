package sprint4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderPage {
    private WebDriver driver;

    public HeaderPage(WebDriver driver) {this.driver = driver;}

    private By statusOrder = By.xpath(".//*[@class='Header_Link__1TAG7']");
    private By trackField = By.xpath(".//input[@class='Input_Input__1iN_Z Header_Input__xIoUq']");
    private By goButton = By.xpath(".//button[@class='Button_Button__ra12g Header_Button__28dPO']");

    private By yandexLogo = By.xpath(".//img[@alt='Yandex']");
    private By scooterLogo = By.xpath(".//img[@alt='Scooter']");

    public static final By UP_ORDER_BUTTON = By.xpath(".//*[@class='Button_Button__ra12g']");

    public void clickUpOrderButton() {
        driver.findElement(UP_ORDER_BUTTON).click();
    }

    public void clickToStatusOrder() {
        driver.findElement(statusOrder).click();
    }
    public void setTrackAndClickGoButton(String trackNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(trackField));
        driver.findElement(trackField).sendKeys(trackNumber);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(goButton));
        driver.findElement(goButton).click();
    }
    public void clickToScooterLogo() {
        driver.findElement(scooterLogo).click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(scooterLogo));
    }
    public void clickToYandexLogo() {
        driver.findElement(yandexLogo).click();
    }
}