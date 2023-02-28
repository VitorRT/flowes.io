
<!-- Nome do projeto -->
# flowes.io 🌻

<!-- Integrantes do grupo -->
RM 95209: Victor Souza Barberino

RM 95189: Pedro Luiz Santiago Santana
<br/>
<br/>

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

<!-- Colocar a versão é importante para compatibilidade  --> 
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
    createdA: "2022-12-10",
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
### **Códigos da Resposta**

| Código | Descrição                                |
|--------|------------------------------------------|
|200     | Os dados da workspace foram retornados.  |
|400     | Não existe uma workspace com esse ID.    |


---

## Editar WorkSpaces 📋

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

## Deletar WorkSpaces 📋

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