<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value = '${pageContext.request.contextPath}'/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>Drip Bag Main page</title>

<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://kit.fontawesome.com/cc60939e22.js" crossorigin="anonymous"></script>    
<style>






</style>

</head>
<body>
 <%@ include file="/WEB-INF/views/include/nav.jspf"%> 


<c:choose>
   <c:when test="${BODY == 'MAIN_HOME'}">
    <%@ include file="/WEB-INF/views/KJM/main.jspf"%>
    </c:when>
    
    <c:when test="${BODY == 'INFO_HOME'}">
    <%@ include file="/WEB-INF/views/KJM/infomain.jspf"%>
    </c:when>
<c:otherwise>

</c:otherwise>
</c:choose>


<footer>
 <%@ include file="/WEB-INF/views/include/footer.jspf"%> 
</footer>
</body>


</html>