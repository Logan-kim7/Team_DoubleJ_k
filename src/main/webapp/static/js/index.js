document.addEventListener("DOMContentLoaded", function()
{
	sessionStorage.removeItem("index");
	const rootPath = "http://localhost:8080";
	 //=====================세션 다이렉트 등록(master)====================================
	 window.onkeydown = function()
	    {
	        if(event.keyCode == 113)
	         {
	            $.ajax
	            ({
	           		url  		: rootPath + "/dripbag/user/check/",
	           		type 		: "post",
	           		data 		: {"master" : "master"},
	           		success     : function()
	           		{
	           			setTimeout(function() {
		           			document.location.href = rootPath + "/dripbag/main/";
	           			}, 500);		
	           		}
	            })
	            
	         }
	    };	 
	//================================ 회원가입 CSS ON & OFF =====================
	document.getElementById("join_body").style.display = "none"	
	const flag_button = document.querySelectorAll(".flag_button");
	for(const button of flag_button)
		button.addEventListener("click", function(event)
		{
			document.getElementById("check_id_ptag").textContent = "";
			document.forms[1].reset();
			document.getElementById("bg-image").style.filter = "blur(10px)";				
			
			if(document.getElementById("join_body").style.display != "none")
				document.getElementById("bg-image").style.filter = "none";
					
			$("#join_body").slideToggle("650"); 
		})
	//======================아이디 중복 AJAX =================================
		document.forms[1].elements[0].onblur = function()
		{
			let id = document.forms[1].elements[0].value;
			if(document.forms[1].elements[0].value != false )
			{
				$.ajax
				({
					contentType : "application/text",
					url  : rootPath + "/dripbag/user/check",
					type : "get",
					data : {"id" : id},
					success : function(data)
					{
						if(data == true)			
							$("#check_id_ptag").html("등록 가능한 ID ");
						else
							$("#check_id_ptag").html("등록 불가능 ID ");
					},
					error : function(request,status,error) { }
				});
			}
	}
	//==========================================================================
});