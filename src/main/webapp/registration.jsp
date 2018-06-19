<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <title>Регистрация игрока</title>
</head>
<body>
<header>
    <h2> Форма регистрации нового игрока</h2>
</header>

<main>
    <form action="registration" method="post">
        <div>
            <input required type="text" name=user_login placeholder="Логин">
        </div>

        <div>
            <input type="password" name=user_psw placeholder="Пароль">
        </div>

        <div>
            <input required type="text" name="user_name" placeholder="Имя игрока">
        </div>
        <div>
            <input class="button registerBtn" type="submit" value="Зарегистрироваться">
            <input class="button" type="reset" value="Сброс">
        </div>
    </form>
</main>


</body>
</html>
