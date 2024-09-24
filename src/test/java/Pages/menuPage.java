package Pages;

import Utils.Screenshot;
import Utils.SetupUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class menuPage {

    private WebDriver driver;

    public menuPage(WebDriver driver){
        this.driver = driver;
    }

    private By linkLogin = By.id("login2");
    private By campoUserName = By.id("loginusername");
    private By campoPassword = By.id("loginpassword");
    private By btnLogin = By.xpath("//button[contains(text(), 'Log in')]");

    private By linkCadastro = By.id("signin2");
    private By campoUsernameCadastro = By.id("sign-username");
    private By campoPasswordCadastro = By.id("sign-password");
    private By btnCadastro = By.xpath("//button[contains(text(), 'Sign up')]");

    private By linkCarriinhoCompras = By.xpath("//a[contains(text(), 'Cart')]");

    public menuPage realizarLogin(String user, String pass){
        driver.findElement(linkLogin).click();
        driver.findElement(campoUserName).sendKeys(user);
        driver.findElement(campoPassword).sendKeys(pass);
        driver.findElement(btnLogin).click();

        return this;
    }

    public menuPage realizarCadastrado(String user, String pass){
        driver.findElement(linkCadastro).click();
        driver.findElement(campoUsernameCadastro).sendKeys(user);
        driver.findElement(campoPasswordCadastro).sendKeys(pass);
        driver.findElement(btnCadastro).click();

        return this;

    }

    public menuPage clicaCarrinhoCompras(){
        driver.findElement(linkCarriinhoCompras).click();
        return this;
    }

}
