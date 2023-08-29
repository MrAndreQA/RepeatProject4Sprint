package sprint4.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageScooter {
    private WebDriver driver;
    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }
    public HomePageScooter() { }

    public static final String MAIN_PAGE = "https://qa-scooter.praktikum-services.ru/";
    private By downOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']");
    public static final By DOWN_ORDER_BUTTON_1 = By.xpath("/html/body/div/div/div/div[4]/div[2]/div[5]/button");

    protected static By question1 = By.xpath(".//div[@id = 'accordion__heading-0']");
    protected static By question2 = By.xpath(".//div[@id = 'accordion__heading-1']");
    protected static By question3 = By.xpath(".//div[@id = 'accordion__heading-2']");
    protected static By question4 = By.xpath(".//div[@id = 'accordion__heading-3']");
    protected static By question5 = By.xpath(".//div[@id = 'accordion__heading-4']");
    protected static By question6 = By.xpath(".//div[@id = 'accordion__heading-5']");
    protected static By question7 = By.xpath(".//div[@id = 'accordion__heading-6']");
    protected static By question8 = By.xpath(".//div[@id = 'accordion__heading-7']");
    protected static By answer1 = By.xpath(".//div[@id = 'accordion__panel-0']/p");
    protected static By answer2 = By.xpath(".//div[@id = 'accordion__panel-1']");
    protected static By answer3 = By.xpath(".//div[@id = 'accordion__panel-2']");
    protected static By answer4 = By.xpath(".//div[@id = 'accordion__panel-3']");
    protected static By answer5 = By.xpath(".//div[@id = 'accordion__panel-4']");
    protected static By answer6 = By.xpath(".//div[@id = 'accordion__panel-5']");
    protected static By answer7 = By.xpath(".//div[@id = 'accordion__panel-6']");
    protected static By answer8 = By.xpath(".//div[@id = 'accordion__panel-7']/p");

    public void openMainPage(){driver.get(MAIN_PAGE);}
    public void clickToQuestion(By question) {
        driver.findElement(question).click();
    }
    public String getTextInAnswer(By answer) {
        return driver.findElement(answer).getText();
    }
    public void clickDownOrderButton() {
        driver.findElement(DOWN_ORDER_BUTTON_1).click();
    }

}