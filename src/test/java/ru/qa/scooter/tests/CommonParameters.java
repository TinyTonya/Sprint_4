package ru.qa.scooter.tests;

import org.openqa.selenium.WebDriver;
import ru.qa.scooter.pages.MainPage;

public abstract class CommonParameters {
    protected WebDriver driver;
    protected MainPage mainPage;
    public static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
}
