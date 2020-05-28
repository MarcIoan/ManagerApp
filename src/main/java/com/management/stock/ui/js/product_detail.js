let SERVER = "http://localhost:8080";

function getProduct() {
    let i = localStorage.getItem("prodId");
    console.log("i" + i);
    return fetch(SERVER + "/products/" + i, {
        method: 'get'
    }).then(
        function (response) {
            if (response.ok) {
                return response.json();

            }
        }).then(function (product) {

        let productList = document.querySelector("#table-detail");


        let tbl = document.getElementById("table-detail");
        document.getElementById("table-detail").contentEditable = "true";
        let productRow = tbl.insertRow();
        let cell1 = productRow.insertCell();
        let cell2 = productRow.insertCell();
        let cell3 = productRow.insertCell();
        let cell4 = productRow.insertCell();
        let cell5 = productRow.insertCell();
        let cell6 = productRow.insertCell();
        let cell7 = productRow.insertCell();
        let cell8 = productRow.insertCell();
        let cell9 = productRow.insertCell();


        cell1.innerHTML = product.name;
        cell2.innerHTML = product.category;
        cell3.innerHTML = product.gender;
        cell4.innerHTML = product.stock;
        console.log("cell4"+ cell4.innerHTML);
        cell5.innerHTML = product.price;
        cell6.innerHTML = product.codeScan;
        cell7.innerHTML = product.image;
        cell8.innerHTML;
        cell9.innerHTML;


        cell1.setAttribute("id", "name");
        cell2.setAttribute("id", "category");
        cell3.setAttribute("id", "gender");
        cell4.setAttribute("id", "stock");
        cell5.setAttribute("id", "price");
        cell6.setAttribute("id", "codeScan");
        cell7.setAttribute("id", "image");

        let buttonProductUpdate = document.createElement("button");
        buttonProductUpdate.className = "btn btn-primary btn-sm";
        buttonProductUpdate.setAttribute("data-id", product.id);
        buttonProductUpdate.innerHTML = "Update";
        buttonProductUpdate.addEventListener('click', function (f) {
            updateProduct();
        }, false);


        let buttonProductDelete = document.createElement("button");
        buttonProductDelete.className = "btn btn-danger btn-sm";
        buttonProductDelete.setAttribute("data-id", product.id);
        buttonProductDelete.innerHTML = "Delete";
        buttonProductDelete.addEventListener('click', function (e) {
            deleteProduct();
        });


        cell8.appendChild(buttonProductUpdate);
        cell9.appendChild(buttonProductDelete);
        productList.appendChild(productRow);

    });
}

function updateProduct() {
    let i = localStorage.getItem("prodId");

    let updateName = document.querySelector("#name").innerHTML;
    let updateCategory = document.querySelector("#category").innerHTML;
    let updateGender = document.querySelector("#gender").innerHTML;
    let updateStock = document.querySelector("#stock").innerHTML;
    let updatePrice = document.querySelector("#price").innerHTML;
    let updateCodeScan = document.querySelector("#codeScan").innerHTML;
    let  updateImage = document.querySelector("#image").innerHTML;


    let updateProduct = {
        name: updateName,
        category: updateCategory,
        gender: updateGender,
        stock: Number(updateStock),
        price: Number(updatePrice),
        codeScan: updateCodeScan,
        image: updateImage,
    };

    return fetch(SERVER + "/products/" + i, {
        method: 'put',
        body: JSON.stringify(updateProduct),
        headers: new Headers({
            'content-type': 'application/json'
        })
    }).then(
        function (response) {
            if (response.ok) {
                console.log("ok");
                location.reload();
            } else {
                console.log("Nu e ok");
            }
        })
}


function deleteProduct() {
    let i = localStorage.getItem("prodId");

    return fetch(SERVER + "/products/" + i, {
        method: 'delete'
    }).then(
        function (response) {
            if (response.ok) {
                console.log("ok");

            } else {
                console.log("Network request for products.json failed")
            }
        });
}


$(document).ready(function () {
    getProduct();

});


