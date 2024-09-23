
![image](https://github.com/user-attachments/assets/59fe45d6-c40b-4087-a88e-64d9c1ab47e9)


# Automação Selenium Webdriver - Java 

Esse projeto é um exemplo de teste automatizado com Selenium Webdriver, Java, Junit5 rodando com maven e integrando com reports do Allure.

Site usado para os testes - https://www.demoblaze.com/

## Instalação & Configuração

```bash
Java - https://www.oracle.com/br/java/technologies/downloads/
Maven - https://maven.apache.org/install.html
Junit5 - https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
IDE - Intellij - https://www.jetbrains.com/help/idea/installation-guide.html
Allure Reports - https://allurereport.org/
```

## Comando mvn

"mvn clean install" - Instalação das dependências
"mvn clean test" -  Roda todos os testes que estão no pacote Tests
"mvn clean test -DfailIfNoTests=false  -Dtest=Tests.loginUserTest" - Roda somente um arquivo nesse exemplo 'loginUserTest'

![image](https://github.com/user-attachments/assets/0f7fc1f2-d081-4b90-af0b-574a2341b2d0)

## Reports do Allure

Comando para gerar reports:

"allure serve allure-results target/allure-results/" 

![image](https://github.com/user-attachments/assets/e3d34349-d07f-4e6f-9f69-9c03063a588b)


![image](https://github.com/user-attachments/assets/65601414-ba03-4410-910c-4775aeb18985)


![image](https://github.com/user-attachments/assets/4dfe7594-d986-47dd-b77d-48be58375469)

