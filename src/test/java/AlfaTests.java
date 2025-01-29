import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class AlfaTests {
    private static final String AMOUNT_INPUT_CSS = "div.form-control__input_1xotc > input";
    private static final String MONTHS_BUTTON_CSS = "button:nth-child(%d) > span";
    private static final String TEST_AMOUNT = "50000";

    public static AlfaPage alfaPage;
    public static WebDriver driver;
    /*private WebDriverWait wait;
    private WriterExcel excelWriter;
    private Actions actions;*/

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        alfaPage = new AlfaPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProvider.getProps().alfaMaxUrl());
       /* wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        excelWriter = new WriterExcel();*/
    }

    @AfterEach
    public void tearDown() {
        driver.quit();

    }

    @Test
    public void maxRozn() {

        alfaPage.setAmountInput(TEST_AMOUNT);
        alfaPage.clickBtn();
        System.out.println(alfaPage.getRate());
       /*
        actions.scrollByAmount(0, 1000).perform();
        WebElement amountInput = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector(AMOUNT_INPUT_CSS)));
        String selectAll = Keys.chord(Keys.CONTROL, "a");
        amountInput.sendKeys(selectAll);
        amountInput.sendKeys(TEST_AMOUNT);

        String[] month = new String[15];
        for (int i = 1; i <= 15; i++) {
            String button = String.format(MONTHS_BUTTON_CSS, i);
            WebElement monthsButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(button)));
            monthsButton.click();
            WebElement finalAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[data-test-id='amountAtTheEnd-all-value-rub']")));
            month[i - 1] = finalAmount.getText();
        }
        MonthPOJO monthPOJO = MonthMapper.INSTANCE.mapToMonthPOJO(month[0], month[1],month[2], month[3], month[4], month[5],
                month[6],month[7],month[8],month[9], month[10], month[11], month[12], month[13], month[14]);

        excelWriter.writeToExcel(monthPOJO);*/
    }


}
