package techin.lt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class LoginTest  extends BaseTest{
    private static final Logger log = getLogger(lookup().lookupClass());

    Page action;

    @Test
    void login(){
        action = new Page(driver);
        action.inputLoginUsername("chovy123");
        action.inputLoginPassword("test1234");
        action.clickLoginButton();
        log.info("Filled all fields and clicked Prisijungti");
        String URL = driver.getCurrentUrl();
        Assertions.assertEquals(URL, "http://localhost:8080/");
    }

    @Test
    void loginNegative(){
        action = new Page(driver);
        action.inputLoginUsername("1");
        action.inputLoginPassword("1");
        action.clickLoginButton();
        log.info("Filled all fields and clicked Prisijungti");
        Assertions.assertEquals("Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi", action.assertLoginError());
    }
}
