package ru.qa.scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    // Кнопка «Заказать» вверху страницы
    private By orderButtonTop = By.className("Button_Button__ra12g");

    // Кнопка «Заказать» внизу страницы
    public By orderButtonBottom = By.className("Button_Button__ra12g Button_Middle__1CSJM");

    // Выпадающий список в разделе «Вопросы о важном»
    private By accordionItem = By.className("accordion__item");


    // Ответы на вопросы из списка "Вопросы о важном"
    private By accordionItemText = By.xpath("//div[@data-accordion-component='AccordionItemPanel']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // клик по верхней кнопке Заказать
    public void clickOrderButtonTop() {
        driver.findElement(orderButtonTop).click();
    }

    // клик по нижней кнопке Заказать
    public void clickOrderButtonBottom() {
        driver.findElement(orderButtonBottom).click();
    }

    // клик по вопросам из списка "вопросы о важном"
    public void clickAccordionItem(int index) {
        driver.findElements(accordionItem).get(index).click();
    }

    // Получить текст ответа на вопрос из списка "Вопросы о важном"
    public String getAccordionItemText(int index) {
        return driver.findElements(accordionItemText).get(index).getText();
    }

}