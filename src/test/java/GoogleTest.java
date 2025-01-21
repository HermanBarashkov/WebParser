import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;

public class GoogleTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        // Ротация User-Agent
        List<String> userAgents = List.of(
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36",
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.1.1 Safari/605.1.15",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:89.0) Gecko/20100101 Firefox/89.0"
        );
        Random random = new Random();
        String randomUserAgent = userAgents.get(random.nextInt(userAgents.size()));
        options.addArguments("--user-agent=" + randomUserAgent);
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testExample() {
        driver.get("https://www.google.com/");

        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(3000) + 5000); // Случайная задержка
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Имитация прокрутки и перемещения курсора
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");

        Actions actions = new Actions(driver);
        actions.moveByOffset(random.nextInt(100), random.nextInt(100)).perform();

        WebElement depositAmount = driver.findElement(By.name("q"));
        depositAmount.sendKeys("100000");
        depositAmount.clear();
        depositAmount.sendKeys("YES");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

       /* WebElement savings = driver.findElement(By.cssSelector(".dk-sbol-an-number.dk-sbol-an-number_size_md.dc-result-card__animated-num"));
        System.out.println(savings.getText());*/

        driver.quit();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
