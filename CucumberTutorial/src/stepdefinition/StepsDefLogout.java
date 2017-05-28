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

public class StepsDefLogout {
	static WebDriver driver;
	
	@Dado("^um usuario logado no site e na pagina practice$")
	public void um_usuario_logado_no_site_e_na_pagina_practice() throws InterruptedException{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dell\\workspace\\selenium-java-2.48.2\\selenium-java-3.4.0\\lib\\geckodriver16.0.exe");
		// Instanciando essa variavel utilizando o motor do firefox
		driver = new FirefoxDriver();
		String baseURL = "http://www.letskodeit.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		driver.get(baseURL);
		
		WebElement signupLink = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
		signupLink.click();
		
		WebElement loginLink = driver.findElement(By.id("signUpDialogswitchDialogLink"));
		loginLink.click();
		
		WebElement emailField = driver.findElement(By.xpath("//div[@id='memberLoginDialogemail']//input"));
		emailField.sendKeys("test@email.com");
		
		WebElement passwordField = driver.findElement(By.xpath("//div[@id='memberLoginDialogpassword']//input"));
		passwordField.sendKeys("abcabc");
		
		WebElement goButton = driver.findElement(By.id("memberLoginDialogoklabel"));
		goButton.click();
		Thread.sleep(3000);
	}

	@Quando("^o usuario clicar em logout na aba home$")
	public void o_usuario_clicar_em_logout_na_aba_home() throws InterruptedException{
		WebElement logout = driver.findElement(By.id("DrpDwnMn00label"));
		logout.click();
		logout = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
		logout.click();
		Thread.sleep(3000);
	}

	@Entao("^ele ira para a pagina deslogada do site$")
	public void ele_ira_para_a_pagina_deslogada_do_site(){
		WebElement deslogado = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
		String labeldeslogado = deslogado.getText();
		System.out.println(labeldeslogado + " testedeucerto");
		String mensagemesperada = "Login/Sign up";
		Assert.assertEquals(labeldeslogado, mensagemesperada);
	}

	@Entao("^nao conseguira acessar a tela pratice apresentando a tela de login$")
	public void nao_conseguira_acessar_a_tela_pratice_apresentando_a_tela_de_login(){
		WebElement navPag = driver.findElement(By.id("DrpDwnMn05label"));
		navPag.click();
		WebElement Login = driver.findElement(By.id("signUpDialognote"));
		String MensLog = Login.getText();
		System.out.println(MensLog);
		String MensagemEsperada = "I'm already a user,";
		Assert.assertEquals(MensLog,MensagemEsperada);
		driver.quit();
	}

}

// Exemplos http://toolsqa.com/cucumber/cucumber-tutorial/
// http://toolsqa.com/cucumber/data-tables-in-cucumber/
// 
