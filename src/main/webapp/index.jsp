<%@ page contentType="text/html;charset=UTF-8" %>
<script src="js/index.js"></script>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <title>Быки и коровы</title>
</head>
<body>

<div align="center">
    <H2> Добро пожаловать в игру "Быки и коровы"</H2>
</div>

<div class="loginAndRegister">
    <form id=loginForm action="login" method="post">
        <div>
            <input class="userForm" id="userLogin" name="userLogin" type="text" placeholder="Логин">

        </div>
        <div>
            <input class="userForm" id="userPsw" name="userPsw" type="password" placeholder="Пароль">
        </div>

    </form>
    <div>
        <form action="registration.jsp" method="post">
        <input class="userForm" id="loginBtn" name="loginBtn" type="button" value="Войти"
               onclick="vefiryAndLogin()"/>

            <input id="registerBtn" type="submit" value="Регистрация">
        </form>
    </div>


</div>
</body>
</html>
