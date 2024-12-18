package ru.qa.scooter.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.qa.scooter.pages.MainPage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;

@RunWith(Parameterized.class)
public class MainPageAccordionTest {
    public static final String PAGE_URL = "https://qa-scooter.praktikum-services.ru/";
    public static final String CHROMEDRIVER_EXE = "C:\\Users\\Tonya\\chromedriver-win32\\chromedriver.exe";

    private WebDriver driver;
    private MainPage mainPage;
    private int accordionIndex;
    private String expectedText;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."}
        };
    }

    public MainPageAccordionTest(int accordionIndex, String expectedText) {
        this.accordionIndex = accordionIndex;
        this.expectedText = expectedText;
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_EXE);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(PAGE_URL);
        mainPage = new MainPage(driver);
    }

    @Test
    public void testAccordionItem() {
        WebElement element = driver.findElement(By.id("accordion__heading-" + accordionIndex));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        mainPage.clickAccordionItem(accordionIndex);
        String actualText = mainPage.getAccordionItemText(accordionIndex);
        Assert.assertEquals(actualText, expectedText);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}