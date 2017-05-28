package tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions (
		//dryRun=true,
		monochrome=true,
		features = "src/feature", 
		tags = "@pesquisaeadicionanocarrinho", 
		glue={"stepdefinition"}
		)

public class IntegraFeaturesComStepseConfiguracoes {

}

// Proximo passo é criar todas as class pages com os metodos estruturados da forma como vao ser usados e depois ir melhorando os
// Aumentando a sua modularidade ficando menores e mais especificos pra cada função que irão desempenhar
// Inicialmente criar um pacote de class pages
// Ir chamando cada objeto/metodo dentro de cada step e tentando obter retornos positivos em cada passo
// Depois ir quebrando em metodos menores

// Criar metodos setUp por exemplo pra cada navegador dentro de uma classe setup
// Metodos TearDown dentro de uma classe teardown
// Depois metodos para tarefas repetitivas (clicar, validar texto de cada forma, navegar entre paginas, acessar determinados elementos, etc)

// Sendo que o objetivo final é que dentro de cada stepdefinition ao longo do codigo, possa chamar todo esse pacote, instanciar os objetos e os metodos q eu quiser, com muita facilidade



// No futuro repetir todo esse framework construido com pages etc em ruby e tentar reutilizar os codigos escritos aqui em selenium, dentro do capybara

// Boa fonte para configuração e uso do cucumber em pt 
// http://www.devmedia.com.br/desenvolvimento-orientado-a-comportamento-bdd-com-cucumber/33547

// https://pt.slideshare.net/edumendes/bdd-com-cucumber-14910137
// http://www.w3ii.com/pt/cucumber/cucumber_quick_guide.html

// http://conf.phprs.com.br/slides/Palestra-Behat.pdf