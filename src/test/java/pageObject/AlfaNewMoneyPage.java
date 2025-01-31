package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AlfaNewMoneyPage {
    public WebDriver driver;

    public AlfaNewMoneyPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@id, 'amount-input')]")
    private WebElement amountInput;
    @FindBy(xpath = "//*[contains(@data-test-id, 'period-btn-3')]")
    private WebElement month3Btn;
    @FindBy(xpath = "//*[contains(@data-test-id, 'period-btn-4')]")
    private WebElement month4Btn;
    @FindBy(xpath = "//*[contains(@data-test-id, 'period-btn-6')]")
    private WebElement month6Btn;
    @FindBy(xpath = "//*[contains(@data-test-id, 'period-btn-9')]")
    private WebElement month9Btn;
    @FindBy(xpath = "//*[contains(@data-test-id, 'period-btn-12')]")
    private WebElement year1Btn;
    @FindBy(xpath = "//*[contains(@data-test-id, 'period-btn-18')]")
    private WebElement year1_5Btn;
    @FindBy(xpath = "//*[contains(@data-test-id, 'period-btn-24')]")
    private WebElement year2Btn;
    @FindBy(xpath = "//*[contains(@data-test-id, 'period-btn-36')]")
    private WebElement year3Btn;
    @FindBy(xpath = "//*[contains(@data-test-id, 'interestRate-all-value-rub')]")
    private WebElement rateAll;
    @FindBy(xpath = "//*[contains(@data-test-id, 'interestRate-premium-value-rub')]")
    private WebElement ratePrem;

    public void setAmountInput(String amount){
        String selectAll = Keys.chord(Keys.CONTROL, "a");
        amountInput.sendKeys(selectAll);
        amountInput.sendKeys(amount);
    }
    public void clickBtn(WebElement button){
        Actions actions = new Actions(driver);
        actions.scrollToElement(button).perform();
        button.click();
    }
    public List<WebElement> getAllBtn(){
        return List.of(
                month3Btn,
                month4Btn,
                month6Btn,
                month9Btn,
                year1Btn,
                year1_5Btn,
                year2Btn,
                year3Btn
        );
    }
    public String getRateAll(){
        return rateAll.getText();
    }
    public String getRatePrem(){
        return ratePrem.getText();
    }
}
