package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TbankPage {

    public WebDriver driver;

    public TbankPage(WebDriver driver){  //  Конструктор
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//*[contains(@name, 'DepositTerm_1')]")
    private WebElement monthInput;
    @FindBy(xpath = "//*[contains(@name,'deposit_amount')]")
    private WebElement amountInput;
    @FindBy(xpath = "//*[@class='ab5v6DM6y cb5v6DM6y']/span[2]")
    private WebElement rate;

    public void setMonthInput(String month){
        monthInput.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        monthInput.sendKeys(month);
    }
    public void setAmountInput(String amount){
        String selectAll = Keys.chord(Keys.CONTROL, "a");
        amountInput.sendKeys(selectAll);
        amountInput.sendKeys(amount);
    }
    public String getRate(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(rate));
        return rate.getText();
    }
}
