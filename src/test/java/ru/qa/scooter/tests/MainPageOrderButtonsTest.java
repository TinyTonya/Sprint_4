package ru.qa.scooter.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.qa.scooter.pages.MainPage;
import java.util.concurrent.TimeUnit;
import ru.qa.scooter.pages.OrderWindow;


public class MainPageOrderButtonsTest {
    public static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
// когда нажимаешь на верхнюю кнопку "Заказать", открывается окно заказа
    public void testTopButtonOpensOrderWindow() {
        driver.get(PAGE_URL);
        mainPage = new MainPage(driver);

        mainPage.clickOrderButtonTop();

        OrderWindow orderWindow = new OrderWindow(driver);

        // Проверяем, что заголовок окна заказа равен "Для кого самокат"
        String expectedTitle = "Для кого самокат";
        String actualTitle = orderWindow.getOrderWindowTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        // Проверяем, что плейсхолдер firstNameField равен "* Имя"
        String expectedPlaceholder = "* Имя";
        String actualPlaceholder = orderWindow.getFirstNameFieldPlaceholder();
        Assert.assertEquals(expectedPlaceholder, actualPlaceholder);
    }

    @Test
// когда нажимаешь на нижнюю кнопку "Заказать", открывается окно заказа c определенным заголовком и плейсхолдером для поля Имя
    public void testBottomButtonOpensOrderWindow() {
        driver.get(PAGE_URL);
        mainPage = new MainPage(driver);


        WebElement element = driver.findElement(mainPage.orderButtonBottom);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        mainPage.clickOrderButtonBottom();

        OrderWindow orderWindow = new OrderWindow(driver);

        // Проверяем, что заголовок окна заказа равен "Для кого самокат"
        String expectedTitle = "Для кого самокат";
        String actualTitle = orderWindow.getOrderWindowTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        // Проверяем, что плейсхолдер firstNameField равен "* Имя"
        String expectedPlaceholder = "* Имя";
        String actualPlaceholder = orderWindow.getFirstNameFieldPlaceholder();
        Assert.assertEquals(expectedPlaceholder, actualPlaceholder);
    }


    @After
    public void tearDown() {

        driver.quit();
    }
}