# language: pt

@funcionalidadetest
Funcionalidade: CarrinhodeCompras
	
Contexto: Essa feature serve para testar adição de produtos no carrinho

	Como um dono de site
	Eu quero que os usuarios possam adicionar produtos ao carrinho
	Para que possa proporcionar mais comodidade em sua experiencia de compra


@pesquisaeadicionanocarrinho
Cenario: Sucesso na Adicao de Produtos no Carrinho de Compras

Dado um usuario que acesse a home do site "http://demo.cs-cart.com/"
Quando clicar no campo Procurar Produtos 
E pesquisar pelo produto "Batman"
E no resultado da pesquisa clicar no produto "Batman: Arkham City (X360)"
E na tela do produto clicar em adicionar ao carrinho
E clicar no Carrinho de Compras apresentando a respectiva tela
Entao o produto devera ser apresentado no carrinho


##Criar pages orientada a funcionalidade nesse caso pra economizar tempo
