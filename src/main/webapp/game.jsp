<%@ page import="java.util.List" %>
<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Collections" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<script src="js/game.js"></script>
<html>
<head>
    <title>Быки и коровы</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>

<div class="header">
    <h2>Пользователь:
        <%=(String) session.getAttribute("userName")%>
    </h2>

    <h2>Comp combination:
        <%=(String) session.getAttribute("compCombString")%>
    </h2>
    <%
        if (session.getAttribute("counterTryes") != null && !session.getAttribute("counterTryes").equals(0))
    %>
    <h3>Число попыток:<%=(int) session.getAttribute("counterTryes")%>
    </h3>
</div>


<div class="leftPanel" align="center">
    <form id="inputCombo" name="inputCombo" method="post" action="verifyGame">


        <input id="userCombo" type="text" name="userCombo" readonly="readonly">

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

<div class="rightPanel" >




    <% List<String[]> userHistory;
        if (session.getAttribute("userComboHistory") != null) {
    %>
    <h3>История ходов</h3>
    <table>
        <tr>
            <th>Комбинация</th>
            <th>Результат</th>
        </tr>
        <%


            userHistory = (List<String[]>) session.getAttribute("userComboHistory");
            Collections.reverse(userHistory);//for view history new-old
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


</body>
</html>
