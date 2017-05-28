package stepdefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import page.classesDBServer.adicionaProdutoAoCarrinho;

public class StepsCarrinhoDBServer {
	static WebDriver driver;
	
	@Dado("^um usuario que acesse a home do site \"([^\"]*)\"$")
	public void um_usuario_que_acesse_a_home_do_site(String URL){
		StepsCarrinhoDBServer.driver = adicionaProdutoAoCarrinho.setUpHome(driver, URL);
	}

	
	@Quando("^clicar no campo Procurar Produtos$")
	public void clicar_no_campo_Procurar_Produtos(){
		adicionaProdutoAoCarrinho.clicaPesq(driver);
	}

	
	@Quando("^pesquisar pelo produto \"([^\"]*)\"$")
	public void pesquisar_pelo_produto(String produto){
		adicionaProdutoAoCarrinho.procuraProd(driver, produto);
	}

	
	@Quando("^no resultado da pesquisa clicar no produto \"([^\"]*)\"$")
	public void no_resultado_da_pesquisa_clicar_no_produto(String selecionaprod){
		adicionaProdutoAoCarrinho.selAcDetProd(driver, selecionaprod);
	}

	
	@Quando("^na tela do produto clicar em adicionar ao carrinho$")
	public void na_tela_do_produto_clicar_em_adicionar_ao_carrinho() throws InterruptedException{
		adicionaProdutoAoCarrinho.addNoCar(driver);
	}

	
	@Quando("^clicar no Carrinho de Compras apresentando a respectiva tela$")
	public void clicar_no_Carrinho_de_Compras_apresentando_a_respectiva_tela(){
		adicionaProdutoAoCarrinho.acessaCarCompras(driver);
	}

	@Entao("^o produto devera ser apresentado no carrinho$")
	public void o_produto_devera_ser_apresentado_no_carrinho() throws IOException{
		adicionaProdutoAoCarrinho.validaProdnoCarrinho(driver);
		adicionaProdutoAoCarrinho.EvidTeste(driver);
		driver.quit();
	}
}
