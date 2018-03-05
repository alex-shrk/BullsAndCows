<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="scripts/Verifier.js"></script>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <title>Быки и коровы</title>
</head>
<body class="center">

<H3> Добро пожаловать в игру "Быки и коровы"</H3>
<div>
    <form id=loginForm action="login" method="post" class="center">
        <input class="userForm" id="userLogin" name="userLogin"  type="text" placeholder="Логин">
        <input class="userForm" id="userPsw" name="userPsw"  type="password"  placeholder="Пароль">
        <input class="userForm" id="loginBtn" name="loginBtn" type="button" value="Войти" onclick="vefiryAndLogin()"/>
    </form>
    <form action="registration.jsp" method="post" class="center">
        <input type="submit" value="Register">
    </form>
</div>
</body>
</html>
