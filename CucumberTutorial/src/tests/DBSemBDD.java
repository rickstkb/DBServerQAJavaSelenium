package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Assert;
import page.classesDBServer.adicionaProdutoAoCarrinho;

public class DBSemBDD {
	private static WebDriver driver;
	private static String baseUrl;
//	private static String campo;
	private static String produto;
	public static WebElement element = null;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		// Informa URL para acesso
		baseUrl = "http://demo.cs-cart.com";
		
		// Instancia o browser acessa a URL 
		//adicionaProdutoAoCarrinho.setUpHome(driver, baseUrl);
		
		// Indica campo "Procurar produtos"
		//campo = "search_input";
		
		// Chama metodo para limpar qualquer coisa presente no campo
		//adicionaProdutoAoCarrinho.limpaCampos(driver);
		
		// Aponta quem � o produto
		produto = "Batman";
		
		// Insere o nome do produto no campo e pesquisa
		//adicionaProdutoAoCarrinho.insereProdeProc(driver, produto);
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\workspace\\selenium-java-2.48.2\\selenium-java-3.0.1\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		driver.get(baseUrl);
		
		
		driver.findElement(By.id("search_input")).clear();
		element = driver.findElement(By.id("search_input"));
		element.sendKeys(produto);
		element.sendKeys(Keys.ENTER);
		
		WebElement escolheProd = driver.findElement(By.xpath("//*[@id='pagination_contents']/div[2]/div[1]/div/form/div[2]/a"));
		String prodrotulo = escolheProd.getText();
		System.out.println(prodrotulo + " est� na Tela de Busca? ->" + escolheProd.isEnabled());
		escolheProd.click();
		
		driver.findElement(By.id("button_cart_94")).click();
		driver.findElement(By.xpath("html/body/div[7]/h1/span")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("sw_dropdown_8")).click();
		driver.findElement(By.xpath("//*[@id='dropdown_8']/div/div[2]/div[1]/a")).click();
		
		WebElement prodnocar = driver.findElement(By.xpath("//*[@id='cart_items']//td[2]/a[1]"));
		String nomeprodenc = prodnocar.getText();
		String nomeprodesp = "Batman: Arkham City (X360)";
		Assert.assertEquals(nomeprodesp, nomeprodenc);
		System.out.println(nomeprodenc + " est� no carrinho? ->" + prodnocar.isEnabled());
		System.out.println("Successful");
		adicionaProdutoAoCarrinho.EvidTeste(driver);
		
		driver.quit();
	}
}