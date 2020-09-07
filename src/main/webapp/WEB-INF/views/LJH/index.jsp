<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value = '${pageContext.request.contextPath}'/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://kit.fontawesome.com/c1d8b25418.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="${rootPath}/static/css/LJH/index.css?ver=002"/>
<script>
	function move()  { document.location.href="${rootPath}/main/" }
	function join()  { document.getElementById("join_body").style.display="block"; }
	function none() { document.getElementById("join_body").style.display="none"; }
</script>


<title>DripBag</title>
</head>
<body>
        <img src="${rootPath}/static/imgs/LJH/logo.png" alt="MainLogo" id="MainLogo">
        <form id="login_form" autocomplete="off">
           <input type="email" id="id_input">
           <input type="password" id="pwd_input">
           <button id = "singin" type="button" onclick="move()">Sing In</button>
        </form>
        <button id = "singup" type="button" onclick="join()">Sing Up</button>

       <%@ include file="/WEB-INF/views/LJH/join.jspf" %>
</body>
</html>