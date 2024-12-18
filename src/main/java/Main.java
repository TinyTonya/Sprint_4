import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tonya\\chromedriver-win32\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver(options);
        Duration duration = Duration.ofSeconds(3);
        webDriver.manage().timeouts().implicitlyWait(duration.toMillis(), TimeUnit.MILLISECONDS);
        webDriver.get("https://qa-scooter.praktikum-services.ru");
    }
}
