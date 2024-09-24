package Utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;


public class SetupUtils {
    public WebDriver driver = new ChromeDriver();
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyyMMddhhmmss");
    public String formatoData = now.format(formato);
    public String MethodName;
    public String caminhoPath;

    @BeforeEach
    public void SetUp(TestInfo testInfo){
        MethodName = testInfo.getTestMethod().get().getName();
        caminhoPath = "src/test/java/ImgReports/" + MethodName + formatoData + "_.png";

        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");
    }

    @AfterEach
    public void TearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}