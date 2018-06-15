<%@ page import="Entities.History" %>
<%@ page import="static Helpers.Reversed.*" %>
<%@ page import="Entities.User" %>
<%@ page import="Helpers.Vars" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<script src="js/game.js"></script>
<html>
<head>
    <title>Быки и коровы</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
<% User user = (User)session.getAttribute(Vars.USER);
    History history = (History)session.getAttribute(Vars.HISTORY);
%>
<div class="navBar">
    <form action="logout" method="post">
<h2> Игрок: <%=user.getName()%> <input id=logoutBtn type="submit" value="Выйти"></h2>



    </form>
</div>
<div class="header">


    <%--<h2>Comp combination:
        <%=(String) session.getAttribute("compCombString")%>
    </h2>--%>
    <%
        if (history != null && !history.getCounter().equals(0))
    %>
    <h3>Число попыток:<%=history.getCounter()%>
    </h3>


</div>


<div class="leftPanel" align="center">
    <h3>Ввод комбинации</h3>
    <form id="inputCombo" name="inputCombo" method="post" action="verifyGame">


        <input id="userCombo" type="number" name="userCombo" readonly="readonly">

        <div>
            <input class="inputBtn" id="button1" type="button" value="1"
                   onclick="buttonHandler(this.id,this.value)">
            <input class="inputBtn" id="button2" type="button" value="2"
                   onclick="buttonHandler(this.id,this.value)">
            <input class="inputBtn" id="button3" type="button" value="3"
                   onclick="buttonHandler(this.id,this.value)">
        </div>
        <div>
            <input class="inputBtn" id="button4" type="button" value="4"
                   onclick="buttonHandler(this.id,this.value)">
            <input class="inputBtn" id="button5" type="button" value="5"
                   onclick="buttonHandler(this.id,this.value)">
            <input class="inputBtn" id="button6" type="button" value="6"
                   onclick="buttonHandler(this.id,this.value)">
        </div>
        <div>
            <input class="inputBtn" id="button7" type="button" value="7"
                   onclick="buttonHandler(this.id,this.value)">
            <input class="inputBtn" id="button8" type="button" value="8"
                   onclick="buttonHandler(this.id,this.value)">
            <input class="inputBtn" id="button9" type="button" value="9"
                   onclick="buttonHandler(this.id,this.value)">
        </div>

        <div>
            <input class="inputBtn" id="button0" type="button" value="0"
                   onclick="buttonHandler(this.id,this.value)">
        </div>
        <div>
            <input class="inputBtn" id="resetBtn" type="button" value="Сброс" onclick="resetCombo()"/>

            <input class="inputBtn" id="sendBtn" type="button" value="ОК" onclick="vefiryAndSendCombo()"/>
        </div>


    </form>
</div>

<div class="rightPanel">


    <%
        if (history.getUserCombos() != null) {
    %>
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


</body>
</html>
