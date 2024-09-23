package Tests;

import Pages.carrinhoPage;
import Pages.menuPage;
import Pages.produtosPage;
import Utils.SetupUtils;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class carrinhoDeComprasTest extends SetupUtils {

    @Test
    @Epic("Interface")
    @DisplayName("Adicionar itens ao carrinho")
    public void testAddItensCarrinho() throws InterruptedException {
        //Inserindo produtos
        new produtosPage(driver).addProduto("Samsung galaxy s6")
                .retornaHome();
        new produtosPage(driver).addProduto("Nokia lumia 1520")
                .retornaHome();
        new produtosPage(driver).addProduto("Nexus 6")
                .retornaHome().clicaCategoriaLaptop();
        new produtosPage(driver).addProduto("Sony vaio i5")
                .retornaHome().clicaCategoriaLaptop();
        new produtosPage(driver).addProduto("Sony vaio i7")
                .retornaHome().clicaCategoriaLaptop();
        new menuPage(driver).clicaCarrinhoCompras();

        //Validando preço total de produtos
        Thread.sleep(4000);
        WebElement precoTotal = driver.findElement(By.id("totalp"));
        assertEquals("3410",precoTotal.getText());

        //registra a compra
        new carrinhoPage(driver).registraCompra();
        WebElement msgSucesso = driver.findElement(By.xpath("/html/body/div[10]/h2"));

        //valida sucesso da compra
        assertEquals("Thank you for your purchase!", msgSucesso.getText());
    }

    @Test
    @Epic("Interface")
    @Feature("Carrinho de compras")
    @DisplayName("Retirar item do carrinho")
    public void testRetiraItemCarrinho() throws InterruptedException {
        //Inserindo produtos
        new produtosPage(driver).addProduto("Samsung galaxy s6")
                .retornaHome();
        new produtosPage(driver).addProduto("Samsung galaxy s6")
                .retornaHome();
        new produtosPage(driver).addProduto("Samsung galaxy s6")
                .retornaHome().clicaCategoriaLaptop();
        new menuPage(driver).clicaCarrinhoCompras();

        //retira produto do carrinho
        new carrinhoPage(driver).retiraProdutoCarrinho();

        //valida valor total da compra
        Thread.sleep(4000);

        WebElement precoTotal = driver.findElement(By.id("totalp"));;
        assertEquals("720",precoTotal.getText());

    }
}
