#language:pt
#ecoding:utf8
#author:Romário Medeiros

#Eu como usuario quero fazer os passos do cenario final.

Funcionalidade: Fazer os passos do cenario final

Contexto: Abrir a pagina de teste
	Dado que eu entro no site de teste para a vaga de qa
	Entao devera exibir a imagem webjump

Cenario: Fazer os passos do cenario final
	Dado que devera preencher o campo yourFirstName
	E clico no botao one
	E devera selecionar a opcao optionThree
	E devera selecionar a opcao exampleTwo
	Entao devera exibir a logo do Selenium WebDriver
	