const url = 'http://127.0.0.1:8080/carros'; 

// Função para visualizar carros
function viewCars() {
    const tableBody = document.getElementById("table-body");
    fetch(url)
        .then((resp) => resp.json())
        .then((cars) => {
            tableBody.innerHTML = ""; // Limpa a tabela antes de exibir os dados
            cars.forEach((car) => {
                const trBody = `
                    <tr>
                        <th scope="row">${car.idCarro}</th>
                        <td>${car.marca}</td>
                        <td>${car.modelo}</td>
                        <td>${car.placa}</td>
                        <td>${car.valordiaria}</td>
                    </tr>`;
                tableBody.innerHTML += trBody;
            });
        })
        .catch((error) => console.log(error));
}

// Função para adicionar um novo carro
function addCar() {
    const marca = document.getElementById("carmarca").value;
    const modelo = document.getElementById("carmodelo").value;
    const placa = document.getElementById("carplaca").value;
    const valordiaria = document.getElementById("carvalordiaria").value;

    const car = {
        marca: marca,
        modelo: modelo,
        placa: placa,
        valordiaria: valordiaria,
    };

    fetch(url, {
        method: 'POST',
        body: JSON.stringify(car),
        headers: { 'Content-type': 'application/json' }
    })
    .then((response) => response.json())
    .then((carjson) => {
        console.log('Carro adicionado:', carjson);
        viewCars(); // Após adicionar, atualiza a visualização dos carros
    })
    .catch((error) => console.log(error));
}

// Função para excluir um carro
function deleteCar() {
    const id = document.getElementById("carid").value;

    fetch(`${url}/${id}`, {
        method: 'DELETE',
    })
    .then((response) => response.json())
    .then((carjson) => {
        console.log('Carro excluído:', carjson);
        viewCars(); // Após excluir, atualiza a visualização dos carros
    })
    .catch((error) => console.log(error));
}

// Função para atualizar um carro existente
function updateCar() {
    const id = document.getElementById("carid").value;
    const marca = document.getElementById("carmarca").value;
    const modelo = document.getElementById("carmodelo").value;
    const placa = document.getElementById("carplaca").value;
    const valordiaria = document.getElementById("carvalordiaria").value;

    const car = {
        marca: marca,
        modelo: modelo,
        placa: placa,
        valordiaria: valordiaria,
    };

    fetch(`${url}/${id}`, {
        method: 'PUT',
        body: JSON.stringify(car),
        headers: { 'Content-type': 'application/json' }
    })
    .then((response) => response.json())
    .then((carjson) => {
        console.log('Carro atualizado:', carjson);
        viewCars(); // Após atualizar, atualiza a visualização dos carros
    })
    .catch((error) => console.log(error));
}
