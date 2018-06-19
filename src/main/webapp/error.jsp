<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Ошибка</title>
</head>
<body>
<h2>
    Возникла ошибка в работе
</h2>
<details>
    <summary>Информация об ошибке</summary>
    Запрос: ${pageContext.errorData.requestURI}
    <br/>
    Статус: ${pageContext.errorData.statusCode}
    <br/>
    Исключение: ${pageContext.errorData.throwable}
    <br/>
    Источник: ${pageContext.errorData.servletName}
</details>
<a href="index.jsp">Вернуться на главную страницу</a>
</body>
</html>
