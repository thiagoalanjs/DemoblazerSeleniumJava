package Tests;

import Utils.SetupUtils;
import Pages.menuPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class loginUserTest extends SetupUtils {

    @Test
    @Epic("Interface")
    @Feature("Realizar login na aplicação")
    @DisplayName("Login com campos vazios")
    public void testLoginComCamposVazios(){
        new menuPage(driver).realizarLogin("", "");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alertTxt = driver.switchTo().alert();
        System.out.println("Texto retorno do alert: " + alertTxt.getText());
        String textoEsperado = "Please fill out Username and Password.";
        assertEquals(alertTxt.getText(), textoEsperado);
    }

    @Test
    @Epic("Interface")
    @Feature("Realizar login na aplicação")
    @DisplayName("Login com username vazios")
    public void testLoginUsernameVazio(){
        new menuPage(driver).realizarLogin("", "pass123");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alertTxt = driver.switchTo().alert();
        System.out.println("Texto retorno do alert: " + alertTxt.getText());
        String textoEsperado = "Please fill out Username and Password.";
        assertEquals(textoEsperado, alertTxt.getText());
    }

    @Test
    @Epic("Interface")
    @Feature("Realizar login na aplicação")
    @DisplayName("Login com password vazios")
    public void testLoginPasswordVazio(){
        new menuPage(driver).realizarLogin("test", "");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alertTxt = driver.switchTo().alert();
        System.out.println("Texto retorno do alert: " + alertTxt.getText());
        String textoEsperado = "Please fill out Username and Password.";
        assertEquals(textoEsperado, alertTxt.getText());
    }

    @Test
    @Epic("Interface")
    @Feature("Realizar login na aplicação")
    @DisplayName("Login sem username cadastrado")
    public void testLoginSemUserCadastrado(){
        new menuPage(driver).realizarLogin("TestQA10293349", "pass123");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alertTxt = driver.switchTo().alert();
        System.out.println("Texto retorno do alert: " + alertTxt.getText());
        String textoEsperado = "User does not exist.";
        assertEquals(textoEsperado, alertTxt.getText());
    }

    @Test
    @Epic("Interface")
    @Feature("Realizar login na aplicação")
    @DisplayName("Login com sucesso")
    public void testLoginSucesso(){
        new menuPage(driver).realizarLogin("test", "test");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement msgLoginSucesso = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
        msgLoginSucesso.getText();
        String textoEsperado = "Welcome test";
        assertEquals(textoEsperado,msgLoginSucesso.getText());
    }
}
