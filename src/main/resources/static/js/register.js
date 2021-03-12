$(document).ready(function (){
    $("#registerSubmit").on('click', function () {
        var password = $("#password").val();
        var confirmPassword = document.getElementById("confirmPassword");
        if (password != confirmPassword.value)
            confirmPassword.setCustomValidity("Password don't Match");
        else
            confirmPassword.setCustomValidity('');
    });
});