
# Fundamentos de programação reativa com Reactor e Spring WebFlux (Java) ☕🔃
	
<div style="display: block;">
	<div style="display: block;">
	<div style="display: flex; align-items: center; gap: 2em;">
		Pré-requisitos 
		<img src="https://uploaddeimagens.com.br/images/004/505/016/full/n.png?1686669721" style="width: 50px; height: 50px;" />
	</div>
		- Java; <br/>
		- Spring; <br/>
		- Gradle(ou Maven); <br/>
		- Docker(desejável); <br/>
	</div>
    <div style="display: block;">
		Percurso <br/>
		- Etapa 1 - Programação reativa <br/>
		- Etapa 2 - Spring WebFlux <br/>
   </div>
</div>
<hr />

# Etapa 1 - Programação reativa
_É um paradigma de programação onde temos os nossos dados sendo transmitidos por um fluxo de dados (Streams) que geralmente são assíncronos e os dados são transmitidos para um ou mais Observers (observadores) o paradigma de programação reativa é baseado no pattern observable._

### Vantagens
 - Aplicação mais escalável;
 - Mecanismos mais robustos e flexíveis para tratamento de exceções;

### Desvantagens
 - Curva de aprendizado;
 - Complexidade em lidar com logs;


## Quando usar a arquitetura reativa?
_É importante saber quando usar a programação reativa, por justamente abordar um outro estilo de programação e uma outra forma de pensar. Quando a aplicação receberá muitas requisições em um curto espaço de tempo, a programação reativa é interessante, em uma aplicação que não possui tanta demanda de requisição a programação reativa também vai bem, mas lembre-se sempre dos riscos que você estará correndo._

<hr />

# Manifesto Reativo
_Em 2014 um grupo de desenvolvedores criaram uma segunda versão desse manifesto com 4 pilares que indicam se uma aplicação é reativa. (qualquer linguagem)_

## Pilares do manifesto
 - **Responsividade**: Capacidade da aplicação responder rápido as requisições;
 - **Resiliência**: Capacidade de lidar com falhas e comportamentos inesperados de componentes;
 - **Elasticidade**: Capacidade de manter os 2 pilares anteriores em situações de processamento de grandes quantidades de dados e de voltar à configuração inicial posteriormente;
 - **Guiado por mensagem**: Aplicação se baseia na troca de mensagens entre os componentes de forma assíncrona;



# Etapa 2 - Spring WebFlux

_Módulo inserido no Spring Framework na versão 5 baseado no projeto Reactor para a criação de aplicações não bloqueantes na JVM(Assóncrono)._
_Para aproveitarmos ao máximo do ambiente assíncrono temos a nossa disposição algumas ferramentas/módulos que também trabalham dessa forma._

## Formas de desenvolvimento
 - Seguindo a forma tradicional usando annotations;
 - Novo estilo funcional usando o Handler e o Router;

Vamos utilizar a forma tradicional com as annotations, porém existe a outra nova forma de se desenvolver uma aplicação com o spring web flux.

## Links Úteis
 - [Repositório no Github 👨🏾‍💻]()
