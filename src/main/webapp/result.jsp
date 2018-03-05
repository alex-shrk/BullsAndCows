<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <title>Результат игры</title>
</head>
<body>
<h2>Comp combination:
    <%=(String) session.getAttribute("compCombString")%>
</h2>


<%
    if (session.getAttribute("counterTryes") != null)
%>
<h3>Игра окончена</h3>
<h3>Вы угадали комбинацию компьютера за <%=(int) session.getAttribute("counterTryes")%></h3>


<% List<String[]> userHistory;
    if (session.getAttribute("userComboHistory") != null) {
%>
<table>
    <tr>
        <th>Номер попытки</th>
        <th>Комбинация</th>
    </tr>
    <%


        userHistory = (List<String[]>) session.getAttribute("userComboHistory");
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


<% ResultSet ratingSet;
    try {
        if (session.getAttribute("ratingSet") != null) {
%>

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
<form action="finishGame" method="post">
    <input type="submit" value="Начать заново">

</form>

</body>
</html>
