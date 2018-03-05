function vefiryAndSendCombo() {

    if (document.getElementById("userCombo").value.length !== 4) {
        alert("incorrect combo");
    }
    else
        document.getElementById("inputCombo").submit();

}
function vefiryAndLogin() {

    if (document.getElementById("userLogin").value.length === 0 ) {
        alert("Некорректный логин или пароль");
    }
    else
        document.getElementById("loginForm").submit();

}