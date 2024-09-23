package Utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class SetupUtils implements AfterEachCallback {
    public WebDriver driver = new ChromeDriver();
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyyMMddhhmmss");
    public String formatoData = now.format(formato);

    @BeforeEach
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");
    }

    @AfterEach
    public void TearDown() {
        if (driver != null) {
            driver.quit();
        }

    }

    @Override
    public void afterEach(ExtensionContext context) {
        if (context.getExecutionException().isPresent()) {
            takeScreenshot(context.getDisplayName());
        }
    }

    private void takeScreenshot(String testName) {
        if (driver instanceof TakesScreenshot) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                Files.copy(screenshot.toPath(), new File("src/test/java/ImgReports/" + testName + formatoData + ".png").toPath());
                System.out.println("Screenshot saved for test: " + testName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
