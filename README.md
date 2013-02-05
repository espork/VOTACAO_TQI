VOTACAO_TQI
===========

. Tecnologias utilizadas : Vraptor, Spring, Hibernate 3, Tomcat 6 e MySql.

. Instruções : 

1 - Executar o script 04022013_INIT_DATABASE.sql
2 - Executar o scritp 04021013_LOAD_DATA.sql
3 - Configurar o hibernate.cfg.xml com as configurações do banco

. Descrição
 - A aplicação permite ao usuário votar em uma das três opções de mascote para representar a Copa do Mundo 2014 no Brsil.
 - O usuário só poderar ver o resultado parcial da enquete quando o número de votos atingir uma determinada quantidade
 ( parâmetro configurado no web.xml).
 - A aplicação certifica-se de que a votação é realizada por uma pessoa através do Captcha na página de votação. 
 - A aplicação permite que o usuário selecione dois idiomas (Inglês e Português).
 

. Itens que não foram implementados

1 - Testes unitários
