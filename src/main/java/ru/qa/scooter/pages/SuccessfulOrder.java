package ru.qa.scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessfulOrder {
    private WebDriver driver;

    //заголовок 'Заказ оформлен'
    private final By successfulOrderTitle = By.xpath("//div[contains(@class, 'Order_ModalHeader__3FDaJ') and text()='Заказ оформлен']");

    public SuccessfulOrder (WebDriver driver) {
        this.driver = driver;
    }

    // получить заголовок
    public String getSuccessfulOrderTitle() {
        return driver.findElement(successfulOrderTitle).getText();
    }
}

