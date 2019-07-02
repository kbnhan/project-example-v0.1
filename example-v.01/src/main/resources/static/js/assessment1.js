var birthdate = document.getElementById("birthdate");

birthdate.addEventListener("input", function (event) {
    if (birthdate.validity.patternMismatch) {
        birthdate.setCustomValidity("Your answer does not match the required format");
    } else {
        birthdate.setCustomValidity("");
    }
});