package sprint4.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sprint4.pom.HomePageScooter;
import java.time.Duration;
import static org.junit.Assert.assertEquals;
import static sprint4.pom.HeaderPage.UP_ORDER_BUTTON;

@RunWith(Parameterized.class)
public class CheckAnswers extends HomePageScooter {
    private WebDriver driver;
    private final By question;
    private final By answer;
    private final String textAnswer;
    private final boolean IsTextMatch;

    public CheckAnswers(By question, By answer, String textAnswer, boolean isTextMatch) {
        this.question = question;
        this.answer = answer;
        this.textAnswer = textAnswer;
        IsTextMatch = isTextMatch;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
            {question1, answer1, "Сутки — 400 рублей. Оплата курьеру — наличными или картой.", true },
            {question2, answer2, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", true},
            {question3, answer3, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", true},
            {question4, answer4, "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", true},
            {question5, answer5, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", true},
            {question6,answer6, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", true},
            {question7, answer7, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", true},
            {question8, answer8, "Да, обязательно. Всем самокатов! И Москве, и Московской области.", true},
        };
    }

   @Before
    public void setUp() {
       driver = new ChromeDriver();
       //driver = new FirefoxDriver();
       //driver = new EdgeDriver();
    }

    @After
    public void tearDown() { driver.quit();}

    @Test
    public void checkQuestionsAndAnswers() {

        HomePageScooter objHomePage = new HomePageScooter(driver);
        objHomePage.openMainPage();

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(UP_ORDER_BUTTON));
        WebElement element = driver.findElement(question4);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);


        objHomePage.clickToQuestion(question);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(answer));
        String actualText = objHomePage.getTextInAnswer(answer);
        System.out.println("Актуальный текст: " + actualText);
        System.out.println("Текст по ТЗ: " + textAnswer);

        assertEquals(IsTextMatch, actualText.equals(textAnswer));
    }
}