# Santander Dev Week 2024

Java RESTful API criada para a Santander Dev Week.

Desafio Desenvolvedor Backend - API REST para Cachaças Canuto
Este projeto é uma API REST desenvolvida como parte do teste para a vaga de Desenvolvedor Backend na Monomyto Game Studios, voltada para a empresa fictícia Cachaças Canuto. O objetivo é modernizar a gestão da empresa e facilitar a venda de produtos pela internet.

Arquivos Disponibilizados
O projeto utiliza os seguintes arquivos fornecidos pelo Sr. Victor Canuto:

Catalogo.json
Clientes.json
Vendas.json

# Requisitos e Funcionalidades Principais:
Desenvolvimento de uma API REST seguindo boas práticas de arquitetura de código e simplicidade.
Utilização do protocolo HTTP e comunicação com formato JSON.
Implementação de funcionalidades como listagem de clientes e produtos, listagem de vendas com paginação, e relatórios de vendas por cliente e por produto.
Testes unitários para garantir a integridade das funcionalidades desenvolvidas.
Instruções para Execução do Projeto

# Para rodar o projeto em um ambiente local (Linux ou Windows):

Clone o repositório do projeto do GitHub.
Certifique-se de ter o Java 15 e o Gradle instalados.
Configure o banco de dados PostgreSQL conforme necessário (opcional).
Execute o comando ./gradlew bootRun para iniciar a aplicação.
Acesse a API localmente através do navegador ou ferramentas como cURL ou Postman.
Detalhes Adicionais
O projeto foi estruturado para facilitar a manutenção e leitura do código, seguindo práticas de clean code e atenção aos detalhes.
Não é necessário desenvolver um frontend para visualização das informações.
As funcionalidades foram implementadas considerando requisitos de busca textual, filtros por data e outras opções avançadas de consulta.

## Principais Tecnologias
 - **Java 15**: Utilizaremos a versão LTS mais recente do Java para tirar vantagem das últimas inovações que essa linguagem robusta e amplamente utilizada oferece;
 - **Spring Boot 3**: Trabalharemos com a mais nova versão do Spring Boot, que maximiza a produtividade do desenvolvedor por meio de sua poderosa premissa de autoconfiguração;
 - **Spring Data JPA**: Exploraremos como essa ferramenta pode simplificar nossa camada de acesso aos dados, facilitando a integração com bancos de dados SQL;
 - **OpenAPI (Swagger)**: Vamos criar uma documentação de API eficaz e fácil de entender usando a OpenAPI (Swagger), perfeitamente alinhada com a alta produtividade que o Spring Boot oferece;
 


## IMPORTANTE

Este projeto foi construído com um viés totalmente educacional para a DIO. Por isso, disponibilizamos uma versão mais robusta dele no repositório oficial da DIO:

### [digitalinnovationone/santander-dev-week-2023-api](https://github.com/digitalinnovationone/santander-dev-week-2023-api)

Lá incluímos todas os endpoints de CRUD, além de aplicar boas práticas (uso de DTOs e refinamento na documentação da OpenAPI). Sendo assim, caso queira um desafio/referência mais completa é só acessar 👊🤩
