import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BankPOJO {
    private Date previousDate;
    private Date lastDate;
    private String segment;
    private String typeDeposit;
    private String bank;
    private String nameDeposit;
    private int minSum;
    private int maxSum;
    private String typeRate;
    private String addBonus;
    private String source;
    private String payments;
    private String openingChannel;
    private String statusDeposit;
}
