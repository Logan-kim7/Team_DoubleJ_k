<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value = '${pageContext.request.contextPath}'/>

	<c:forEach items="${LIST}" var="i">
			<p>${i.title}</p>
	</c:forEach>
