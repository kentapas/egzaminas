package techin.lt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class CalculatorTest extends BaseTest{
    private static final Logger log = getLogger(lookup().lookupClass());

    Page action;

    @Test
    void calculation(){
        action = new Page(driver);
        action.inputLoginUsername("chovy123");
        action.inputLoginPassword("test1234");
        action.clickLoginButton();
        log.info("Filled all fields and clicked Prisijungti");
        String URL = driver.getCurrentUrl();
        Assertions.assertEquals(URL, "http://localhost:8080/");
        action.clearFirstNumber();
        action.inputFirstNumber("5");
        action.clearSecondNumber();
        action.inputSecondNumber("4");
        action.clickCalculate();
        log.info("Cleared the fields and Typed in numbers and clicked skaiciuoti");
        Assertions.assertEquals("5 + 4 = 9", action.assertResult());
    }
    @Test
    void calculationNegative(){
        action = new Page(driver);
        action.inputLoginUsername("chovy123");
        action.inputLoginPassword("test1234");
        action.clickLoginButton();
        log.info("Filled all fields and clicked Prisijungti");
        String URL = driver.getCurrentUrl();
        Assertions.assertEquals(URL, "http://localhost:8080/");
        action.clearFirstNumber();
        action.inputFirstNumber("-5");
        action.clearSecondNumber();
        action.inputSecondNumber("4");
        action.clickCalculate();
        log.info("Cleared the fields and Typed in numbers and clicked skaiciuoti");
        Assertions.assertEquals("Validacijos klaida: skaičius negali būti neigiamas", action.assertNumberError());
    }
}
