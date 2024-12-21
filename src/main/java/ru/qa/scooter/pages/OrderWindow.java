package ru.qa.scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderWindow {
    private WebDriver driver;
    // заголовок Для кого самокат
        private By orderWindowTitle = By.className("Order_Header__BZXOb");

    // Поле «Имя» в форме заказа
    private By firstNameField = By.xpath("//input[@placeholder='* Имя']");

    // Поле «Фамилия» в форме заказа
    private By lastNameField = By.xpath("//input[@placeholder='* Фамилия']");

    // Поле «Адрес» в форме заказа
    private By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");

    // Поле «Метро» в форме заказа
    private By metroStationField = By.xpath("//input[@placeholder='* Станция метро']");

    //станция метро Черкизовская
    private By metroStationName = By.xpath("//li[@data-index='1']");

    // Поле «Телефон» в форме заказа
    private By phoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    // Кнопка «Далее» в форме заказа
    private By formNextButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // Поле «Когда привезти» в форме заказа
    private By whenField = By.xpath("//input[@placeholder='* Когда привезти самокат']");

    // 20ое число в датапикере
    private By  whenDate = By.className("react-datepicker__day--020");

    // Поле «Срок аренды» в форме заказа
    private By rentalPeriodField = By.className("Dropdown-arrow");

    // Дропдаун "четверо суток"
    private By whenDropdown = By.xpath("//div[@class='Dropdown-menu']/div[text()='четверо суток']");

    // Чекбокс «Цвет самоката: черный жемчуг» в форме заказа
    private By blackPEarlCheckbox = By.id("black");

    // Поле «Комментарий для курьера» в форме заказа
    private By commentField = By.xpath("//input[@placeholder='Комментарий для курьера']");

    // Кнопка «Заказать» в форме заказа
    private By formOrderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public OrderWindow (WebDriver driver) {
        this.driver = driver;
    }

    // Получение заголовка окна заказа
    public String getOrderWindowTitle() {
        return driver.findElement(orderWindowTitle).getText();
    }

    // Получение плейсхолдера поля имени
    public String getFirstNameFieldPlaceholder() {
        return driver.findElement(firstNameField).getAttribute("placeholder");
    }

    // ввод в поле Имя
    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    // ввод в поле Фамилия
    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    // ввод в поле Адрес
    public void enterAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    // клик по полю Метро = открыть список
    public void clickMetroStationField() {
        driver.findElement(metroStationField).click();
    }

    //выбор станции метро из списка
    public void chooseMetroStation() {
        driver.findElement(metroStationName).click();
    }

    // ввод в поле Телефон
    public void enterPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    // клик по кнопке Далее
    public void clickNextButton() {
        driver.findElement(formNextButton).click();
    }

    // клик по полю Когда привезти
    public void clickWhenField() {
        driver.findElement(whenField).click();
    }

   // выбор даты из датапикера
    public void clickWhenDate() {
        driver.findElement(whenDate).click();
    }

    // клик по полю Срок аренды
    public void clickRentalPeriodField() {
        driver.findElement(rentalPeriodField).click();
    }

    // выбор значения в dropdown-меню Срок аренды
    public void selectRentalPeriod() {
        clickRentalPeriodField();
        driver.findElement(whenDropdown).click();
    }

    // клик - включение необязательного чекбокса "черный жемчуг" поля Цвет самоката
    public void clickBlackPearlCheckbox() {
        driver.findElement(blackPEarlCheckbox).click();
    }

    // ввод в поле Комментарий
    public void enterComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    // клик по кнопке Заказать
    public void clickOrderButton() {
        driver.findElement(formOrderButton).click();
    }
}