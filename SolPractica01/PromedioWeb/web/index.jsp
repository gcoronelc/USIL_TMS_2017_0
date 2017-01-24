<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>PROMEDIO</title>
  </head>
  <body>
    <h1>CALCULAR PROMEDIO</h1>
    <form method="post" action="PromedioController">
      <fieldset>
        <legend>Pácticas</legend>
        <table>
          <tr>
            <td>Práctica 1:</td>
            <td><input type="text" name="p1" value="${requestScope.p1}"/></td>
            <td>Práctica 2:</td>
            <td><input type="text" name="p2" value="${requestScope.p2}"/></td>
          </tr>
          <tr>
            <td>Práctica 3:</td>
            <td><input type="text" name="p3" value="${requestScope.p3}"/></td>
            <td>Práctica 4:</td>
            <td><input type="text" name="p4" value="${requestScope.p4}"/></td>
          </tr>
        </table>
      </fieldset>
      <fieldset>
        <legend>Examenes</legend>
        <table>
          <tr>
            <td>Parcial:</td>
            <td><input type="text" name="ep" value="${requestScope.ep}"/></td>
            <td>Final:</td>
            <td><input type="text" name="ef" value="${requestScope.ef}"/></td>
          </tr>
        </table>
      </fieldset>
      <c:if test="${requestScope.pf != null}">
        <fieldset>
          <legend>Resultado</legend>
          <table>
            <tr>
              <td>P. Practicas:</td>
              <td>${requestScope.pp}</td>
              <td>P. Final:</td>
              <td>${requestScope.pf}</td>
            </tr>
          </table>
        </fieldset>
      </c:if>
      <fieldset>
        <legend>Acciones</legend>
        <input type="submit" value="Procesar" />
      </fieldset>
    </form>
  </body>
</html>
