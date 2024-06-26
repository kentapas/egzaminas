package techin.lt;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;
import static java.lang.invoke.MethodHandles.lookup;

public class BaseTest {
    private static final Logger log = getLogger(lookup().lookupClass());

    WebDriver driver;

    @BeforeEach
    void setup(){
        driver = new ChromeDriver();
        String URL = "http://localhost:8080/prisijungti";
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        log.info("Navigated to {}", URL);
    }

    @AfterEach
    void tearDown(){
        driver.close();
        log.info("WebDriver closed");
    }
}
