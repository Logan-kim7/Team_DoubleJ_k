document.addEventListener("DOMContentLoaded", function()
{		
	const rootPath = "http://localhost:8080/dripbag/";
	
	//=============================================================================
	if($(".search_input").length)
	{
		$(".search_input").focus()
		{
			window.onkeydown = function(event)
			{
				if(event.keyCode == 13)
					search();
			}
		}
	}
	;
	//=============================================================================
	
	$(".fas.fa-search").click(function() {search();});
	
	//=============================================================================
	function search()
	{
		if($(".search_input").val() == "")
			return;
		
		let path = window.location.pathname.split("/");
		let table;
			 if (path[2] == "notice") { table = "tbl_notice" }
		else if (path[2] == "gtrand") { table = "tbl_googleComent" }			
		else if (path[2] == "news")   { table = "tbl_NewsComment" }
		$.ajax
		({
			url 		: rootPath + path[2] + "/search",
			type 		: "GET",
			contentType :"application/json; charset=UTF-8",
			data : { 
					 "table"   : table, 
					 "flag"    : $(".search_select option:selected").val(),
					 "content" : $(".search_input").val(),
					 "seq"	   : $(".search_input").data("seq")
				   },
			success : function(data)
			{
				 if(data == true)
				 	location.reload();
				 
				 else		
				 	alert("검색결과 없음")
			},
			error : function(request,status,error) {alert("검색 에러") }	
		})
	}
	//============================================================================= 
});