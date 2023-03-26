# Teste prático - Mob4Pay!

Olá, esta é a versão final do teste prático feito para Mob4Pay.


# Descrição do teste
Precisamos que seja liberado uma api utilizando tecnologia Java com Spring Boot.  
- Essa API deverá fornecer dados de clientes fictícios para que algum front possa  
consumi-la, precisamos que seja retornado os seguintes campos:  
- Nome do Cliente  
- Idade  
- Endereço  
- Cidade  
- Estado  
- CPF  
- A api deverá consultar esses dados de alguma fonte de dados, seja ela, um arquivo  
json, banco de dados MongoDB ou qualquer outro que desejar, não sendo permitido  
a inclusão desses dados hardcoded.

## Informações sobre o desenvolvimento
- Usado MongoDB para armazenar dados consumidos, logo, necessita ter um MongoDB no local de teste
- Após o Spring carregar todo seu contexto, é acionado um PostConstruct onde é dado o início de captura de dados para armazenamento.
	- Primeira tentativa de obter dados é via API, os dados das URLs destas APIs estão no application-*.yaml
	- Caso a tentativa de consumir as APIs falhe, e fique uma lista vazia, é usada uma alternativa lendo arquivos locais que se encontram na pasta raiz deste
	- Não há outra forma de armazenar dados além dos existentes
- Existe um docker-compose em caso de necessidade para subir uma image do MongoDB já com as devidas configurações

## Tecnologias usadas
- Java 17 com Spring Boot
- Maven
- MongoDB
- Dependências:
	- Lombok
	- Spring Cloud OpenFeign
	- Java Faker
	- JUnit
	- Mockito
	- Starter Web
	- Starter Data MongoDB

## Testes

O projeto contém testes unitários, verificando métodos e consumindo banco de dados de teste

## Como testar o projeto

- Ferramentas necessárias:
	- Java 17
	- Foi usado Intellij para o desenvolvimento, embora também seja possível em outra IDE como Eclipse
	- Maven
	- MongoDB
	- Postman ou Navegador
- Ao finalizar o processo de importação, adicionar o ambiente de desenvolvimento como 'local', seguindo o application-local.yaml
- Como já mencionado, ao iniciar o projeto, o mesmo irá carregar as informações necessárias para que a API seja consumida
	- API para teste
		- Method: GET
		- Url: localhost:8080/users
		- Não necessita, para este projeto, autenticação

## Imagens

- Tests:
![image](https://user-images.githubusercontent.com/7550133/227798337-31fcbd74-5700-45ae-935b-b750dcbb9b0a.png)

- Application UP
![image](https://user-images.githubusercontent.com/7550133/227798404-86f39451-4cc0-489b-8af2-3814ab2d156a.png)

- Database com dados
![image](https://user-images.githubusercontent.com/7550133/227798497-f1db0ce9-c8fa-4157-a315-2dfdb8838604.png)

- Postman Response
![image](https://user-images.githubusercontent.com/7550133/227798541-5b3e6457-c2a5-42b5-ad33-f01b7d8dab57.png)
