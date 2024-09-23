package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class carrinhoPage {
    public WebDriver driver;

    public carrinhoPage(WebDriver driver){
        this.driver = driver;
    }

    private By btnRegistraDadosCompra = By.xpath("//button[contains(text(), 'Place Order')]");
    private By nomeCliente = By.id("name");
    private By paisCliente = By.id("country");
    private By cidadeCliente = By.id("city");
    private By numeroCartao = By.id("card");
    private By mesCartao = By.id("month");
    private By anoCartao = By.id("year");
    private By botaoComprar = By.xpath("//button[contains(text(), 'Purchase')]");
    private By linkDeletar = By.xpath("//*[@id='tbodyid']/tr[1]/td[4]/a");


    public carrinhoPage registraCompra(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(btnRegistraDadosCompra).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(nomeCliente)).sendKeys("Thiago Alan dos Santos Neves");
        driver.findElement(paisCliente).sendKeys("BRAZIL");
        driver.findElement(cidadeCliente).sendKeys("SAO PAULO");
        driver.findElement(numeroCartao).sendKeys("5689433190872143");
        driver.findElement(mesCartao).sendKeys("09");
        driver.findElement(anoCartao).sendKeys("2030");
        driver.findElement(botaoComprar).click();

        return this;
    }

    public carrinhoPage retiraProdutoCarrinho (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(linkDeletar)).click();

        return this;
    }

}
