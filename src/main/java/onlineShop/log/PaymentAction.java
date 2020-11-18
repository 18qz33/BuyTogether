package onlineShop.log;

import onlineShop.log.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PaymentAction {
    @Autowired
    private Logger logger; // Logger interface: record information

    public void pay (BigDecimal payValue) {
        logger.log("pay begin, pay value is " + payValue);
        logger.log("pay end");
    }
}
