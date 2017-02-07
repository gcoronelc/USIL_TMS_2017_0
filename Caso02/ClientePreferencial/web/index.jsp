<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <jsp:include page="util/cabecera.jsp" />
    <h1>INICIO DE SESION</h1>
    <p>Error: ${requestScope.error}</p>
    <form method="post" action="EurekaLogin">
      Usuario: <input type="text" name="usuario"/><br/>
      Clave: <input type="password" name="clave"/><br/>
      <input type="submit" value="Ingresar"/>
    </form>
  </body>
</html>
