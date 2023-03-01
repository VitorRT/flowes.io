
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
    data_nascimento: "05/03/2004",
    createdAt: "10/12/2022", /* Gerado automaticamente */
    updatedAt: "10/12/2022"  /* Gerado automaticamente */
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
    data_nascimento: "24/03/2004",
    createdAt: "10/12/2022",
    updatedAt: "10/12/2022" /* atualizado automaticamente */ 
}
```
**Regras de Negócio - Edição de Client**

| Campos    | Editável | Considerações |
|-----------|----------|---------------|
|client_name|Sim       |O cliente poderá alterar seu nome caso não tenha gostado.
|email      |Não       |O email não poderá ser alterado, é algo unico que o identifica no sistema. 
|senha      |Sim       |A senha é editável e o cliente poderá editar caso tenha esquecido sua antiga senha.
|data_nascimento|Sim    |A data de nascimento também é editável, caso o cliente tenha colocado uma data errada o mesmo poderá altera-la.
|createdAt  |Não        |O Cliente não poderá editar este campo, ele é gerado automaticamente pelo sistema e permanecerá assim para sempre.
|updatedAt  |Não       |O Cliente não poderá editar este campo, porém ele é atualizado pelo sistema a cada requisição put.


---

## Deletar Client 🗑

<!-- Endereço do recurso -->
`DELETE` - **flowes/api/v1/client/{id}**

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
    workspace_photo: "fiap_img.png",
    createdAt: "2022-12-10", /* Gerado automaticamente */
    updatedAt: "2022-12-10"  /* Gerado automaticamente */
}
```
### **Campos da Requisição**

| Campo | Obrigatório | Tipo  | Descrição |
|-------|-------------|-------|-----------|
|name   |sim          |texto |O nome da sua workspace
|deadline|sim|data| O data de prazo para você completar todos os projetos da sua workspace
|description| não| texto| Uma breve descrição sobre sua workspace
workspace_photo|não|imagem|Uma foto da sua workspace

**Exemplo de Resposta** 
```js
{
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
| client_id | Não      | Uma workspace sempre pertencerá unicamente a uma conta.|
| name      | Sim      | Para caso você tenha escrevido errado ou simplesmente queira mudar. 
| deadline  | Sim      | Para caso você não tenha conseguido atingir o prazo ou queira estender ou diminuir o prazo.
|description | Sim | Para caso você queira mudar a descrição que não tenha te agradado.
workspace_photo | Sim  | Para caso você queira alterar a foto atual da sua workspace.
createdAt | Não | Esse campo é gerado automaticamente pelo sistema, uma vez gerado jamais poderá ser alterado.
|updatedAt | Não | Esse campo não é editável por você, o próprio sistema o altera a cada atualização.

**Exemplo de Resposta** 
```js
{
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

<br/>

> A Documentação ainda está sendo feita 📝 <br/>  Projeto em Desenvolvimento... 🏗
