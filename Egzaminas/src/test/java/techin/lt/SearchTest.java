package techin.lt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;

public class SearchTest extends BaseTest{
    private static final Logger log = getLogger(lookup().lookupClass());

    Page action;

    @Test
    void search(){
        action = new Page(driver);
        action.inputLoginUsername("chovy123");
        action.inputLoginPassword("test1234");
        action.clickLoginButton();
        log.info("Filled all fields and clicked Prisijungti");
        String URL = driver.getCurrentUrl();
        Assertions.assertEquals(URL, "http://localhost:8080/");
        action.clickDoneOperations();
        log.info("Clicked on Atliktos operacijos");
        String URL2 = driver.getCurrentUrl();
        Assertions.assertEquals(URL2, "http://localhost:8080/skaiciai");
        action.getFirstResult();
        log.info("Found the first result: " + action.getFirstResult());
        Assertions.assertEquals("7 + 6 13 Keisti | Trinti | Rodyti", action.getFirstResult());
    }
    @Test
    void searchNegative(){
        action = new Page(driver);
        action.inputLoginUsername("chovy123");
        action.inputLoginPassword("test1234");
        action.clickLoginButton();
        log.info("Filled all fields and clicked Prisijungti");
        String URL = driver.getCurrentUrl();
        Assertions.assertEquals(URL, "http://localhost:8080/");
        action.clickDoneOperations();
        log.info("Clicked on Atliktos operacijos");
        String URL2 = driver.getCurrentUrl();
        Assertions.assertEquals(URL2, "http://localhost:8080/skaiciai");
        action.getFirstResult();
        log.info("Found the first result: " + action.getFirstResult());
        Assertions.assertNotEquals("3 + 1 4 Keisti | Trinti | Rodyti", action.getFirstResult());
    }
}
