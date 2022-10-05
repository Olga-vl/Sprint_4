package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    public static final String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    //Кнопка заказать из шапки страницы
    private final By BUTTON_ORDER_HEADER = By.xpath("//div[@class = 'Header_Nav__AGCXC']/child::button[text() = 'Заказать']");

    //Кнопка заказать из середины страницы
    private final By BUTTON_ORDER_MIDDLE = By.xpath("//div[@class = 'Home_FinishButton__1_cWm']/child::button");

    //Заголовки аккордеона
    private final By ACCORDION_PRICE_HEADER = By.xpath("//div[contains(text(), 'Сколько это')]");
    private final By ACCORDION_SEVERAL_SCOOTERS_HEADER = By.xpath("//div[contains(text(), 'Хочу')]");
    private final By ACCORDION_CALCULATION_TIME_HEADER = By.xpath("//div[contains(text(), 'Как рассчитывается')]");
    private final By ACCORDION_ORDER_TODAY_HEADER = By.xpath("//div[contains(text(), 'Можно ли заказать')]");
    private final By ACCORDION_EXTEND_ORDER_HEADER = By.xpath("//div[contains(text(), 'Можно ли продлить')]");
    private final By ACCORDION_CHARGING_HEADER = By.xpath("//div[contains(text(), 'Вы привозите')]");
    private final By ACCORDION_CANSEL_ORDER_HEADER = By.xpath("//div[contains(text(), 'отменить заказ')]");
    //TODO Исправить дефект на сайте жизу -> живу
    private final By ACCORDION_LIVE_HEADER = By.xpath("//div[contains(text(), 'Я жизу')]");

    //Содержимое аккордеона
    private final By ACCORDION_PRICE_BODY = By.xpath("//p[contains(text(), 'Сутки')]");
    private final By ACCORDION_SEVERAL_SCOOTERS_BODY = By.xpath("//p[contains(text(), 'один заказ')]");
    private final By ACCORDION_CALCULATION_TIME_BODY = By.xpath("//p[contains(text(), 'Мы привозим')]");
    private final By ACCORDION_ORDER_TODAY_BODY = By.xpath("//p[contains(text(), 'Только начиная')]");
    private final By ACCORDION_EXTEND_ORDER_BODY = By.xpath("//p[contains(text(), 'Пока что нет')]");
    private final By ACCORDION_CHARGING_BODY = By.xpath("//p[contains(text(), 'Этого хватает')]");
    private final By ACCORDION_CANSEL_ORDER_BODY = By.xpath("//p[contains(text(), 'Штрафа')]");
    private final By ACCORDION_LIVE_BODY = By.xpath("//p[contains(text(), 'Всем самокатов')]");

    private final WebDriver driver;
    WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 3);
    }

    public void openPage(){
        driver.get(MAIN_PAGE_URL);
    }

    public void prepareScrollToQuestions(){
        WebElement webElement = driver.findElement(By.xpath("//div[text() = 'Вопросы о важном']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public void prepareScrollToOrderButton(){
        WebElement webElement = driver.findElement(BUTTON_ORDER_MIDDLE);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public void waitAfterClick(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //------------------------------------------------------------------------------------------//

    public void clickOrderHeader(){
        driver.findElement(BUTTON_ORDER_HEADER).click();
    }

    public void clickOrderMiddlePage(){
        driver.findElement(BUTTON_ORDER_MIDDLE).click();
    }

    public void clickAccordionPriceHeader(){
        driver.findElement(ACCORDION_PRICE_HEADER).click();
        waitAfterClick(ACCORDION_PRICE_BODY);
    }

    public void clickAccordionSeveralScootersHeader(){
        driver.findElement(ACCORDION_SEVERAL_SCOOTERS_HEADER).click();
        waitAfterClick(ACCORDION_SEVERAL_SCOOTERS_BODY);
    }

    public void clickAccordionCalculationTimeHeader(){
        driver.findElement(ACCORDION_CALCULATION_TIME_HEADER).click();
        waitAfterClick(ACCORDION_CALCULATION_TIME_BODY);
    }

    public void clickAccordionOrderTodayHeader(){
        driver.findElement(ACCORDION_ORDER_TODAY_HEADER).click();
        waitAfterClick(ACCORDION_ORDER_TODAY_BODY);
    }

    public void clickAccordionExtendOrderHeader(){
        driver.findElement(ACCORDION_EXTEND_ORDER_HEADER).click();
        waitAfterClick(ACCORDION_EXTEND_ORDER_BODY);
    }

    public void clickAccordionChargingHeader(){
        driver.findElement(ACCORDION_CHARGING_HEADER).click();
        waitAfterClick(ACCORDION_CHARGING_BODY);
    }

    public void clickAccordionCanselOrderHeader(){
        driver.findElement(ACCORDION_CANSEL_ORDER_HEADER).click();
        waitAfterClick(ACCORDION_CANSEL_ORDER_BODY);
    }

    public void clickAccordionLiveHeader(){
        driver.findElement(ACCORDION_LIVE_HEADER).click();
        waitAfterClick(ACCORDION_LIVE_BODY);
    }

    //------------------------------------------------------------------------------------------//

    public String getAccordionPriceBodyText(){
        return driver.findElement(ACCORDION_PRICE_BODY).getText();
    }

    public String getAccordionSeveralScootersBodyText(){
        return driver.findElement(ACCORDION_SEVERAL_SCOOTERS_BODY).getText();
    }

    public String getAccordionCalculationTimeBodyText(){
        return driver.findElement(ACCORDION_CALCULATION_TIME_BODY).getText();
    }

    public String getAccordionOrderTodayBodyText(){
        return driver.findElement(ACCORDION_ORDER_TODAY_BODY).getText();
    }

    public String getAccordionExtendOrderBodyText(){
        return driver.findElement(ACCORDION_EXTEND_ORDER_BODY).getText();
    }

    public String getAccordionChargingBodyText(){
        return driver.findElement(ACCORDION_CHARGING_BODY).getText();
    }

    public String getAccordionCanselOrderBodyText(){
        return driver.findElement(ACCORDION_CANSEL_ORDER_BODY).getText();
    }

    public String getAccordionLiveBodyText(){
        return driver.findElement(ACCORDION_LIVE_BODY).getText();
    }

}
