// Define the server url
let SERVER = "http://localhost:8080";

//This function get the product from the server and show them in UI
function getProduct() {
    console.log("Get product request");

    // Make request to server to server in order to get the products
    return fetch(SERVER + "/products", {
        method: 'get'
    }).then(
        function (response) {

            if (response.ok) { // if everyting is ok
                // Get the response body
                return response.json();

            }
        }).then(function (product_list) {
        console.log(product_list);

        // Select from HTML components the list where products should be placed
        let productList = document.querySelector("#table");

        // Iterate over the server products and add them in the list
        for (let i = 0; i < product_list.length; i++) {

            // Get the product i from product list
            let product = product_list[i];

            console.log(" product " + product);
            // We need to create the html components (table cell) to
            //To add tem to the table
            let tbl = document.getElementById("table");
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

            // Add in table cell product
            cell1.innerHTML = product.name;
            cell2.innerHTML = product.category;
            cell3.innerHTML = product.gender;
            cell4.innerHTML = product.stock;
            cell5.innerHTML = product.price;
            cell6.innerHTML = product.codeScan;
            cell7.innerHTML = product.image;
            cell8.innerHTML;
            cell9.innerHTML;


            let buttonProductDetail = document.createElement("button");
            buttonProductDetail.className = "btn btn-primary btn-sm";
            buttonProductDetail.setAttribute("data_id", product.id);
            buttonProductDetail.innerHTML = "Detail";

            buttonProductDetail.addEventListener('click', function (e) {
                let idProduct = e.target.getAttribute("data_id");
                localStorage.setItem("prodId", idProduct);
                window.open('detail_product.html', '_self');
            }, false);

            cell9.appendChild(buttonProductDetail);
            productList.appendChild(productRow);

        }
    });
}

function createProduct() {
    let createName = document.querySelector("#createProductName").value;
    let createCategory = document.querySelector("#createProductCategory").value;
    let createGender = document.querySelector("#createProductGender").value;
    let createStock = document.querySelector("#createProductStock").value;
    let createPrice = document.querySelector("#createProductPrice").value;
    let createCodeScan = document.querySelector("#createProductCodeScan").value;
    let createImage = document.querySelector("#createProductImage").value;

    let createProduct = {
        name: createName,
        category: createCategory,
        gender: createGender,
        stock: Number(createStock),
        price: Number(createPrice),
        codeScan: createCodeScan,
        image: createImage,
    };

    return fetch(SERVER + "/products", {
        method: 'post',
        body: JSON.stringify(createProduct),
        headers: new Headers({
            'content-type': 'application/json'
        })
    }).then(
        function (response) {
            if (response.ok) {
                console.log("ok");
                location.reload();
            } else {
                console.log("Network request for product.json failed");
            }
        });

}


// this function is called when page is loading
$(document).ready(function () {

    // initialize the product list
    getProduct();

    document.querySelector("#product-create-button").addEventListener("click", function (e) {
        event.preventDefault();
        createProduct();
    });

});
