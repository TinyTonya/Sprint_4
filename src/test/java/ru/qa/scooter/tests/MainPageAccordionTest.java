package ru.qa.scooter.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.qa.scooter.pages.MainPage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;

@RunWith(Parameterized.class)
public class MainPageAccordionTest extends CommonParameters{
    private int accordionIndex;
    private String expectedText;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
    }
    public MainPageAccordionTest(int accordionIndex, String expectedText) {
        this.accordionIndex = accordionIndex;
        this.expectedText = expectedText;
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(PAGE_URL);
        mainPage = new MainPage(driver);
    }

    @Test
    public void testAccordionItem() {
        WebElement element = mainPage.getAccordionItemElement(accordionIndex);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        mainPage.clickAccordionItem(accordionIndex);
        String actualText = mainPage.getAccordionItemText(accordionIndex);
        Assert.assertEquals(expectedText, actualText);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}