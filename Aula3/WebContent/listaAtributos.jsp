<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cliente</title>
</head>
<body>

<h3>Lista atributos cadastrados</h3>


<%String req = (String)request.getAttribute("sReq"); %>
Request: <%=req %><br>

<%String ses = (String)session.getAttribute("sSes"); %>
Session: <%=ses %><br>

<%String app = (String)application.getAttribute("sApp"); %>
Application: <%=app %><br>

<br>
<a href="principal.html">Voltar para a página Principal</a>


</body>
</html>
