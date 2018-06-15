<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <title>Регистрация игрока</title>
</head>
<body>
<div class="header">
    <H2> Форма регистрации нового игрока</H2>
</div>
<div class="loginAndRegister">
    <form action="registration" method="post">
        <div>
            <input type="text" name=user_login placeholder="Логин">
        </div>

        <div>
            <input type="password" name=user_psw placeholder="Пароль">
        </div>

        <div>
            <input type="text" name="user_name" placeholder="Имя игрока">
        </div>

        <div>
            <input id="registerBtn" type="submit" value="Зарегистрироваться">
        </div>
    </form>

</div>


</body>
</html>
