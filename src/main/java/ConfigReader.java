import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:site.properties"})
public interface ConfigReader extends Config {
    @Key("sber-best")
    String sberBest();
    @Key("sber-sber-deposit")
    String sberDeposit();
    @Key("sber-best-leader")
    String sberBestLead();
    @Key("sber-sber-deposit-leader")
    String sberDepositLead();
    @Key("alfa-new-money")
    String alfaNewMoney();
    @Key("alfa-max.Url")
    String alfaMaxUrl();
    @Key("vtb-deposit")
    String vtbDeposit();
    @Key("gpb-sky-high")
    String gpbSkyHigh();
    @Key("gpb-new-money")
    String gpbNewMoney();
    @Key("gpb-in-plus")
    String gpbInPlus();
    @Key("t-bank-deposit")
    String tBankDeposit();

}
