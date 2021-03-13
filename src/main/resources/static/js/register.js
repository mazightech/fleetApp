$(document).ready(function (){
    var firstname = $("#firstname");
    var lastname = $("#lastname");
    var username = $("#username");
    var password = $("#password");
    var confirmPassword = document.getElementById("confirmPassword");
    $("#registerSubmit").on('click', function () {
        if (password.val() != confirmPassword.value)
            confirmPassword.setCustomValidity("Password don't Match");
        else
            confirmPassword.setCustomValidity('');
        firstname.prop("required", true);
        lastname.prop("required", true);
        username.prop("required", true);
        password.prop("required", true);
    });


});