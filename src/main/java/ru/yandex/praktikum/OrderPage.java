package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrderPage {
    private final By COMPLETE_ORDER_TEXT = By.xpath("//div[text() = 'Заказ оформлен']");
    private final By HEADER_TEXT = By.xpath("//div[@class = 'Order_Header__BZXOb']");
    private final By CONFIRM_ORDER_TEXT = By.xpath("//div[@class = 'Order_ModalHeader__3FDaJ']");
    private final By NEXT_BUTTON = By.xpath("//button[text() = 'Далее']");
    private final By YES_BUTTON = By.xpath("//button[text() = 'Да']");
    private final By INPUT_FIRST_NAME = By.xpath("//input[@placeholder = '* Имя']");
    private final By INPUT_LAST_NAME = By.xpath("//input[@placeholder = '* Фамилия']");
    private final By INPUT_ADDRESS = By.xpath("//input[@placeholder = '* Адрес: куда привезти заказ']");
    private final By INPUT_METRO = By.xpath("//input[@placeholder = '* Станция метро']");
    private final By INPUT_PHONE = By.xpath("//input[@placeholder = '* Телефон: на него позвонит курьер']");
    private final By INPUT_DATE = By.xpath("//input[@placeholder = '* Когда привезти самокат']");
    private final By INPUT_RENTAL_PERIOD = By.xpath("//div[@class = 'Dropdown-placeholder']");
    private final By INPUT_SELECT_DATE_RENT = By.xpath("//div[text() = 'сутки']");
    private final By INPUT_COLOR_BLACK = By.xpath("//label[@for = 'black']");
    private final By INPUT_COURIER_DESCRIPTION = By.xpath("//input[@placeholder = 'Комментарий для курьера']");
    private final By BUTTON_ORDER_COMPLETE = By.
            xpath("//div[@class = 'Order_Buttons__1xGrp']/child::button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");


    private final WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }
    public void checkHeadTextVisible(){
        driver.findElement(HEADER_TEXT).isDisplayed();
    }

    public void checkHeadCompleteVisible(){
        driver.findElement(COMPLETE_ORDER_TEXT).isDisplayed();
    }

    public void checkConfirmOrderText(){
        driver.findElement(CONFIRM_ORDER_TEXT).isDisplayed();
    }

    public void clickNextButton(){
        driver.findElement(NEXT_BUTTON).click();
    }

    public void clickCompleteButton(){
        driver.findElement(BUTTON_ORDER_COMPLETE).click();
    }

    public void clickYesButton(){
        driver.findElement(YES_BUTTON).click();
    }

    public void setInputFirstName(){
        driver.findElement(INPUT_FIRST_NAME).sendKeys("Ольга");
    }

    public void setInputLastName(){
        driver.findElement(INPUT_LAST_NAME).sendKeys("Иванова");
    }
    public void setInputAddress(){
        driver.findElement(INPUT_ADDRESS).sendKeys("Москва");
    }

    public void setInputMetro(){
        driver.findElement(INPUT_METRO).click();
        driver.findElement(INPUT_METRO).sendKeys(Keys.DOWN);
        driver.findElement(INPUT_METRO).sendKeys(Keys.ENTER);
    }

    public void setInputPhone(){
        driver.findElement(INPUT_PHONE).sendKeys("89659238888");
    }

    public void setInputDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String date = LocalDate.now().plusDays(2).format(formatter);
        driver.findElement(INPUT_DATE).sendKeys(date, Keys.ENTER);
    }

    public void setRentalPeriod(){
        driver.findElement(INPUT_RENTAL_PERIOD).click();
        driver.findElement(INPUT_SELECT_DATE_RENT).click();
    }

    public void setInputColor(){
        driver.findElement(INPUT_COLOR_BLACK).click();
    }

    public void setCourierDescription(){
        driver.findElement(INPUT_COURIER_DESCRIPTION).sendKeys("Злая собака");
    }

}
