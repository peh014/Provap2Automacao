const url = 'http://127.0.0.1:8080/clients'; // Substitua pela URL correta da sua API de clientes

// Função para visualizar clientes
function viewClients() {
    const tableBody = document.getElementById("table-body");
    fetch(url)
        .then((resp) => resp.json())
        .then((clients) => {
            tableBody.innerHTML = ""; // Limpa a tabela antes de exibir os dados
            clients.forEach((client) => {
                const trBody = `
                    <tr>
                        <th scope="row">${client.idCliente}</th>
                        <td>${client.nome}</td>
                        <td>${client.cpf}</td>
                        <td>${client.celular}</td>
                        <td>${client.cnh}</td>
                    </tr>`;
                tableBody.innerHTML += trBody;
            });
        })
        .catch((error) => console.log(error));
}

// Função para adicionar um novo cliente
function addClient() {
    const nome = document.getElementById("clientname").value;
    const cpf = document.getElementById("clientcpf").value;
    const celular = document.getElementById("clientphone").value;
    const cnh = document.getElementById("clientcnh").value;

    const client = {
        nome: nome,
        cpf: cpf,
        celular: celular,
        cnh: cnh,
    };

    fetch(url, {
        method: 'POST',
        body: JSON.stringify(client),
        headers: { 'Content-type': 'application/json' }
    })
    .then((response) => response.json())
    .then((clientjson) => {
        console.log('Cliente adicionado:', clientjson);
        viewClients(); // Após adicionar, atualiza a visualização dos clientes
    })
    .catch((error) => console.log(error));
}

// Função para atualizar um cliente existente
function updateClient() {
    const id = document.getElementById("clientid").value;
    const nome = document.getElementById("clientname").value;
    const cpf = document.getElementById("clientcpf").value;
    const celular = document.getElementById("clientphone").value;
    const cnh = document.getElementById("clientcnh").value;

    const client = {
        nome: nome,
        cpf: cpf,
        celular: celular,
        cnh: cnh,
    };

    fetch(`${url}/${id}`, {
        method: 'PUT',
        body: JSON.stringify(client),
        headers: { 'Content-type': 'application/json' }
    })
    .then((response) => response.json())
    .then((clientjson) => {
        console.log('Cliente atualizado:', clientjson);
        viewClients(); // Após atualizar, atualiza a visualização dos clientes
    })
    .catch((error) => console.log(error));
}

// Função para excluir um cliente
function deleteClient() {
    const id = document.getElementById("clientid").value;

    fetch(`${url}/${id}`, {
        method: 'DELETE',
    })
    .then((response) => response.json())
    .then((clientjson) => {
        console.log('Cliente excluído:', clientjson);
        viewClients(); // Após excluir, atualiza a visualização dos clientes
    })
    .catch((error) => console.log(error));
}
