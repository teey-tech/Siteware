
1: As decisões tecnicas e arquiteturais do meu projeto foram  

  Tecnologias e Plataformas: java com o framework spring boot o sistema de gerenciamento de banco de dados foi o MySQL 


  Arquitetura: a arquitetura utilizada foi a de MVC-S(Model-View-Controller-Service) 

  Gerenciamento de Dados: Decidi utilizar um banco de dados relacional sendo ele o Mysql

  Interfaces de Usuário: Utilizei HTML, CSS, BOOTSTRAP, JAVASCRIPT, JQUERY e utilizei o Thymeleaf para facilitar o uso dos templates


  Controle de Versão e Colaboração: Github


2: Os frameworks que foram utilizados foram o Spring e o Thymeleaf eu gosto de trabalhar com Spring acredito que seja um framework bem completo e simples de usar e o uso do Thymeleaf foi pelo fato de eu precisar de algo leve e simples que conseguisse dar um bom controle aos meus templates.

3: O projeto pode ser executado em qualquer IDE eu utilizei o visual studio Code o banco de dados que utilizei foi o Mysql entao provavelmente vai ter algum conflito de usuario e senha pra resolver isso é só alterar o username e o password do application.properties


o sistema possui 2 sistemas de cadastro ou seja a parte administrativa feito para as pessoas que trabalham na loja cadastrarem produtos e outros funcionarios 
e o segundo é aonde os clientes irão ter acesso aos produtos e poderão efetuar a compra


para acessar o portal de admin é so digitar:

localhost:8080/admin 

como estou utilizando o spring security e ja inicio o sistema com um usuario padrao para login sendo ele 

username: siteware



password: siteware

com isso o usuario logara no sistema onde podera cadastrar funcionarios, produtos para serem exibidos no front dos clientes para funcionarios e clientes temos a opção completa do CRUD 

as imagems do produto são adicionadas por URL então pode ser pega de qualquer site de lojas ou imagens que tenham um url


para acessar a area de cliente basta digitar :

localhost:8080/   

la estará a home que exibira os produtos adicionados na parte de admin nesta area o cliente pode adicionar o produto no carrinho checar o carrinho de compra dependendo da quantidade a promoção ira tomar efeito por enquanto só tem duas promoções a 1 por 2 e a 3 pague 10 

feito a compra o cliente pode finalizar a compra e escolher o metodo de pagamento no final ira exibir uma mensagem de compra concluida.



Atualizações necessarias futuramente:


  1: não permitir que o mesmo Email se cadastre no sistema

  2: quando atualizar um funcionario ele não precisar digitar a senha de novo

  3: fazer a contagem de estoque de produtos


  4: restringir compra quando produto não estiver no estoque
  
