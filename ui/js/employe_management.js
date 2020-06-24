let SERVER_URL = "http://localhost:8080";

function getEmploye() {
    return fetch(SERVER_URL + "/employers", {
        method: 'get'
    }).then(
        function (response) {
            if (response.ok) {
                return response.json();

            }
        }).then(function (employers_list) {

            console.log(employers_list);
        let employersList = document.querySelector("#tab");

        for (let i = 0; i < employers_list.length; i++) {

            let employe = employers_list[i];

            let tbl = document.getElementById("tab");
            let employeRow = tbl.insertRow();
            let cell1 = employeRow.insertCell();
            let cell2 = employeRow.insertCell();
            let cell3 = employeRow.insertCell();
            let cell4 = employeRow.insertCell();


            cell1.innerHTML = employe.name;
            cell2.innerHTML = employe.lastName;
            cell3.innerHTML = employe.department;
            cell4.innerHTML;



            let buttonEmployeDetail = document.createElement("button");
            buttonEmployeDetail.className = "btn btn-primary btn-sm";
            buttonEmployeDetail.setAttribute("id-data", employe.id);
            buttonEmployeDetail.innerHTML = "Detail";
            buttonEmployeDetail.addEventListener('click', function (e) {
                let id = e.target.getAttribute("id-data");
                localStorage.setItem("idLocal", id);
                window.open('detail_employe.html', '_self');
            }, false);

            employersList.appendChild(employeRow);
            cell4.appendChild(buttonEmployeDetail);

        }
    });
}

function createEmploye() {
    let createName = document.querySelector("#createEmployeName").value;
    let createLastName = document.querySelector("#createEmployeLastName").value;
    let createDepartment = document.querySelector("#createEmployeDepartment").value;


    let createEmploye = {
        name: createName,
        lastName: createLastName,
        department: createDepartment
    };

    return fetch(SERVER_URL + "/employers", {
        method: 'post',
        body: JSON.stringify(createEmploye),
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

$(document).ready(function () {
    getEmploye();

    document.querySelector("#employe-create-button").addEventListener('click', function (e) {
        event.preventDefault();
        createEmploye();
    })


});
