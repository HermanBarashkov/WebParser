package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AlfaMaxPage {
    public WebDriver driver;

    public AlfaMaxPage(WebDriver driver){  //  Конструктор
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@class, 'input__input_qe78h input__input_frf69 input__l_qe78h input__hasInnerLabel_qe78h input__hasInnerLabel_frf69 amount-input__input_puwah')]")
    private WebElement amountInput;
    @FindBy(xpath = "//*[contains(text(), '2 месяца')]")
    private WebElement months2Btn;
    @FindBy(xpath = "//*[contains(text(), '3 месяца')]")
    private WebElement months3Btn;
    @FindBy(xpath = "//*[contains(text(), '4 месяца')]")
    private WebElement months4Btn;
    @FindBy(xpath = "//*[contains(text(), '6 месяцев')]")
    private WebElement months6Btn;
    @FindBy(xpath = "//*[contains(text(), '9 месяцев')]")
    private WebElement months9Btn;
    @FindBy(xpath = "//*[contains(text(), '1 год')]")
    private WebElement year1Btn;
    @FindBy(xpath = "//*[contains(text(), '1,5 года')]")
    private WebElement year1_5Btn;
    @FindBy(xpath = "//*[contains(text(), '2 года')]")
    private WebElement year2Btn;
    @FindBy(xpath = "//*[contains(text(), '3 года')]")
    private WebElement year3Btn;
    @FindBy(xpath = "//*[contains(@data-test-id, 'interestRate-all-value-rub')]")
    private WebElement rate;

    public void setAmountInput(String amount){
        String selectAll = Keys.chord(Keys.CONTROL, "a");
        amountInput.sendKeys(selectAll);
        amountInput.sendKeys(amount);
    }
    public void clickBtn(WebElement button){
        Actions actions = new Actions(driver);
        actions.scrollToElement(button).perform();
        months2Btn.click();
    }
    public List<WebElement> getAllBtn(){
        return List.of(
                months2Btn,
                months3Btn,
                months4Btn,
                months6Btn,
                months9Btn,
                year1Btn,
                year1_5Btn,
                year2Btn,
                year3Btn
        );
    }
    public String getRate(){
        return rate.getText();
    }
}
