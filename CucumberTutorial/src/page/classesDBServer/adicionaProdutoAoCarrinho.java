package page.classesDBServer;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class adicionaProdutoAoCarrinho {
	public static WebElement element = null;
	
	public static WebDriver setUpHome(WebDriver driver, String baseUrl){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\workspace\\selenium-java-2.48.2\\selenium-java-3.0.1\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		driver.get(baseUrl);
		return driver;
	}
		
	public static void EvidTeste(WebDriver driver) throws IOException{
        Date d = new Date();
        String date = d.toString().replaceAll(":"," ");
        String fileName = date + ".png";
        String directory = "C:\\Users\\Dell\\Desktop\\Eclipse 1\\Print Selenium Webdriver Java\\";
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory + fileName));
	}
	
	
	public static void clicaPesq(WebDriver driver){
		element = driver.findElement(By.id("search_input"));
		element.click();
	}
	
	
	public static WebElement insereValor(WebDriver driver){
		element = driver.findElement(By.id("search_input"));
		return element;
	}
	
	public static void procuraProd(WebDriver driver, String produto){
		element = insereValor(driver);
		element.clear();
		element.sendKeys(produto);
		element.sendKeys(Keys.ENTER);	
	}
	
	
	public static void selAcDetProd (WebDriver driver, String produto){
		WebElement escolheProd = driver.findElement(By.xpath("//*[@id='pagination_contents']/div[2]/div[1]/div/form/div[2]/a"));
		String prodrotulo = escolheProd.getText();
		System.out.println(prodrotulo + " está na Tela de Busca? ->" + escolheProd.isEnabled());
		escolheProd.click();
	}
	
	
	public static void addNoCar (WebDriver driver) throws InterruptedException{
		driver.findElement(By.id("button_cart_94")).click();
		driver.findElement(By.xpath("html/body/div[7]/h1/span")).click();
		Thread.sleep(1000);
	}
	
	
	public static void acessaCarCompras (WebDriver driver){
		driver.findElement(By.id("sw_dropdown_8")).click();
		driver.findElement(By.xpath("//*[@id='dropdown_8']/div/div[2]/div[1]/a")).click();
	}
	
	
	public static void validaProdnoCarrinho (WebDriver driver){
		WebElement prodnocar = driver.findElement(By.xpath("//*[@id='cart_items']//td[2]/a[1]"));
		String nomeprodenc = prodnocar.getText();
		String nomeprodesp = "Batman: Arkham City (X360)";
		Assert.assertEquals(nomeprodesp, nomeprodenc);
		System.out.println(nomeprodenc + " está no carrinho? ->" + prodnocar.isEnabled());
	}
}
/*	
	public static void limpaCampos(WebDriver driver) {
		driver.findElement(By.id("search_input")).clear();
	}
	
	
	public static void insereProdeProc(WebDriver driver, String produto){
		element = driver.findElement(By.id("search_input"));
		element.sendKeys(produto);
		element.sendKeys(Keys.ENTER);
	}
	
	
	
	public static WebElement originTextBox(WebDriver driver) {
		element = driver.findElement(By.id("+fieldLocator+"));
		return element;
	}
	

	public static void fillOriginTextBox(WebDriver driver, String origin) throws Exception {
		element = originTextBox(driver);
		element.sendKeys(origin);
		Thread.sleep(2000);
		element.sendKeys(Keys.TAB);
	}


	public static WebElement destinationTextBox(WebDriver driver) {
		element = driver.findElement(By.id("flight-destination"));
		return element;
	}
	


	public static void fillDestinationTextBox(WebDriver driver, String destination) throws Exception {
		element = destinationTextBox(driver);
		element.sendKeys(destination);
		Thread.sleep(2000);
		element.sendKeys(Keys.TAB);
	}


	public static WebElement apontabusca(WebDriver driver) {
		element = driver.findElement(By.id("search-button"));
		return element;
	}
	

	public static void clicaBusca(WebDriver driver) {
		element = apontabusca(driver);
		element.click();
	}
	

	public static void selecionaComboBox(WebDriver driver, String valor) {
		Select options = new Select(driver.findElement(By.id("flight-advanced-preferred-class")));
		options.selectByValue(valor);
	}
*/	


