# language: pt

@funcionalidadetest
Funcionalidade: Logout

	##Escrevendo estorias de usuario
	
	##A fim de proporcionar mais segurança na aplicação
	##Como dono do site
	##Eu gostaria de que os usuarios efetuassem login
	
	##Com o objetivo de..
	##Como...
	##Eu preciso..

Contexto: Essa feature é para testar funcionalidades referentes a logout do site

	Como um dono de site
	Eu quero que os usuarios faca logout no ambiente
	Para que possa proporcionar mais seguranca na aplicacao/site

##Fundo: Nesse caso vou usar aqui apenas os steps iniciais "Dado e Quando" pra cada cenario de teste e completar com o "Então" resultado esperado dentro dos cenarios

@logout
Cenario: Sucesso no Logout para Usuários Logados
Dado um usuario logado no site e na pagina practice
Quando o usuario clicar em logout na aba home
Entao ele ira para a pagina deslogada do site
E nao conseguira acessar a tela pratice apresentando a tela de login

##@logout
##Cenario: Logout Efetuado com Sucesso
##Quando o usuario solicitar logout na pagina
##Entao ele nao podera mais acessar a pagina "Practice" do site

##@Featuretest       
##Feature: Login
##Description: Essa feature é para testar funcionalidades referentes a login/logout do site

##@login
##Scenario: Sucesso no Login com Valores Validos
##Given	 que o usuario esta na Home
##When  o usuario informar um "Username" e "Senha" corretos
##Then  ele acessa a pagina "Practice" do site

##@logout
##Scenario:	 Logout Efetuado com Sucesso
##When	 o usuario solicitar logout na pagina
##Then	 ele não poderá acessar a pagina 'Practice' do site


#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios 
#<> (placeholder)
#""
## (Comments)

#Sample Feature Definition Template
##@tag
##Feature: Title of your feature
##	I want to use this template for my feature file

##@tag1
##Scenario: Title of your scenario
##Given I want to write a step with precondition
##	And some other precondition
##When I complete action
##	And some other action
##	And yet another action
##Then I validate the outcomes
##	And check more outcomes

##@tag2
##Scenario Outline: Title of your scenario outline
##Given I want to write a step with <name>
##When I check for the <value> in step
##Then I verify the <status> in step

##Examples:
##    | name  |value | status |
##    | name1 |  5   | success|
##    | name2 |  7   | Fail   |


    