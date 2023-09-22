# EvelynTesteApi
Beatriz Chagas e Elis Torres – 3° DS ETIM | Professora: Aline F. Brito

Aplicativo desenvolvido como fonte de informações sobre o livro 'Os sete maridos de evelyn hugo', 
com o objetivo de ser uma ferramenta auxiliar para os fans do livro em geral.
No app, encontramos: 

1. Informações sobre cada marido; 
1. Infomação sobre Célia;
1. Informação sobre a autora do livro; 
1. filmes citados no livro;
1. pesquisa de outros livros com api do google books 
e etc.



## Código da conexão da API (própria) com as telas relacionadas pode ser encontrado na pasta localizada na branche main. 

>A API ainda não está hospedada, portanto, não retornará dados e no momento não existe URL.
O repositório tem como objetivo apresentar apenas o código de conexão que será utilizado futuramente.


Dados vindos da API: </br>
Tela Autora - dados recebidos da API: nome, biografia, premios e outros livros;

</br>

## Métodos disponíveis


### **AUTORA**

**GET:** api/Autora – Exibe dados cadastrados na tabela Autora


![tbautora](https://github.com/Chagasbiaa/APIevelynhugo/assets/101807222/1bff0a20-66eb-48e5-a439-82527188eecb)

**POST:**  api/Autora – Cadastra dados na tabela Autora


**PUT:**  api/Autora - Atualiza dados já cadastrados na tabela Autora


**DELETE:** api/Autora – Deleta dados já cadastrados na tabela Autora

</br>


### **PERSONAGENS**


**GET:** api/Personagens - Exibe dados cadastrados na tabela Personagens

![tbpersonagens](https://github.com/Chagasbiaa/APIevelynhugo/assets/101807222/f793cbbb-8ca1-4e5d-8751-4038dcafc85b)

 
**POST:** api/Personagens - Cadastra dados na tabela Personagens


**PUT:** api/Personagens - Atualiza dados já cadastrados na tabela Personagens


**DELETE:** api/Personagens - Deleta dados já cadastrados na tabela Personagens


</br>

### **RELACIONAMENTOS**

**GET:** api/Relacionamentos - Exibe dados cadastrados na tabela Relacionamentos


![tbrelacionamentos](https://github.com/Chagasbiaa/APIevelynhugo/assets/101807222/cea1491a-4510-481e-9df5-1c232ab685e9)


 
**POST:** api/Relacionamentos - Cadastra dados na tabela Relacionamentos


**PUT:**  api/Relacionamentos - Atualiza dados já cadastrados na tabela Relacionamentos


**DELETE:** api/Relacionamentos - Deleta dados já cadastrados na tabela Relacionamentos
