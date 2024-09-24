package Tests;

import Pages.menuPage;
import Utils.SetupUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;


public class cadastroUsuarioTest extends SetupUtils {

    @Test
    @Epic("Interface")
    @Feature("Cadastro Usuários")
    @DisplayName("Cadastro de usuário com campos vazios")
    public void testCadastraComCamposVazios() {
        new menuPage(driver).realizarCadastrado("", "");
        Alert alertTxt = driver.switchTo().alert();
        System.out.println("Texto retorno do alert: " + alertTxt.getText());
        String textoEsperado = "Please fill out Username and Password.";
        assertEquals(textoEsperado, alertTxt.getText());
        alertTxt.accept();
    }

    @Test
    @Epic("Interface")
    @Feature("Cadastro Usuários")
    @DisplayName("Cadastro de usuário com campo username vazio")
    public void testCadastraComCampoUsernameVazio() {
        new menuPage(driver).realizarCadastrado("", "senha123");
        Alert alertTxt = driver.switchTo().alert();
        System.out.println("Texto retorno do alert: " + alertTxt.getText());
        String textoEsperado = "Please fill out Username and Password.";
        assertEquals(textoEsperado, alertTxt.getText());
        alertTxt.accept();
    }

    @Test
    @Epic("Interface")
    @Feature("Cadastro Usuários")
    @DisplayName("Cadastro de usuário com campo password vazio")
    public void testCadastraComCampoPasswordVazio() {
        new menuPage(driver).realizarCadastrado("thiagoqa", "");
        Alert alertTxt = driver.switchTo().alert();
        System.out.println("Texto retorno do alert: " + alertTxt.getText());
        String textoEsperado = "Please fill out Username and Password.";
        assertEquals(textoEsperado, alertTxt.getText());
        alertTxt.accept();
    }

    @Test
    @Epic("Interface")
    @Feature("Cadastro Usuários")
    @DisplayName("Cadastro de usuário já existente")
    public void testCadastroComUserExistente() {
        new menuPage(driver).realizarCadastrado("test", "test");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alertTxt = driver.switchTo().alert();
        System.out.println("Texto retorno do alert: " + alertTxt.getText());
        String textoEsperado = "This user already exist.";
        assertEquals(textoEsperado, alertTxt.getText());
        alertTxt.accept();
    }

    @Test
    @Epic("Interface")
    @Feature("Cadastro Usuários")
    @DisplayName("Cadastro de usuário com sucesso")
    public void testCadastroSucesso() {
        new menuPage(driver).realizarCadastrado("test" + formatoData, "test" );
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alertTxt = driver.switchTo().alert();
        System.out.println("Texto retorno do alert: " + alertTxt.getText());
        String textoEsperado = "Sign up successful.";
        assertEquals(textoEsperado, alertTxt.getText());
        alertTxt.accept();
    }

}
