package ru.qa.scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmWindow {
    private WebDriver driver;

    //заголовок Хотите оформить заказ?
    private final By confirmTitle = By.xpath("//div[@class='Order_Modal__YZ-d3']/div[@class='Order_ModalHeader__3FDaJ']");

    // Кнопка "Да" в модалке "Хотите оформить заказ?"
    private final By yesConfirmButton= By.xpath("//button[text()='Да']");

    public ConfirmWindow (WebDriver driver) {
        this.driver = driver;
    }
 // клик по кнопке "Да"
    public void clickYesConfirmButton() {
        driver.findElement(yesConfirmButton).click();
    }
// вернуть текст заголовка окна подтверждения заказа
    public String getConfirmTitle() {
        return driver.findElement(confirmTitle).getText();
    }
}
