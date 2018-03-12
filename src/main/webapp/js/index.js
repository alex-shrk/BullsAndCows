function vefiryAndLogin() {

    if (document.getElementById("userLogin").value.length === 0 ) {
        alert("Некорректный логин или пароль");
    }
    else
        document.getElementById("loginForm").submit();

}

