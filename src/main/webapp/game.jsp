<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Быки и коровы</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>

<h2>User name:
    <%=(String) session.getAttribute("userName")%>
</h2>

<h2>Comp combination:
    <%=(String) session.getAttribute("compCombString")%>
</h2>


<h1>Input your combination</h1>

<form id="inputCombo" name="inputCombo" method="post" action="verifyGame">
    <input id="userCombo" type="text" name="userCombo" maxlength="4" readonly="readonly">
    <input id="button0" type="button" value="0" onclick="buttonHandler(this.id,this.value)">
    <input id="button1" type="button" value="1" onclick="buttonHandler(this.id,this.value)">
    <input id="button2" type="button" value="2" onclick="buttonHandler(this.id,this.value)">
    <input id="button3" type="button" value="3" onclick="buttonHandler(this.id,this.value)">
    <input id="button4" type="button" value="4" onclick="buttonHandler(this.id,this.value)">
    <input id="button5" type="button" value="5" onclick="buttonHandler(this.id,this.value)">
    <input id="button6" type="button" value="6" onclick="buttonHandler(this.id,this.value)">
    <input id="button7" type="button" value="7" onclick="buttonHandler(this.id,this.value)">
    <input id="button8" type="button" value="8" onclick="buttonHandler(this.id,this.value)">
    <input id="button9" type="button" value="9" onclick="buttonHandler(this.id,this.value)">
    <input type="button" value="Send combo" onclick="sendCombo()"/>
    <input type="button" value="Сброс" onclick="reset()"/>

</form>
<script language="JavaScript">
    function buttonHandler(id, value) {
        if (document.inputCombo.userCombo.value.length < 4) {
            document.inputCombo.userCombo.value += value;
            document.getElementById(id).disabled = true;//disable btn for unique comb
        }
    }


    function reset() {
        document.inputCombo.reset();
        //todo not working
        document.getElementById("button0").prop("disabled",null);


    }

    function sendCombo() {

        if (document.getElementById("userCombo").value.length !== 4) {
            alert("incorrect combo");
        }
        else
            document.getElementById("inputCombo").submit();

    }
</script>


<%
    if (session.getAttribute("counterTryes") != null)
%>
<h3>Count of tryes:<%=(int) session.getAttribute("counterTryes")%>
</h3>


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

</body>
</html>
