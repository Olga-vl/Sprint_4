package ru.yandex.praktikum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckOrder {
    WebDriver driver;
    MainPage mainPage;
    OrderPage orderPage;

    @BeforeClass
    public static void setupAll() {
        WebDriverManager.firefoxdriver().setup();
    }

    @Before
    public void setup() {
        driver = new FirefoxDriver();

        mainPage = new MainPage(driver);
        mainPage.openPage();
    }

    @Test
    public void checkButtonOrder(){
        mainPage.prepareScrollToOrderButton();
        mainPage.clickOrderMiddlePage();
        orderPage = new OrderPage(driver);
        orderPage.checkHeadTextVisible();
    }

    @Test
    public void checkE2EOrder(){
        mainPage.clickOrderHeader();
        orderPage = new OrderPage(driver);

        orderPage.setInputFirstName();
        orderPage.setInputLastName();
        orderPage.setInputAddress();
        orderPage.setInputMetro();
        orderPage.setInputPhone();
        orderPage.clickNextButton();

        orderPage.checkHeadTextVisible();
        orderPage.setInputDate();
        orderPage.setRentalPeriod();
        orderPage.setInputColor();
        orderPage.setCourierDescription();
        orderPage.clickCompleteButton();

        orderPage.checkConfirmOrderText();
        orderPage.clickYesButton();
        orderPage.checkHeadCompleteVisible();

    }

    @After
    public void teardown() {
        driver.quit();
    }
}
