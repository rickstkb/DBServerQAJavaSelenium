package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class StepsLogin {
	static WebDriver driver;
	
	@Dado("^que o usuario esta na Home$")
											// Entao toda vez que rodar o cucumber e estiver vazio gerando esse esqueleto, pra cada vez que tiver essa frase igual entre parenteses, vai rodar o mesmo bloco de codigo como se fosse um novo metodo, quando usar pageobj vira um metodo que chama outros metodos 
	public void que_o_usuario_esta_na_Home(){
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dell\\workspace\\selenium-java-2.48.2\\selenium-java-3.4.0\\lib\\geckodriver16.0.exe");
											// Instanciando essa variavel utilizando o motor do firefox
		driver = new FirefoxDriver();
		String baseURL = "http://www.letskodeit.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		driver.get(baseURL);
	}

	@Quando("^o usuario informar um Username e Senha corretos$")
	public void o_usuario_informar_um_Username_e_Senha_corretos(){
		WebElement signupLink = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
		signupLink.click();
		
		WebElement loginLink = driver.findElement(By.id("signUpDialogswitchDialogLink"));
		loginLink.click();
		
		WebElement emailField = driver.findElement(By.xpath("//div[@id='memberLoginDialogemail']//input"));
		emailField.sendKeys("test@email.com");
		
		WebElement passwordField = driver.findElement(By.xpath("//div[@id='memberLoginDialogpassword']//input"));
		passwordField.sendKeys("abcabc");
	}

	@Quando("^clicar no botao Go$")
	public void clicar_no_botao_Go() throws InterruptedException{
		WebElement goButton = driver.findElement(By.id("memberLoginDialogoklabel"));
		goButton.click();
		Thread.sleep(3000);
	}

	@Entao("^ele conseguira acessar a pagina Practice do site$")
	public void ele_conseguira_acessar_a_pagina_Practice_do_site(){
		WebElement practicePage = driver.findElement(By.id("DrpDwnMn05label"));
		practicePage.click();
	}

	@Entao("^a mensagem sera apresentada$")
	public void a_mensagem_sera_apresentada(){
		System.out.println("Login Successful");
		WebElement navhome = driver.findElement(By.id("DrpDwnMn00label"));
		navhome.click();
		WebElement label_logado = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
		String logado = label_logado.getText();
		System.out.println(logado);
		String mensagemesperada = "Log out";
		Assert.assertEquals(logado, mensagemesperada);
		driver.quit();
	}
}
