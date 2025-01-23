import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;


public class AlfaTests {
    private static final String AMOUNT_INPUT_CSS = "div.form-control__input_1xotc > input";
    private static final String MONTHS_BUTTON_CSS = "button:nth-child(%d) > span";
    private static final String TEST_AMOUNT = "50000";
    private WebDriver driver;
    private WebDriverWait wait;
    private WriterExcel excelWriter;
    private Actions actions;

    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUp() {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        excelWriter = new WriterExcel();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void maxRozn() {
        driver.get(ConfProvider.getProps().alfaMaxUrl());
        actions.scrollByAmount(0, 1000).perform();
        WebElement amountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(AMOUNT_INPUT_CSS)));
        String selectAll = Keys.chord(Keys.CONTROL, "a");
        amountInput.sendKeys(selectAll);
        amountInput.sendKeys(TEST_AMOUNT);
        for (int i = 1; i<=8; i++) {
            String button = String.format(MONTHS_BUTTON_CSS, i);
            WebElement monthsButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(button)));
            monthsButton.click();
            WebElement finalAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[data-test-id='amountAtTheEnd-all-value-rub']")));
            excelWriter.writeToExcel(1, 13 + i, finalAmount.getText());
        }
    }
}
