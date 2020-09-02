<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value = '${pageContext.request.contextPath}'/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://kit.fontawesome.com/c1d8b25418.js"
	crossorigin="anonymous"></script>
<style>

body, html {
	background: url("${rootPath}/static/imgs/LJH/Background.gif") no-repeat
		center center fixed;
	background-size: contain;
	background-color: black;
	margin: 0;
	padding: 0;
}

#MainLogo {
	width: 70vw;
	height: 50vh;
	position: absolute;
	left: 50%;
	top: -10%;
	transform: translate(-50%);
}

form input, #singin, #singup{
	width: 20vw;
	height: 2.5vh;
	font-size: 2vh;
	border: 0.1vh solid white;
	color: white;
	background-color: rgba(0, 0, 0, 0.5);
	border-radius: 5vh;
	position: absolute;
	left: 51%;
	transform: translate(-50%, -50%);
	padding: 0.5vh 0.5vw;
	text-align: center;
}

#id_input {
	top: 45%;
}

#pwd_input {
	top: 50%;
}

#singin {
	top: 75%;
	padding: 0;
}

#singup {
	top: 79%;
	padding: 0;
}

#singin:hover, #singup:hover, a:visited{
	cursor: pointer;
	color: rgb(247, 174, 39);
	border-color: rgb(247, 174, 39);
	text-decoration: none
}

form input:focus, form button:focus{
	outline: none;
	border-color: rgb(247, 174, 39);
}

</style>
<title>DripBag</title>
<link >
</head>
<body>
        <img src="${rootPath}/static/imgs/LJH/logo.png" alt="MainLogo" id="MainLogo">
        <form>
            <input type="email" id="id_input">
            <input type="password" id="pwd_input">
           <button id = "singin" type="button"><a href="${rootPath}/main/">Sing In</a></button>
           <button id = "singup" type="button">Sing Up</button>
        </form>
</body>
</html>