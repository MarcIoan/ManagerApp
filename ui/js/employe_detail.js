let SERVERURl = "http://localhost:8080";


function getEmploye() {
    let i = localStorage.getItem("idLocal");
    return fetch(SERVERURl + "/employers/" + i, {
        method: 'get'
    }).then(
        function (response) {
            if (response.ok) {
                return response.json();

            }
        }).then(function (employe) {

        let employeList = document.querySelector("#tab");


        let tbl = document.getElementById("tab");
        document.getElementById("tab").contentEditable = "true";

        let employeRow = tbl.insertRow();
        let cell1 = employeRow.insertCell();
        let cell2 = employeRow.insertCell();
        let cell3 = employeRow.insertCell();
        let cell4 = employeRow.insertCell();
        let cell5 = employeRow.insertCell();

        cell1.innerHTML = employe.name;
        cell2.innerHTML = employe.lastName;
        cell3.innerHTML = employe.department;
        cell4.innerHTML;
        cell5.innerHTML;


        cell1.setAttribute("id", "name");
        cell2.setAttribute("id", "lastName");
        cell3.setAttribute("id", "department");


        let button_ = document.createElement("button");
        button_.className = "btn btn-primary btn-sm";
        button_.setAttribute("data-id", employe.id);
        button_.innerHTML = "Update";
        button_.addEventListener('click', function (e) {
            updateEmploye();
        }, false);

        let buttonEmployeDelete = document.createElement("button");
        buttonEmployeDelete.className = "btn btn-danger btn-sm";
        buttonEmployeDelete.setAttribute("data-id", employe.id);
        buttonEmployeDelete.innerHTML = "Delete";
        buttonEmployeDelete.addEventListener('click', function (e) {
            deleteEmploye();
        });

        cell4.appendChild(button_);
        cell5.appendChild(buttonEmployeDelete);
        employeList.appendChild(employeRow);

    });
}

function updateEmploye() {
    let i = localStorage.getItem("idLocal");
    let updateName = document.querySelector("#name").innerHTML;
    let updatelastName = document.querySelector("#lastName").innerHTML;
    let updateDepartment = document.querySelector("#department").innerHTML;

    let updateEmploye = {
        name: updateName,
        lastName: updatelastName,
        department: updateDepartment,
    };

    return fetch(SERVERURl + "/employers/" + i, {
        method: 'put',
        body: JSON.stringify(updateEmploye),
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

function deleteEmploye() {
    let i = localStorage.getItem("idLocal");
    return fetch(SERVERURl + "/employers/" + i, {
        method: 'delete'
    }).then(
        function (response) {
            if (response.ok) {
                console.log("ok");
                location.reload();
            } else {
                console.log("Network request for products.json failed")
            }
        });
}


$(document).ready(function () {
    getEmploye();

});


