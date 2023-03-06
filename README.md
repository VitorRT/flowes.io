
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

<br/>
<br/>

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
    updatedAt: "2022-12-10"
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
    updatedAt: "2022-12-10"
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
    updatedAt: "2023-01-02"
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
            start_date: "22/05/2022",
            start_hours: "09:00",
        },
        end: {
            end_date: "25/05/2022",
            end_hours: "09:00"
        }
    },
    label: "#AEEBB4",
    description: "Tarefas do projeto nubeck."
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
    updatedAt: "10/04/2022"
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
    updatedAt: "10/04/2022"
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
        updatedAt: "10/04/2022"
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
        updatedAt: "10/04/2022"
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
    updatedAt: "10/04/2022"
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



> A Documentação ainda está sendo feita 📝 <br/>  Projeto em Desenvolvimento... 🏗
