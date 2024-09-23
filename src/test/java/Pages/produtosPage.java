package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class produtosPage {

    private WebDriver driver;

    public produtosPage(WebDriver driver){
        this.driver = driver;
    }

    private By linkHome = By.xpath("//a[contains(text(), 'Home')]");
    private By linkCategoriaLaptop = By.xpath("//a[contains(text(), 'Laptops')]");

    public produtosPage addProduto(String nomeProduto){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), '"+ nomeProduto +"')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div/div[2]/div[2]/div/a"))).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alertTxt = driver.switchTo().alert();
        System.out.println("Produto:  " + nomeProduto + " - " + alertTxt.getText());
        String textoEsperado = "Product added";
        assertEquals(alertTxt.getText(), textoEsperado);
        alertTxt.dismiss();

        return this;
    }

    public produtosPage retornaHome(){
        driver.findElement(linkHome).click();
        return this;
    }

    public produtosPage clicaCategoriaLaptop(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(linkCategoriaLaptop)).click();
        return this;
    }
}
