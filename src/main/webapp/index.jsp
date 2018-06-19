<%@ page import="Helpers.Vars" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <title>Быки и коровы</title>
</head>
<body>

<header>
    <h2> Добро пожаловать в игру "Быки и коровы"</h2>
</header>

<main>
    <div class="loginAndRegister">
        <form id=loginForm action="login" method="post">
            <div>
                <input required class="userForm" id=user_login name=user_login type="text" placeholder="Логин">
            </div>
            <div>
                <input class="userForm" id="user_psw" name="user_psw" type="password" placeholder="Пароль">
            </div>
            <input type="submit" class="button loginBtn" name="loginBtn" value="Войти"/>
            <a class="button registerBtn" href="registration.jsp">Регистрация</a>
        </form>

    </div>
</main>

</body>
</html>
