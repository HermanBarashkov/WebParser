import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObject.AlfaMaxPage;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class AlfaTests {

    private static final String TEST_AMOUNT = "50000";
    public static AlfaMaxPage alfaMaxPage;
    public static WebDriver driver;


    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        alfaMaxPage = new AlfaMaxPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProvider.getProps().alfaMaxUrl());

    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }



    @Test
    public void maxRozn() {
        alfaMaxPage.setAmountInput(TEST_AMOUNT);
        List<WebElement> buttons = alfaMaxPage.getAllBtn();
        for (WebElement button : buttons) {
            alfaMaxPage.clickBtn(button);
            System.out.println("M: " + button.getText() + " R:" + alfaMaxPage.getRate());
        }
    }


}
