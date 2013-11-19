<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:set var="title" value="CXF-Rest Project"/>
<html>
<head>
    <title>${title}</title>
</head>
<body>

<h1>${title}</h1>

<b>API Context:</b> /api/cxf-rest/
<ul>
    <li>POST /accounts</li>
    <li>GET /account/{id}</li>
    <li>GET /web-logon/{id}</li>
</ul>

</body>
</html>
