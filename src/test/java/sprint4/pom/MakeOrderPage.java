package sprint4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MakeOrderPage {
    private WebDriver driver;
    public MakeOrderPage(WebDriver driver) {
        this.driver = driver;
    }
    public MakeOrderPage() {
    }

    protected By name = By.xpath(".//input[@placeholder= '* Имя']");
    protected By surname = By.xpath(".//input[@placeholder= '* Фамилия']");
    protected By address = By.xpath(".//input[@placeholder= '* Адрес: куда привезти заказ']");
    protected By selectFieldMetroStation = By.xpath(".//input[@placeholder= '* Станция метро']");
    protected By metroStationField = By.xpath(".//*[@class='select-search__input']");
    protected By metroStationRokosovsky = By.xpath(".//*[@class='select-search__row' and @data-index='0']");
    protected By metroStationCherkizovskaya = By.xpath(".//div[@class='Order_Text__2broi' and text()='Черкизовская']");
    protected By metroStationRedGates = By.xpath(".//*[@class='select-search__row' and @data-index='6']");
    protected By telephone = By.xpath(".//input[@placeholder= '* Телефон: на него позвонит курьер']");

    protected By nextButton = By.xpath(".//button[@class= 'Button_Button__ra12g Button_Middle__1CSJM']");

    protected By deliveryDate = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    protected By rentTime = By.xpath(".//div[@class='Dropdown-control']");
    protected By rentTime2Days = By.xpath(".//div[@class='Dropdown-option' and text() = 'двое суток']");
    protected By rentTime5Days = By.xpath(".//div[@class='Dropdown-option' and text() = 'пятеро суток']");

    protected By blackColor = By.xpath(".//input[@id='black']");
    protected By greyColor = By.xpath(".//input[@id='grey']");
    protected By comment = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");

    protected By backButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i']");
    protected By makeOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    protected By confirmOrderModal = By.xpath(".//div[@class='Order_Modal__YZ-d3']");
    protected By yesInConfirmOrderModal = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    protected By noInConfirmOrderModal = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i' and text()='Назад']");

    protected By orderMakedModal = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

    protected By seeStatusButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()= 'Посмотреть статус']");

    protected By nameInputError = By.xpath(".//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6']");
    protected By surnameInputError = By.xpath(".//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6']");
    protected By metroStationInputError = By.xpath(".//div[@class='Order_MetroError__1BtZb']");
    protected By telephoneInputError = By.xpath(".//div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6']");

    public void setName(String clientName) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(name));
        driver.findElement(name).sendKeys(clientName);
    }
    public void setSurname(String clientSurname) {
        driver.findElement(surname).sendKeys(clientSurname);
    }
    public void setAddress(String clientAddress) {
        driver.findElement(address).sendKeys(clientAddress);
    }
    public void setMetroStation(By station){
        driver.findElement(selectFieldMetroStation).click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(metroStationField));
        driver.findElement(station).click();
    }
    public void setTelephone(String clientTelephone) {
        driver.findElement(telephone).sendKeys(clientTelephone);
    }
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
    public void setDeliveryDate(String delivery) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(deliveryDate));
        driver.findElement(deliveryDate).sendKeys(delivery);
        driver.findElement(By.xpath(".//div[@class = 'Order_Header__BZXOb' and text() = 'Про аренду']")).click();
    }
    public void setRentTime (By rent) {
        driver.findElement(rentTime).click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(rentTime2Days));
        driver.findElement(rent).click();
    }
    public void setColor(By color) {
        driver.findElement(color).click();
    }
    public void setComment(String comments) {
        driver.findElement(comment).sendKeys(comments);
    }
    public void clickMakeOrderButton() {
        driver.findElement(makeOrderButton).click();
    }
    public void confirmOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(confirmOrderModal));
        driver.findElement(yesInConfirmOrderModal).click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(orderMakedModal));
    }
    public void completeFirstOrderPage(String clientName, String clientSurname, String clientAddress,By station, String clientTelephone) {
        setName(clientName);
        setSurname(clientSurname);
        setAddress(clientAddress);
        setMetroStation(station);
        setTelephone(clientTelephone);
        clickNextButton();
    }
    public void completeFirstOrderPageWithoutStation(String clientName, String clientSurname, String clientAddress, String clientTelephone) {
        setName(clientName);
        setSurname(clientSurname);
        setAddress(clientAddress);
        setTelephone(clientTelephone);
        clickNextButton();
    }

    public void completeSecondOrderPage(String delivery, By rent,By color, String comments) {
        setDeliveryDate(delivery);
        setRentTime(rent);
        setColor(color);
        setComment(comments);
        clickMakeOrderButton();
        confirmOrder();
    }
}