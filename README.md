
1: As decisões tecnicas e arquiteturais do meu projeto foi baseado em um sistema de loja simples para que eu podesse terminar a tempo de ser entregue.

2: Os frameworks que foram utilizados foram o Spring e o Thymeleaf eu gosto de trabalhar com Spring acredito que seja um framework bem completo e simples de usar e o uso do Thymeleaf foi pelo fato de eu precisar de algo leve e simples de ser usado o thymeleaf apresenta tudo isso


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
