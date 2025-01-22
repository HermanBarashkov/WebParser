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

public class AlfaTests {
    private WebDriver driver;
    private WebDriverWait wait;
    WriterExcel writerExcel = new WriterExcel();

    @BeforeEach
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void MaxRozn() {


        driver.get(ConfProvider.getProps().alfaMaxUrl());
        WebElement amountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.form-control__input_1xotc > input")));
        amountInput.sendKeys(Keys.CONTROL + "a");
        amountInput.sendKeys("100000");
        WebElement monthsButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button:nth-child(5) > span")));
        monthsButton.click();
        WebElement finalAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[data-test-id='amountAtTheEnd-all-value-rub']")));
        System.out.println("Итоговая сумма: " + finalAmount.getText());
        writerExcel.writeToExcel("Розничный клиент",finalAmount.getText());
    }

    @Test
    public void MaxPrem(){
        driver.get(ConfProvider.getProps().alfaMaxUrl());
        WebElement amountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.form-control__input_1xotc > input")));
        amountInput.sendKeys(Keys.CONTROL + "a");
        amountInput.sendKeys("10000");
        WebElement monthsButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button:nth-child(5) > span")));
        monthsButton.click();
        WebElement finalAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[data-test-id='amountAtTheEnd-premium-value-rub']")));
        System.out.println("Итоговая сумма: " + finalAmount.getText());
        writerExcel.writeToExcel("Премиум клиент", finalAmount.getText());

    }


}
