<%@ page import="Entities.History" %>
<%@ page import="Entities.User" %>
<%@ page import="Helpers.Vars" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="static Helpers.Reversed.reversed" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <title>Результат игры</title>
</head>
<body>



<% User user = (User)session.getAttribute(Vars.USER);
    History history = (History)session.getAttribute(Vars.HISTORY);
    if (history != null)
%>
<div >
    <h3>Игра окончена</h3>
    <h3>Вы угадали комбинацию компьютера за число попыток:<%=history.getCounter()%></h3>
</div>

<div align="center">
    <form action="finishGame" method="post">
        <input id = finishGameBtn type="submit" value="Начать заново">

    </form>
</div>



<%
    if (history.getUserCombos() != null) {
%>
<div class="leftPanel" >



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

<% ResultSet ratingSet = (ResultSet) session.getAttribute(Vars.RATING_SET);
    try {
        if (ratingSet != null) {
%>
<div class="rightPanel">
<h3>Таблица результатов</h3>
<table>
    <tr>
        <th>Игрок</th>
        <th>Среднее число попыток</th>
    </tr>
    <%

        while (ratingSet.next()) {

    %>


    <tr>
        <td><%=ratingSet.getString("User")%>
        </td>
        <td><%=ratingSet.getString("Result")%>
        </td>
    </tr>

    <%

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    %>
</table>
</div>



</body>
</html>