-   [Documentação Oficial 📝](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.htm)
- [Manifesto Reativo 🧾](https://www.reactivemanifesto.org)
> Doc by: VitorRT 💌































<!-- Nome do projeto -->
# flowes.io 🌻
<img src="https://i.ibb.co/SwnFYc1/Inserir-um-subt-tulo.png" alt="flowes_icon" style="border-radius: 10px"/>

<!-- Integrantes do grupo -->
<small>RM 95209: Victor Souza Barberino</small>
<br/>
<small>RM 95189: Pedro Luiz Santiago Santana</small>
<br/>
<br/>


<!-- Listagem dos endpoints -->
# Endpoints - Client 🙋🏾‍♂️
- Criar client
- Detalhar client
- Listar clients
- Editar client  
- Apagar client
</br>
</br>

## Cadastro de Client 🔨

<!-- Endereço do recurso -->
`POST` - **flowes/api/v1/client**

**Exemplo de Entrada** 

```js
{
    client_name: "Yukari",
    email: "brunayuuki@gmail.com",
    senha: "exemplo123",
    data_nascimento: "05/03/2004"
}
```

### **Campos da Requisição**

| Campo | Obrigatório | Tipo  | Descrição |
|-------|-------------|-------|-----------|
|client_name   |sim          |texto |O nome informal do cliente que será usado pelo sistema.
|email|sim|texto| O email unico da conta do cliente que servirá como um identificador.
|senha| sim| texto| A senha para poder acessar a conta do cliente, ela será criptografada pelo sistema.
data_nascimento|sim|data|A data de nascimento do cliente.

**Exemplo de Resposta**

```js
{
    id: 1,
    client_name: "Yukari",
    email: "brunayuuki@gmail.com",
    senha: "exemplo123",
    data_nascimento: "05/03/2004",
    createdAt: "10/12/2022",
    updatedAt: "10/12/2022"  
}
```

### **Códigos da Resposta**

| Código | Descrição                            |
|--------|--------------------------------------|
|201     | O cliente foi criado com sucesso.    |
|400     | Os dados enviados são inválidos.     |


--- 


## Detalhar Client 📋

<!-- Endereço do recurso -->
`GET` - **flowes/api/v1/client/{id}**

**Exemplo de Resposta**

```js
{
    id: 1,
    client_name: "Yukari",
    email: "brunayuuki@gmail.com",
    senha: "exemplo123",
    data_nascimento: "05/03/2004",
    createdAt: "10/12/2022",
    updatedAt: "10/12/2022"  
}
```


### **Códigos da Resposta**

| Código | Descrição                            |
|--------|--------------------------------------|
|200     | Os dados do cliente foram retornados.|
|400     | Não existe um cliente com esse ID.   | 

</br>
</br>

---

## Listar Client 📋

<!-- Endereço do recurso -->
`GET` - **flowes/api/v1/client**

**Exemplo de Resposta** 
```js
[
    {
        id: 1,
        client_name: "Yukari",
        email: "brunayuuki@gmail.com",
        senha: "exemplo123",
        data_nascimento: "05/03/2004",
        createdAt: "10/12/2022",
        updatedAt: "10/12/2022"  
    },
    {
        id: 2,
        client_name: "Vitor",
        email: "vitu.barberino@gmail.com",
        senha: "exemplo123",
        data_nascimento: "24/03/2004",
        createdAt: "10/12/2022",
        updatedAt: "10/12/2022"  
    },
]
```
### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados dos clientes foram retornados.  |


--- 


## Editar Client ⚙

<!-- Endereço do recurso -->
`PUT` - **flowes/api/v1/client/{id}**

**Campos da Requisição** 
```js
{
    client_name: "Vituu 🌙",
    email: "vitu.barberino@gmail.com",
    senha: "outrasenha123",
    data_nascimento: "24/03/2004"
}
```

**Regras de Negócio - Edição de Client**

| Campos    | Editável | Considerações |
|-----------|----------|---------------|
|client_name|Sim       |O cliente poderá alterar seu nome caso não tenha gostado.
|email      |Não       |O email não poderá ser alterado, é algo unico do cliente que o sistema identifica. 
|senha      |Sim       |A senha é editável e o cliente poderá editar caso tenha esquecido sua antiga senha.
|data_nascimento|Sim    |A data de nascimento também é editável, caso o cliente tenha colocado uma data errada o mesmo poderá altera-la.
|createdAt  |Não        |O Cliente não poderá editar este campo, ele é gerado automaticamente pelo sistema e permanecerá assim para sempre.
|updatedAt  |Não       |O Cliente não poderá editar este campo, porém ele é atualizado pelo sistema a cada requisição put.

**Exemplo de Resposta** 
```js
{
    id: 2,
    client_name: "Vituu 🌙",
    email: "vitu.barberino@gmail.com",
    senha: "outrasenha123",
    data_nascimento: "24/03/2004",
    createdAt: "10/12/2022",
    updatedAt: "11/12/2022"  
}
```

### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados do cliente foram retornados.  |
|400     | Não existe um cliente com esse ID.    |

---

## Deletar Client 🗑

<!-- Endereço do recurso -->
`DELETE` - **flowes/api/v1/client/{id}**

**Exemplo de Resposta** 
```js
{
     status: 204,
     message: "Cliente deletado com sucesso!"
}
```

### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|204     | O cliente foi deletada com sucesso.    |
|400     | Não existe um cliente com esse ID.    |


</br>
</br>
</br>

---

</br>
</br>
</br> 

<!-- Listagem dos endpoints -->
# Endpoints - WorkSpace 💻
- Criar workspaces
- Detalhar workspaces
- Listar workspaces
- Editar workspaces  
- Apagar workspaces
</br>
</br>

## Cadastro de WorkSpace 🔨

<!-- Endereço do recurso -->
`POST` - **flowes/api/v1/workspace**

 
**Exemplo de Entrada** 

```js
{
    client_id: 2,
    name: "FIAP WORKSPACE",
    deadline: "2023-01-01",
    description: "Espaço de trabalho para serviços da FIAP",
    workspace_photo: "fiap_img.png"
}
```
### **Campos da Requisição**

| Campo | Obrigatório | Tipo  | Descrição |
|-------|-------------|-------|-----------|
|name   |sim          |texto |O nome workspace do cliente.
|deadline|sim|data| O data de prazo para o cliente completar todos os seus projetos da workspace.
|description| não| texto| Uma breve descrição sobre a workspace.
workspace_photo|não|imagem|Uma foto da workspace.

**Exemplo de Resposta** 
```js
{
    id: 1,
     client:{
        id: 2,
        name: "Vitor"
    },
    name: "FIAP WORKSPACE",
    deadline: "2023-01-01",
    description: "Espaço de trabalho para serviços da FIAP",
    workspace_photo: "fiap_img.png",
    createdAt: "2022-12-10",
    updatedAt: "2022-12-10",
    itsComplete: false
}
```

### **Códigos da Resposta**

| Código | Descrição                            |
|--------|--------------------------------------|
|201     | A worskpace foi criada com sucesso.  |
|400     | Os dados enviados são inválidos.     |


---


## Detalhar WorkSpace 📋

<!-- Endereço do recurso -->
`GET` - **flowes/api/v1/workspace/{id}**

**Exemplo de Resposta** 
```js
{
    id: 1,
     client:{
        id: 2,
        name: "Vitor"
    },
    name: "FIAP WORKSPACE",
    deadline: "2023-01-01",
    description: "Espaço de trabalho para serviços da FIAP",
    workspace_photo: "fiap_img.png",
    createdAt: "2022-12-10",
    updatedAt: "2022-12-10",
    itsComplete: false
}
```
### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados da workspace foram retornados.  |
|400     | Não existe uma workspace com esse ID.    |


---


## Listar WorkSpaces 📋

<!-- Endereço do recurso -->
`GET` - **flowes/api/v1/workspace**

**Exemplo de Resposta** 
```js
[
    {   
        id: 1,
         client:{
            id: 2,
            name: "Vitor"
        },
        name: "FIAP WORKSPACE",
        deadline: "2023-01-01",
        description: "Espaço de trabalho para serviços da FIAP",
        workspace_photo: "fiap_img.png",
        createdAt: "2022-12-10",
        updatedAt: "2022-12-10",
        itsComplete: false
    },
]
```

### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados das workspaces foram retornados.  |


---

## Editar WorkSpaces ⚙

<!-- Endereço do recurso -->
`PUT` - **flowes/api/v1/workspace/{id}**

**Campos da Requisição** 
```js
{
    name: "FIAP WORKS",
    deadline: "2023-05-08",
    description: "Espaço de trabalho para serviços da FIAP",
    workspace_photo: "fiap_img2.png",
}
```
**Regras de Negócio - Edição de Workspace**

| Campos    | Editável | Considerações |
|-----------|----------|---------------|
| name      | Sim      | Para caso você tenha escrevido errado ou simplesmente queira mudar. 
| deadline  | Sim      | Para caso você não tenha conseguido atingir o prazo ou queira estender ou diminuir o prazo.
|description | Sim | Para caso você queira mudar a descrição que não tenha te agradado.
workspace_photo | Sim  | Para caso você queira alterar a foto atual da sua workspace.


**Exemplo de Resposta** 
```js
{
    id: 1,
     client:{
        id: 2,
        name: "Vitor"
    },
    name: "FIAP WORKS",
    deadline: "2023-05-08",
    description: "Espaço de trabalho para serviços da FIAP",
    workspace_photo: "fiap_img2.png",
    createdAt: "2022-12-10",
    updatedAt: "2023-01-02",
    itsComplete: false
}
```

### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados da workspace foram retornados.  |
|400     | Não existe uma workspace com esse ID.    |


---

## Deletar WorkSpaces 🗑

<!-- Endereço do recurso -->
`DELETE` - **flowes/api/v1/workspace/{id}**

**Exemplo de Resposta** 
```js
{
     status: 204,
     message: "Workspace deletada com sucesso!"
}
```

### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|204     | A workspace foi deletada com sucesso.    |
|400     | Não existe uma workspace com esse ID.    |

</br>
</br>
</br>

---

</br>
</br>
</br> 


<!-- Listagem dos endpoints -->
# Endpoints - Project 📅
- Criar project
- Detalhar project
- Listar projects
- Editar project  
- Apagar project
</br>
</br>

## Cadastro de Project 🔨

<!-- Endereço do recurso -->
`POST` - **flowes/api/v1/project**

**Exemplo de Entrada** 

```js
{
    workspace_id: 1,
    name: "Nubeck Project",
    deadline: {
        start: {
            start_date: "2022-05-22",
            start_hours: 9,
        },
        end: {
            end_date: "2022-05-22",
            end_hours: 9
        }
    },
    label: "#AEEBB4",
    description: "Tarefas do projeto nubeck.",
    itsComplete: false
}
```

### **Campos da Requisição**

| Campo | Obrigatório | Tipo  | Descrição |
|-------|-------------|-------|-----------|
|workspace_id|Sim|Numero|Para um projeto pertencer a uma workspace é preciso informar uma referência dela, o id é a referência da workspace que o projeto pertence.
|name| Sim | Texto | Nome do projeto, será exibido na tela.
|deadline|Sim|Objeto|Objeto que conterá as informações da deadline do projeto
|start|Sim|Objeto|Objeto que conterá as informações da data de inicio da deadline.
|end|Sim|Objeto|Objeto que conterá as informações da data de término da deadline.
|start_date|Sim|Texto|Data de inicio do projeto.
|start_hour|Sim|Texto|Horário de inicio do projeto.
|end_date|Sim|Texto|Data de término do projeto.
|end_hour|Sim|Texto|Horário de término do projeto.
|label|Sim|Texto|Cor em hexadecimal da label do projeto
|description|Não|Texto|Uma breve descrição do projeto.



**Exemplo de Resposta** 

```js
{
    id: 1,
    workspace: {
        id: 1,
        name: "João Carlos Workspace"
    },
    name: "Nubeck Project",
    deadline: {
        start: {
            start_date: "22/05/2022",
            start_hours: "09:00",
        },
        end: {
            end_date: "25/05/2022",
            end_hours: "09:00"
        }
    },
    label: "#AEEBB4",
    description: "Tarefas do projeto nubeck.",
    createdAt: "10/04/2022",
    updatedAt: "10/04/2022",
    itsComplete: false
}
```

### **Códigos da Resposta**

| Código | Descrição                            |
|--------|--------------------------------------|
|201     | O projeto foi criado com sucesso.    |
|400     | Os dados enviados são inválidos.     |


---


## Detalhar Project 📋

<!-- Endereço do recurso -->
`GET` - **flowes/api/v1/project/{id}**

**Exemplo de Resposta** 

```js
{
    id: 1,
    workspace: {
        id: 1,
        name: "João Carlos Workspace"
    },
    name: "Nubeck Project",
    deadline: {
        start: {
            start_date: "22/05/2022",
            start_hours: "09:00",
        },
        end: {
            end_date: "25/05/2022",
            end_hours: "09:00"
        }
    },
    label: "#AEEBB4",
    description: "Tarefas do projeto nubeck.",
    createdAt: "10/04/2022",
    updatedAt: "10/04/2022",
    itsComplete: false
}
```
### **Códigos da Resposta**

| Código | Descrição                            |
|--------|--------------------------------------|
|200     | Os dados do projeto foram retornados.|
|400     | Não existe um projeto com esse ID.   | 



---

## Listar Project 📋

<!-- Endereço do recurso -->
`GET` - **flowes/api/v1/project**

**Exemplo de Resposta** 

```js
[
    {
        id: 1,
        workspace: {
            id: 1,
            name: "João Carlos Workspace"
        },
        name: "Nubeck Project",
        deadline: {
            start: {
                start_date: "22/05/2022",
                start_hours: "09:00",
            },
            end: {
                end_date: "25/05/2022",
                end_hours: "09:00"
            }
        },
        label: "#AEEBB4",
        description: "Tarefas do projeto nubeck.",
        createdAt: "10/04/2022",
        updatedAt: "10/04/2022",
        itsComplete: false
    },
    {
        id: 2,
        workspace: {
            id: 1,
            name: "João Carlos Workspace"
        },
        name: "Nubeck Project Seasson 2",
        deadline: {
            start: {
                start_date: "22/06/2022",
                start_hours: "09:00",
            },
            end: {
                end_date: "25/06/2022",
                end_hours: "09:00"
            }
        },
        label: "#F4D1A8",
        description: "Tarefas do projeto nubeck.",
        createdAt: "10/04/2022",
        updatedAt: "10/04/2022",
        itsComplete: false
    }
]
```

### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados do projeto foram retornados.  |


---

## Editar Project ⚙

<!-- Endereço do recurso -->
`PUT` - **flowes/api/v1/project/{id}**

```js
{
    name: "Nubeck Project 💵",
    deadline: {
        start: {
            start_date: "22/05/2022",
            start_hours: "09:00",
        },
        end: {
            end_date: "25/05/2022",
            end_hours: "09:00"
        }
    },
    label: "#AEEBB4",
    description: "Tarefas do projeto nubeck.",
}
```

**Regras de Negócio - Edição de Project**

| Campos    | Editável | Considerações |
|-----------|----------|---------------|
|name       |Sim       |O nome do projeto será editável, caso o usuário não tenha gostado.
|deadline   |Sim       | O objeto que contém os dados da deadline é editável, caso o usuário queira mudar o prazo.
|start|Sim|O objeto da data de início é editável, caso o usuário queira mudar a data ou a hora.
|end|Sim|O objeto da data de término é editável, caso o usuário queira mudar a data ou a hora.
|start_date|Sim|Esse campo é editável, caso o usuário queira alterar a data de inicio.
|start_hours|Sim|Esse campo é esitável, caso o usuário queira alterar a hora de início.
|end_date|Sim|Esse campo é término, caso o usuário queira alterar a data de inicio.
|end_hours|Sim|Esse campo é editável, caso o usuário queira alterar a hora de término.


**Exemplo de Resposta**
```js
{   
    id: 1,
    workspace: {
            id: 1,
            name: "João Carlos Workspace"
        },
    name: "Nubeck Project 💵",
    deadline: {
        start: {
            start_date: "22/06/2022",
            start_hours: "09:00",
        },
        end: {
            end_date: "25/06/2022",
            end_hours: "09:00"
        }
    },
    label: "#F4D1A8",
    description: "Tarefas do projeto nubeck.",
    createdAt: "10/04/2022",
    updatedAt: "10/04/2022",
    itsComplete: false
}
```

### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados do projeto foram retornados.  |
|400     | Não existe uma projeto com esse ID.    |


---

## Deletar Project 🗑

<!-- Endereço do recurso -->
`DELETE` - **flowes/api/v1/project/{id}**

**Exemplo de Resposta** 
```js
{
     status: 204,
     message: "Project deletada com sucesso!"
}
```

### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|204     | O Projeto foi deletada com sucesso.    |
|400     | Não existe um projeto com esse ID.    |

</br>
</br>
</br>

---

</br>
</br>
</br> 


<!-- Listagem dos endpoints -->
# Endpoints - Categorie 🧮
- Criar categorie
- Detalhar categories
- Listar categorie
- Editar categorie  
- Apagar categorie
</br>
</br>

## Cadastro de Categorie 🔨

<!-- Endereço do recurso -->
`POST` - **flowes/api/v1/categorie**

 
**Exemplo de Entrada** 

```js
{
    project_id: 1,
    name: "Do Today 👇",
    tasks_day: "02/11/2022"
}
```
### **Campos da Requisição**

| Campo | Obrigatório | Tipo  | Descrição |
|-------|-------------|-------|-----------|
|project_id|sim|numero|O id do projeto que essa categoria pertence.|
|name|sim|texto|O nome da categoria.|
|tasks_day|sim|data|A data do dia que as terefas serão realizadas.|

**Exemplo de Resposta** 
```js
{
   id: 1, 
   project: {
        id: 1,
        name: "Nubeck Project"
   },
   name: "Do Today 👇",
   tasks_day: "02/11/2022",
   createdAt: "02/11/2022",
   updatedAt: "02/11/2022",
   itsComplete: false
}
```

### **Códigos da Resposta**

| Código | Descrição                            |
|--------|--------------------------------------|
|201     | A categoria foi criada com sucesso.  |
|400     | Os dados enviados são inválidos.     |


---


## Detalhar Categorie 📋

<!-- Endereço do recurso -->
`GET` - **flowes/api/v1/categorie/{id}**

**Exemplo de Resposta** 

```js
{
   id: 1, 
   project: {
        id: 1,
        name: "Nubeck Project"
   },
   name: "Do Today 👇",
   tasks_day: "02/11/2022",
   createdAt: "02/11/2022",
   updatedAt: "02/11/2022",
   itsComplete: false
}
```
### **Códigos da Resposta**

| Código | Descrição                            |
|--------|--------------------------------------|
|200     | Os dados da categoria foram retornados.|
|400     | Não existe uma categoria com esse ID.   | 



---


## Listar Categories 📋

<!-- Endereço do recurso -->
`GET` - **flowes/api/v1/categorie**

**Exemplo de Resposta** 

```js
[
    {
        id: 1, 
       project: {
            id: 1,
            name: "Nubeck Project"
       },
       name: "Do Today 👇",
       tasks_day: "02/11/2022",
       createdAt: "02/11/2022",
       updatedAt: "02/11/2022",
       itsComplete: false
    },
    {
        id: 2, 
       project: {
            id: 1,
            name: "Nubeck Project"
       },
       name: "Do Tomorrow 👇",
       tasks_day: "03/11/2022",
       createdAt: "02/11/2022",
       updatedAt: "02/11/2022",
       itsComplete: false    
    }
]
```

### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados da categoria foram retornados.  |


---


## Editar Categorie ⚙

<!-- Endereço do recurso -->
`PUT` - **flowes/api/v1/categorie/{id}**

**Campos da Requisição** 
```js
{
    name: "Daily Tasks",
    tasks_day: "01/11/2022"
}
```

**Regras de Negócio - Edição de Client**

| Campos    | Editável | Considerações |
|-----------|----------|---------------|
|name       |sim       | O nome da categoria é editável caso o usuário não tenha gostado.|
|tasks_day  |sim       | A data da categoria é editável caso o usuário queira alterar o dia das tarefas|


**Exemplo de Resposta** 
```js
{
    id: 1, 
       project: {
            id: 1,
            name: "Nubeck Project"
       },
       name: "Daily Tasks",
       tasks_day: "01/11/2022",
       createdAt: "02/11/2022",
       updatedAt: "02/11/2022",
       itsComplete: false  
}
```

### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados da categoria foram alterados e retornados.   |
|400     | Não existe uma categoria com esse ID.       |

---

## Deletar Categorie 🗑

<!-- Endereço do recurso -->
`DELETE` - **flowes/api/v1/project/{id}**

**Exemplo de Resposta** 
```js
{
     status: 204,
     message: "Categoria deletada com sucesso!"
}
```

### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|204     | O Projeto foi deletada com sucesso.    |
|400     | Não existe um projeto com esse ID.    |

</br>
</br>
</br>

---

</br>
</br>
</br> 



<!-- Listagem dos endpoints -->
# Endpoints - Task ✅
- Criar task
- Detalhar tasks
- Listar task
- Editar task  
- Apagar task
</br>
</br>

## Cadastro de Task 🔨

<!-- Endereço do recurso -->
`POST` - **flowes/api/v1/task**

 
**Exemplo de Entrada** 

```js
{
     categorie_id: 1,
     name: "Development Route Home",
     role: "Front-End Development",
     task_label: "#39DBFF",
     deadline_task: {
        start_hour: "09:00",
        end_hour: "11:00"
     }
}
```
### **Campos da Requisição**

| Campo | Obrigatório | Tipo  | Descrição |
|-------|-------------|-------|-----------|
|categorie_id|sim|numero|O id da categoria que a terefa pertence.|
|name|sim|texto|O nome da tarefa.|
|role|sim|texto|A função/papel que a tarefa irá exercer.|
|task_label|sim|texto|Uma cor hexadecimal que representará a tarefa.|
|deadline_task|sim|objeto|Um objeto que conterá os dados da deadline da tarefa.|
|start_hour|sim|texto|Hora de inicio da tarefa.|
|end_hour|sim|texto|Hora de término da tarefa.|

**Exemplo de Resposta** 
```js
{
       categorie_id: 1,
     name: "Development Route Home",
     role: "Front-End Development",
     task_label: "#39DBFF",
     deadline_task: {
        start_hour: "09:00",
        end_hour: "11:00"
     },
     createdAt:"02/05/2022",
     updatedAt: "02/05/2022",
     check: false
 }
```

### **Códigos da Resposta**

| Código | Descrição                            |
|--------|--------------------------------------|
|201     | A tarefa foi criada com sucesso.  |
|400     | Os dados enviados são inválidos.     |


---

## Detalhar Task 📋

<!-- Endereço do recurso -->
`GET` - **flowes/api/v1/task/{id}**

**Exemplo de Resposta** 

```js
{
      categorie_id: 1,
     name: "Development Route Home",
     role: "Front-End Development",
     task_label: "#39DBFF",
     deadline_task: {
        start_hour: "09:00",
        end_hour: "11:00"
     },
     createdAt:"02/05/2022",
     updatedAt: "02/05/2022",
     check: false
}
```
### **Códigos da Resposta**

| Código | Descrição                            |
|--------|--------------------------------------|
|200     | Os dados da tarefa foram retornados. |
|400     | Não existe uma tarefa com esse ID.   | 



---



## Listar Tasks 📋

<!-- Endereço do recurso -->
`GET` - **flowes/api/v1/task**

**Exemplo de Resposta** 

```js
[
    {
         categorie_id: 1,
         name: "Development Route Home",
         role: "Front-End Development",
         task_label: "#39DBFF",
         deadline_task: {
            start_hour: "09:00",
            end_hour: "11:00"
         },
         createdAt:"02/05/2022",
         updatedAt: "02/05/2022",
         check: false
    }
]
```

### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados das tarefas foram retornados.   |


---



## Editar Task ⚙

<!-- Endereço do recurso -->
`PUT` - **flowes/api/v1/categorie/{id}**

**Campos da Requisição** 
```js
{
    name: "Development Route Perfil",
    role: "Front-End Development",
    deadline_task: {
        start_hour: "09:00",
        end_hour: "11:00"
     },
}
```

**Regras de Negócio - Edição de Client**

| Campos    | Editável | Considerações |
|-----------|----------|---------------|
|name       |sim       | O nome da tarefa é editável caso o usuário não tenha gostado.|
|role       |sim       | O nome da role é editável caso o usuário não tenha gostado.
|deadline_task  |sim       | O objeto que contem as informações da dealine da tarefa é editável caso o usuário não tenha gostado|


**Exemplo de Resposta** 
```js
{
     categorie_id: 1,
     name: "Development Route Perfil",
     role: "Front-End Development",
     task_label: "#39DBFF",
     deadline_task: {
        start_hour: "09:00",
        end_hour: "11:00"
     },
     createdAt:"02/05/2022",
     updatedAt: "02/05/2022",
     check: false
}
```

### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados da tarefa foram alterados e retornados.   |
|400     | Não existe uma tarefa com esse ID.        |

---


## Deletar Task 🗑

<!-- Endereço do recurso -->
`DELETE` - **flowes/api/v1/task/{id}**

**Exemplo de Resposta** 
```js
{
     status: 204,
     message: "Categoria deletada com sucesso!"
}
```

### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|204     | O Projeto foi deletada com sucesso.      |
|400     | Não existe um projeto com esse ID.       |

</br>
</br>

> Versão Alpha da Flowes Api 💻
