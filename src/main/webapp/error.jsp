<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error page</title>
</head>
<body>
    Request that failed: ${pageContext.errorData.requestURI}
<br/>
    Status code: ${pageContext.errorData.statusCode}
<br/>
    Exception: ${pageContext.errorData.throwable}
<br/>
    ${pageContext.errorData.servletName}

    <a href="index.jsp">Home page</a>
</body>
</html>
