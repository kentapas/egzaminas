package techin.lt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class RegisterTest extends BaseTest {
    private static final Logger log = getLogger(lookup().lookupClass());

    Page action;

    @Test
    void register(){
        action = new Page(driver);
        action.clickCreateAccount();
        log.info("Clicked on Sukurti nauja paskyra");
        String URL = driver.getCurrentUrl();
        Assertions.assertEquals(URL, "http://localhost:8080/registruoti");
        action.inputRegisterUsername("chovy123");
        action.inputRegisterPassword("test1234");
        action.inputRegisterConfirmPassword("test1234");
        action.clickCreateButton();
        log.info("Filled all fields and clicked on Sukurti");
        String URL2 = driver.getCurrentUrl();
        Assertions.assertEquals(URL2, "http://localhost:8080/skaiciuotuvas");
    }
    @Test
    void registerNegative(){
        action = new Page(driver);
        action.clickCreateAccount();
        log.info("Clicked on Sukurti nauja paskyra");
        String URL = driver.getCurrentUrl();
        Assertions.assertEquals(URL, "http://localhost:8080/registruoti");
        action.inputRegisterUsername("1");
        action.inputRegisterPassword("1");
        action.inputRegisterConfirmPassword("1");
        action.clickCreateButton();
        log.info("Filled all fields and clicked on Sukurti");
        Assertions.assertEquals("Privaloma įvesti nuo 3 iki 32 simbolių", action.assertUsernameError());

    }
}

