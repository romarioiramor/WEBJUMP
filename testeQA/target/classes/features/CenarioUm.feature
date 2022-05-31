#language:pt
#ecoding:utf8
#author:Romário Medeiros

#Eu como usuario quero clicar nos botões one, two e four.

Funcionalidade: Clicar nos botoes one, two e four

Contexto: Abrir a pagina de teste
	Dado que eu entro no site de teste para a vaga de qa
	Entao devera exibir a imagem webjump

Cenario: Clicar nos botões one, two e four
	Dado clico no botao one
	E clico no botao two
	E clico no botao four
	E devera exibir somente o botao three "Three"
	E devera clicar no botao one do iframe buttons
	E devera clicar no botao two do iframe buttons
	E devera clicar no botao four do iframe buttons
	Entao devera exibir somente o botao three "Three" do iframe buttons