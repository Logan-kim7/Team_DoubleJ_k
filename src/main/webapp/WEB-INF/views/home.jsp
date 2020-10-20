<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value='${pageContext.request.contextPath}' />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>DripBag</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://kit.fontawesome.com/cc60939e22.js"
	crossorigin="anonymous"></script>

<style>

html, body {
	width: 100%;
	height: 100%;
	display: flex;
	flex-flow: column;
	margin: 0;
	padding: 0;
}
</style>

</head>
<body>
	<c:if test="${BODY != 'INDEX_HOME'}">
		<%@ include file="/WEB-INF/views/MKW/MKW_nav.jspf"%>
	</c:if>

	<c:choose>
		<c:when test="${BODY == 'INDEX_HOME'}">
			<%@ include file="/WEB-INF/views/LJH/index.jspf"%>
		</c:when>

		<c:when test="${BODY == 'MAIN_HOME'}">
			<%@ include file="/WEB-INF/views/MKW/MKW_main.jspf"%>
		</c:when>

		<c:when test="${BODY == 'HALL_OF_FAME'}">
			<%@ include file="/WEB-INF/views/MKW/halloffame.jspf"%>
		</c:when>

		<c:when test="${BODY == 'INFO_HOME'}">
			<%@ include file="/WEB-INF/views/MKW/MKW_infomain.jspf"%>
		</c:when>

		<c:when test="${BODY == 'NEWS_HOME'}">
			<%@ include file="/WEB-INF/views/KJM/newsmain.jspf"%>
		</c:when>

		<c:when test="${BODY == 'GOOGLE_HOME'}">
			<%@ include file="/WEB-INF/views/MKW/googletrand.jspf"%>
		</c:when>

		<c:when test="${BODY == 'NEWS_DETAIL'}">
			<%@ include file="/WEB-INF/views/KJM/newsmain.jspf"%>
		</c:when>

		<c:otherwise>

		</c:otherwise>
	</c:choose>

	<c:if test="${BODY != 'INDEX_HOME'}">
		<footer>
			<%@ include file="/WEB-INF/views/include/footer.jspf"%>
		</footer>
	</c:if>
</body>


</html>