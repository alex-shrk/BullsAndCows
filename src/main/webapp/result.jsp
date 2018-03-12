<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.Collections" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <title>Результат игры</title>
</head>
<body>



<%
    if (session.getAttribute("counterTryes") != null)
%>
<div class="header">
    <h3>Игра окончена</h3>
    <h3>Вы угадали комбинацию компьютера за число попыток:<%=(int) session.getAttribute("counterTryes")%></h3>
</div>

<div align="center">
    <form action="finishGame" method="post">
        <input id = finishGameBtn type="submit" value="Начать заново">

    </form>
</div>



<% List<String[]> userHistory;
    if (session.getAttribute("userComboHistory") != null) {
%>
<div class="leftPanel" >



<h3>История ходов</h3>
<table>
    <tr>
        <th>Комбинация</th>
        <th>Результат</th>
    </tr>
    <%


        userHistory = (List<String[]>) session.getAttribute("userComboHistory");
        Collections.reverse(userHistory);
        for (String[] history : userHistory) {

    %>

    <tr>
        <td><%=history[0]%>
        </td>
        <td><%=history[1]%>
        </td>
    </tr>

    <%
            }
        }
    %>
</table>
</div>

<% ResultSet ratingSet;
    try {
        if (session.getAttribute("ratingSet") != null) {
%>
<div class="rightPanel">
<h3>Таблица результатов</h3>
<table>
    <tr>
        <th>Игрок</th>
        <th>Среднее число попыток</th>
    </tr>
    <%
        ratingSet = (ResultSet) session.getAttribute("ratingSet");
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
