<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <title>Быки и коровы</title>
</head>
<body>

<H3> Добро пожаловать в игру "Быки и коровы"</H3>
<div>
    <form action="login" method="post" class="center">
        <input type="text" name="userLogin" placeholder="Логин">
        <input type="password" name="userPsw" placeholder="Пароль">
        <input type="submit" value="Login">
    </form>
    <form action="registration.jsp" method="post" class="center">
        <input type="submit" value="Register">
    </form>
</div>
</body>
</html>
