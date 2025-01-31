import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObject.AlfaMaxPage;
import pageObject.AlfaNewMoneyPage;

import java.util.List;

public class AlfaNewMoneyTests {
    private static final String TEST_AMOUNT = "50000";
    public static AlfaNewMoneyPage alfaNewMoneyPage;
    public static WebDriver driver;


    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        alfaNewMoneyPage = new AlfaNewMoneyPage(driver);
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//неявное ожидание для загрузки страницы
        driver.get(ConfProvider.getProps().alfaNewMoney());

    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }



    @Test
    public void maxRozn() {
        alfaNewMoneyPage.setAmountInput(TEST_AMOUNT);
        List<WebElement> buttons = alfaNewMoneyPage.getAllBtn();
        for (WebElement button : buttons) {
            alfaNewMoneyPage.clickBtn(button);
            System.out.println("M:" + button.getText() + " R:" + alfaNewMoneyPage.getRateAll());
        }
    }
}
