function vefiryAndLogin() {
    if (document.getElementById("user_login").value.length === 0 ) {
        alert("Некорректный логин или пароль");
    }
    else
        document.getElementById("loginForm").submit();

}

