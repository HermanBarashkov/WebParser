import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class AlfaMaxRozn {
    private WebDriver driver;
    WriterExcel writerExcel = new WriterExcel();
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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://alfabank.ru/make-money/deposits/alfa-frc/?utm_source=yandex&utm_medium=cpc&utm_campaign=yxprvkl_yandex_dc_vklad_search_brand_rf&utm_content=campaign_name_yxprvkl_yandex_dc_vklad_search_brand_rf%7Ccampaign_id_110875618%7Cgbid_5448588668%7Cad_id_16151206983%7Ccampaign_name_lat_yxprvkl_yandex_dc_vklad_search_brand_rf%7Ccoef_goal_context_id_0%7Ckeyword_---autotargeting%7Cphrase_id_51786018697%7Cretargeting_id_51786018697%7Cposition_1%7Cposition_type_premium%7Csource_none%7Csource_type_search%7Cdevice_type_desktop%7Cregion_id_7%7Cregion_name_%D0%9A%D0%BE%D1%81%D1%82%D1%80%D0%BE%D0%BC%D0%B0&platformId=yandex_cpc_yxprvkl_yandex_dc_vklad_search_brand_rf%7C51786018697_51786018697%7Ccid%7C110875618%7Cgid%7C5448588668%7Caid%7C16151206983%7Caud%7C0%7Cadp%7Cno%7Cpos%7Cpremium1%7Csrc%7Csearch_none%7Cdvc%7Cdesktop%7Creg7_%D0%9A%D0%BE%D1%81%D1%82%D1%80%D0%BE%D0%BC%D0%B0&yclid=14600569832702476287");

        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(3000) + 2000); // Случайная задержка
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement amountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.form-control__input_1xotc > input")));
        //amountInput.click();
        amountInput.sendKeys(Keys.CONTROL + "a");
        amountInput.sendKeys(Keys.DELETE);
        amountInput.sendKeys("10000");

        // Выбираем срок 6 месяцев
        WebElement sixMonthsButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button:nth-child(3) > span")));
        sixMonthsButton.click();

        // Ждем, пока обновится итоговая сумма
        WebElement finalAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[data-test-id='amountAtTheEnd-all-value-rub']")));

        // Выводим итоговую сумму в консоль
        System.out.println("Итоговая сумма: " + finalAmount.getText());
        writerExcel.writeToExcel(finalAmount.getText());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
