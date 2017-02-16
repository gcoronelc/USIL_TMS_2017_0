<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${sessionScope.usuario ==  null}">
  <jsp:forward page="../index.jsp" />
</c:if>