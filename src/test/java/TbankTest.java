import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObject.TbankPage;


import java.util.concurrent.TimeUnit;

public class TbankTest {
    private static final String TEST_AMOUNT = "50000";

    public static TbankPage tbankPage;
    public static WebDriver driver;

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        tbankPage = new TbankPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProvider.getProps().tBankDeposit());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();

    }

    @Test
    public void tbank() {
        tbankPage.setAmountInput(TEST_AMOUNT);
        for (int month = 2; month <= 24; month++) {
            tbankPage.setMonthInput(String.valueOf(month));
            System.out.println("M: " + month + " R: " + tbankPage.getRate());
        }
    }
}
