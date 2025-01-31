package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VtbPage {
    public WebDriver driver;

    public VtbPage(WebDriver driver){  //  Конструктор
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@class, 'calculator-input-rangestyles__CalculatorRangeInput-foundation-kit__sc-1swhkj3-3 dusQxp')]")
    private WebElement amountInput;
    @FindBy(xpath = "//*[contains(@data-value,'91')]")
    private WebElement month3Btn;
    @FindBy(xpath = "//*[contains(@data-value,'181')]")
    private WebElement month6Btn;
    @FindBy(xpath = "//*[contains(@data-value,'370')]")
    private WebElement year1Btn;
    @FindBy(xpath = "//*[contains(@data-value,'548')]")
    private WebElement year1_5Btn;
    @FindBy(xpath = "//*[contains(@data-value,'730')]")
    private WebElement year2Btn;
    @FindBy(xpath = "//*[contains(@data-value,'1095')]")
    private WebElement year3Btn;
    @FindBy(xpath = "//*[contains(text(),'Получаю зарплату или пенсию в ВТБ')]")
    private WebElement optionZpPensia;
    @FindBy(xpath = "//*[contains(text(),'Открываю первый накопительный продукт в ВТБ')]")
    private WebElement optionNewProd;
    @FindBy(xpath = "//*[contains(text(),'Хочу вложить деньги из другого банка')]")
    private WebElement optionNewMoney;
    @FindBy(xpath = "//*[contains(text(),'Без дополнительных опций')]")
    private WebElement withoutOptions;
    @FindBy(xpath = "//div[.//p[text()='Доходность, % годовых']]//p[@data-text-value]")
    private WebElement rate;



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
    public List<WebElement> getAllBtn() {
        return List.of(
                month3Btn,
                month6Btn,
                year1Btn,
                year1_5Btn,
                year2Btn,
                year3Btn
        );
    }
    public String getRateAll(){
        return rate.getText();
    }
}
