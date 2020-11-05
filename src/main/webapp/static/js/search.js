document.addEventListener("DOMContentLoaded", function()
{		
	const rootPath = "http://localhost:8080/dripbag/";
	//=============================================================================
	$(".search_input").focus()
	{
		window.onkeydown = function(event)
		{
			if(event.keyCode == 13)
				search();
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
			 if(path[2] == "notice")  { table = "tbl_notice" }
		else if (path[2] == "gtrand") { table = "tbl_gtrand" }			
		else if (path[2] == "news")   { table = "tbl_news" }
		$.ajax
		({
			url 		:  rootPath + path[2] + "/search",
			type 		: "get",
			dataType    : "json",
			contentType :"application/json; charset=UTF-8",
			data : { 
					 "table"   : table, 
					 "flag"    : $(".search_select option:selected").val(),
					 "content" : $(".search_input").val()
				   },
			success : function(data)
			{
				//localStorage.setItem("search", data);
				location.reload();
			},
			error : function(request,status,error) {alert("검색결과 없음") }	
		})
	}
	//=============================================================================
		function clearSearch()
		{			
			let path = window.location.pathname.split("/");	
			let flag = sessionStorage.getItem("search");
			$.ajax
			({
				url  : rootPath + "/any/search/clear",
				type : "get",
				data : {"path" : path[2], "flag" : flag},
				success : function(data) { sessionStorage.removeItem("search"); }
			});
		}
	//============================================================================= 
});