import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlfaPage {
    public WebDriver driver;

    public AlfaPage(WebDriver driver){  //  Конструктор
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    // Находим элемент ввода
    @FindBy(xpath = "//*[contains(@class, 'input__input_qe78h input__input_frf69 input__l_qe78h input__hasInnerLabel_qe78h input__hasInnerLabel_frf69 amount-input__input_puwah')]")
    private WebElement amountInput;
    public void setAmountInput(String amount){
        String selectAll = Keys.chord(Keys.CONTROL, "a");
        amountInput.sendKeys(selectAll);
        amountInput.sendKeys(amount);
    }

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

    public void clickBtn(){
        Actions actions = new Actions(driver);
        actions.scrollToElement(year3Btn).perform();
        months2Btn.click();
    }

    @FindBy(xpath = "//*[contains(@data-test-id, 'interestRate-all-value-rub')]")
    private WebElement rate;

    public String getRate(){
        return rate.getText();
    }





}
