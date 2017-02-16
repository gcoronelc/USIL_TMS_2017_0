<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="util/seguro.jsp" />
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <jsp:include page="util/cabecera.jsp" />
    <jsp:include page="util/menu.jsp" />
    <form method="post" action="EurekaConsulta">
      <div>
        Cuenta: <input type="text" name="cuenta"/>
        <input type="submit" value="Procesar" />
      </div>
    </form>
    <c:if test="${error != null}">
      <p style="color:red;">${error}</p>
    </c:if>
    <c:if test="${recCuenta != null}">
      <h2>DATOS DE LA CUENTA</h2>
      <table>
        <tr>
          <td>CUENTA:</td>
          <td>${recCuenta.CUENCODIGO}</td>
          <td>MONEDA:</td>
          <td>${recCuenta.MONENOMBRE}</td>
        </tr>
        <tr>
          <td>ESTADO:</td>
          <td>${recCuenta.CUENESTADO}</td>
          <td>SALDO:</td>
          <td>${recCuenta.CUENSALDO}</td>
        </tr>
        <tr>
          <td>CLIENTE:</td>
          <td colspan="3">
            ${recCuenta.CLIEPATERNO} ${recCuenta.CLIEMATERNO}, ${recCuenta.CLIENOMBRE}
          </td>
        </tr>
        <tr>
          <td>SUCURSAL:</td>
          <td colspan="3">
            ${recCuenta.SUCUNOMBRE}
          </td>
        </tr>
      </table>
    </c:if>
    <c:if test="${lista != null}">
      <h2>MOVIMIENTOS</h2>
      <table border="1">
        <!-- CABECERA -->
        <tr>
          <th>NRO.MOV.</th>
          <th>FECHA</th>
          <th>DESCRIPCION</th>
          <th>ACCION</th>
          <th>IMPORTE</th>
        </tr>
        
        <c:forEach items="${lista}" var="r">
          <tr>
            <td>${r.MOVINUMERO}</td>
            <td>${r.MOVIFECHA}</td>
            <td>${r.TIPONOMBRE}</td>
            <td>${r.TIPOACCION}</td>
            <td>${r.MOVIIMPORTE}</td>
          </tr>
        </c:forEach>
        
        
      </table>
    </c:if>
  </body>
</html>
