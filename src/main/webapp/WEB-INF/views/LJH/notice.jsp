<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value = '${pageContext.request.contextPath}'/>
<!DOCTYPE html>
<html>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://kit.fontawesome.com/cc60939e22.js"
	crossorigin="anonymous"></script>
<script>
$(function() 
{
/* 	$("footer").css("position", "static"); */
	//=====================================================
	$("#headh1").html("공지사항");
	$("#headp").html("공지사항 관련 페이지");
	$("#btn-notice").css("background-color", "cornflowerblue");
	$("#btn-notice").css("border-bottom-left-radius", "10px");
	$("#btn-notice").css("border-bottom-right-radius", "10px");
	$("#btn-info").css("border-bottom-right-radius", "10px");
	$("nav button:last-child").css("border-bottom-left-radius", "10px");
	$("#navinfo").css("background-color", "black");
	
	//=====================================================
	$(".notice_title").click(function() {
		let seq = $(this).data("seq");
		document.location.href = "${rootPath}/notice/detail/" + seq;
	})
	
	//=====================================================
		$("#notice_button_div button").click(function()
		{
			document.location.href = "${rootPath}/notice/write"
		})

	//=====================================================
	$("#notice_search").click(function() {
		if ($("#notice_search ul").css("display") == "none")
			$("#notice_search ul").show();
		else
			$("#notice_search ul").hide();
	})

	$("#notice_search ul li").click(function() {
		let temp = $("#notice_search em").text();
		$("#notice_search em").html($(this).text());
		$(this).text(temp);
	})
	
	//=====================================================
})
</script>
    <style>
        html, body{
            height: 100%;
            width: 100%;

            display: flex;
            flex-direction: column;
            
            font-weight:1000;
            outline: none;
            box-shadow: 5px 10px 8px -8px #888888;
        } 
        #div_body{
            height: 100%;
            width: 100%;
            border-radius : 5px;
            display: flex;
        }
		
		#div_left{
		    width: 90%;
		    border: 5px solid rgb(12, 113, 87); 
		    margin-right: 5px;
		    box-shadow: 15px 15px 15px -5px #888888;
		}
		
		#div_right{
			display:flex;
			justify-content:space-between; 
			flex-direction: column;
		}
		
.nav_button {
	width: 13.1%;
	height:10%;
	
	
	/* background-color: #3498db; */
	/* background-color:#FF971E; */
	background-color:rgb(12, 113, 87);
 	text-shadow: 0px -2px #2980B9;
	color:#f9f3f3;
	
	border: none;
	border-radius: 6px;
    box-shadow: 5px 10px 8px -2px #888888;
	
	margin: 5px;
}
.nav_button:hover{
	background-color: #2ecc71;
 	border-bottom: 5px solid #27ae60;
 	text-shadow: 0px -2px #27ae60;
}

#serch_select, #serch_date{
	border: 3px solid #e53935;
	box-shadow: 5px 10px 8px -8px #888888;
}

#serch_select{
    margin: 5px auto;
    width: 100%;
    outline: none;

}
#serch_input{
	height: 20px;
	font-weight: 1000;
	outline: none;
	border: none;
}

#serch_span{
	display:flex;
	justify-content:center;
	align-items: center;
	flex-direction: row;
	border: 3px solid #e53935;
	width: 100%;
	height: -2.5px;
}
#ho{
	width: 226px;
}
</style>
    <%@ include file="/WEB-INF/views/MKW/MKW_nav.jspf"%>
    <div id = "div_body">
        <div id="div_left">
        <c:choose>
	        <c:when test="${BODY == 'NOTICE_HOME'}">
	    		<%@ include file="/WEB-INF/views/LJH/notice_left.jspf" %>
	    	</c:when>
	    	
	    	<c:when test="${BODY == 'NOTICE_WRITE'}">
	    		<%@ include file="/WEB-INF/views/LJH/notice_write.jspf" %>
	    	</c:when>
	    	
	    <c:when test="${BODY == 'NOTICE_DETAIL'}">
			<%@ include file="/WEB-INF/views/LJH/notice_detail.jspf"%>
		</c:when>
    	</c:choose>
     </div>        
		<div id="div_right">
			<%@ include file="/WEB-INF/views/LJH/notice_right.jspf" %>
		</div>
</div>
	<footer>
   		<%@ include file="/WEB-INF/views/include/footer.jspf"%>
   </footer>
