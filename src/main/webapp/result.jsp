<%@ page import="Entities.History" %>
<%@ page import="Entities.Rating" %>
<%@ page import="Helpers.Vars" %>
<%@ page import="static Helpers.Reversed.reversed" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <title>Результат игры</title>
</head>
<body>


<%
    History history = (History) session.getAttribute(Vars.HISTORY);
    if (history != null)
%>
<div>
    <h3>Игра окончена</h3>
    <h3>Вы угадали комбинацию компьютера за число попыток:<%=history.getCounter()%>
    </h3>
</div>

<div align="center">
    <form action="startGame" method="post">
        <input class="button loginBtn" type="submit" value="Начать заново">
    </form>
</div>

<%
    if (history.getUserCombos() != null) {
%>
<div class="inputPanel">


    <h3>История ходов</h3>
    <table>
        <tr>
            <th>Комбинация</th>
            <th>Результат</th>
        </tr>
        <%
            for (History.Storage el : reversed(history.getUserCombos())) {//reversed - for sort history new-old
        %>

        <tr>
            <td><%=el.getComb().getCombinationString()%>
            </td>
            <td><%=el.getAnswer()%>
            </td>
        </tr>

        <%
                }
            }
        %>
    </table>
</div>

<% List<Rating> ratingList = (List<Rating>) session.getAttribute(Vars.RATING_LIST);

    if (ratingList != null) {
%>
<div class="resultPanel">
    <h3>Таблица результатов</h3>
    <table>
        <tr>
            <th>Игрок</th>
            <th>Среднее число попыток</th>
        </tr>
        <%
            for (Rating rating : ratingList) {
        %>

        <tr>
            <td><%=rating.getUser()%>
            </td>
            <td><%=rating.getResult()%>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
</div>


</body>
</html>
