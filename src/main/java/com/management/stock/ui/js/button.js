function button() {
// Get the modal
    var modal = document.getElementById("myModalProduct");
    var modalEmployer = document.getElementById("myModalEmploye");
// Get the button that opens the modal
    var btn = document.getElementById("btn");
    var btnEmp = document.getElementById("myBtn");

// When the user clicks the button, open the modal
    btn.onclick = function () {
        modal.style.display = "block";
    };

    btnEmp.onclick = function () {
        modalEmployer.style.display = "block";
    };

// When the user clicks anywhere outside of the modal, close it
    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    };
    window.onclick = function (event) {
        if (event.target == modalEmployer) {
            modalEmployer.style.display = "none";
        }
    };

}

$(document).ready(function () {
    button();
});