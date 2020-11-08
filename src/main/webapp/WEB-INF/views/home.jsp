<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<script src="${rootPath}/static/js/search.js?ver=9"></script>
<link
	href="https://fonts.googleapis.com/css2?family=East+Sea+Dokdo&display=swap"
	rel="stylesheet">
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
	font-family: 'East Sea Dokdo', cursive;
}

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
		<%@ include file="/WEB-INF/views/include/header.jspf"%>
		<%@ include file="/WEB-INF/views/include/nav.jspf"%>
	</c:if>

	<c:choose>
		<c:when test="${BODY == 'INDEX_HOME'}">
			<%@ include file="/WEB-INF/views/index.jspf"%>
		</c:when>

		<c:when test="${BODY == 'MAIN_HOME'}">
			<%@ include file="/WEB-INF/views/main.jspf"%>
		</c:when>

		<c:when test="${BODY == 'HALL_OF_FAME'}">
			<%@ include file="/WEB-INF/views/Ranking/halloffame.jspf"%>
		</c:when>

		<c:when test="${BODY == 'INFO_HOME'}">
			<%@ include file="/WEB-INF/views/infomation/infomain.jspf"%>
		</c:when>

		<c:when test="${BODY == 'GOOGLE_HOME'}">
			<%@ include file="/WEB-INF/views/google/googletrand.jspf"%>
		</c:when>

		<c:when test="${BODY == 'NEWS_HOME'}">
			<%@ include file="/WEB-INF/views/news/newsmain.jspf"%>
		</c:when>
		
		<c:when test="${BODY == 'NOTICE_HOME'}">
			<%@ include file="/WEB-INF/views/Notice/main.jspf"%>
		</c:when>

	</c:choose>

	<c:if test="${BODY != 'INDEX_HOME'}">
		<%@ include file="/WEB-INF/views/include/footer.jspf"%>
	</c:if>
</body>


</html>