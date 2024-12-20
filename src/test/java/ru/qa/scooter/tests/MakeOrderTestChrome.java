package ru.qa.scooter.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.qa.scooter.pages.ConfirmWindow;
import ru.qa.scooter.pages.MainPage;
import ru.qa.scooter.pages.OrderWindow;
import ru.qa.scooter.pages.SuccessfulOrder;

import java.util.concurrent.TimeUnit;

// параметризация
@RunWith(Parameterized.class)
public class MakeOrderTestChrome {
    private WebDriver driver;
    private static MainPage mainPage;
    public static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String phone;
    private final String comment;
    private final String whatButtonToClick;

    public MakeOrderTestChrome(String firstName, String lastName, String address, String phone, String comment, String whatButtonToClick) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.comment = comment;
        this.whatButtonToClick = whatButtonToClick;
    }

    @Parameterized.Parameters
    public static Object[][] getMultiplicationData() {
        return new Object[][] {
                {"Тестовоеимя", "Тестоваяфамилия", "Тестовый адрес", "78886665544", "рандомный текстовый комментарий для курьера", "topButtonToClick"},
                {"Иван", "Иванов", "Санкт-Петербург Лиговский проспект 123а", "79059256404", "раз два три четыре","bodyButtonToClick"}
        };
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(PAGE_URL);
        mainPage = new MainPage(driver);
    }

    @Test
    public void testOrderFormFields() {
        if (whatButtonToClick == "topButtonToClick") {
            mainPage.clickOrderButtonTop();
        } else if (whatButtonToClick == "bodyButtonToClick"){
            WebElement element = driver.findElement(mainPage.orderButtonBottom);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
            mainPage.clickOrderButtonBottom();
        }

        OrderWindow orderWindow = new OrderWindow(driver);

        // Вводим данные в поля формы 1
        orderWindow.enterFirstName(firstName);
        orderWindow.enterLastName(lastName);
        orderWindow.enterAddress(address);
        orderWindow.clickMetroStationField();
        orderWindow.chooseMetroStation();
        orderWindow.enterPhone(phone);

        // Переходим к следующему шагу
        orderWindow.clickNextButton();

        // Вводим данные в поля формы 2
        orderWindow.clickWhenField();
        orderWindow.clickWhenDate();
        orderWindow.selectRentalPeriod();
        orderWindow.clickBlackPearlCheckbox();
        orderWindow.enterComment(comment);

        //нажимаем Заказать
        orderWindow.clickOrderButton();

        ConfirmWindow confirmWindow = new ConfirmWindow(driver);

        // Проверяем, что заголовок окна подтверждения заказа равен "Хотите оформить заказ?"
        String expectedTitle = "Хотите оформить заказ?\n" +
                " ";
        String actualTitle = confirmWindow.getConfirmTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        //нажимаем кнопку Да
        confirmWindow.clickYesConfirmButton();

        SuccessfulOrder successfulOrder = new SuccessfulOrder(driver);

        // Проверяем, что отображается заголовок Заказ оформлен
        String expected = "Заказ оформлен";
        String actual = successfulOrder.getSuccessfulOrderTitle();
        Assert.assertTrue("Сообщение об успешном оформлении заказа не получено", actual.contains(expected));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}