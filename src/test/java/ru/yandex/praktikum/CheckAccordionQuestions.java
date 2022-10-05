package ru.yandex.praktikum;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckAccordionQuestions {
    WebDriver driver;
    MainPage mainPage;

    @BeforeClass
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();

        mainPage = new MainPage(driver);
        mainPage.openPage();
        mainPage.prepareScrollToQuestions();

    }

    @Test
    public void checkPrice() {
        String expectedText = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";

        mainPage.clickAccordionPriceHeader();
        String actualText = mainPage.getAccordionPriceBodyText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void checkSeveralScooters() {
        String expectedText = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями," +
                " можете просто сделать несколько заказов — один за другим.";
        mainPage.clickAccordionSeveralScootersHeader();

        String actualText = mainPage.getAccordionSeveralScootersBodyText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void checkCalculationTime() {
        String expectedText = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня." +
                " Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру." +
                " Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        mainPage.clickAccordionCalculationTimeHeader();

        String actualText = mainPage.getAccordionCalculationTimeBodyText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void checkOrderToday() {
        String expectedText = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        mainPage.clickAccordionOrderTodayHeader();

        String actualText = mainPage.getAccordionOrderTodayBodyText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void checkExtendOrder() {
        String expectedText = "Пока что нет! Но если что-то срочное —" +
                " всегда можно позвонить в поддержку по красивому номеру 1010.";
        mainPage.clickAccordionExtendOrderHeader();

        String actualText = mainPage.getAccordionExtendOrderBodyText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void checkCharging() {
        String expectedText = "Самокат приезжает к вам с полной зарядкой." +
                " Этого хватает на восемь суток — даже если будете кататься без передышек и во сне." +
                " Зарядка не понадобится.";
        mainPage.clickAccordionChargingHeader();

        String actualText = mainPage.getAccordionChargingBodyText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void checkCanselOrder() {
        String expectedText = "Да, пока самокат не привезли. Штрафа не будет," +
                " объяснительной записки тоже не попросим. Все же свои.";
        mainPage.clickAccordionCanselOrderHeader();

        String actualText = mainPage.getAccordionCanselOrderBodyText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void checkLive() {
        String expectedText = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        mainPage.clickAccordionLiveHeader();

        String actualText = mainPage.getAccordionLiveBodyText();
        Assert.assertEquals(expectedText, actualText);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
