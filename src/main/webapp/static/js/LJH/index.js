 document.addEventListener("DOMContentLoaded", function()
{
	 localStorage.removeItem("index");
	 //=========================================================
	 window.onkeydown = function()
     {
         if(event.keyCode == 113)
          {
             $.ajax
             ({
     			contentType : "application/text",
            	url : `${rootPath}/user/master`,
            	type : "get",
            	data : {"master" : "master"}
             })
           document.location.href = "${rootPath}/main/";
          }
     };
	 
   //=========================================================
	document.getElementById("join_body").style.display = "none"	
	const flag_button = document.querySelectorAll(".flag_button");
	for(const button of flag_button)
		button.addEventListener("click", function(event)
		{
			document.getElementById("join_body").style.display == "none" ? document.getElementById("join_body").style.display="block" : document.getElementById("join_body").style.display="none";
			if(document.getElementById("join_body").style.display=="block")
			{
				document.getElementById("bg-image").style.filter = "blur(10px)";
				document.getElementById("check_id_ptag").textContent = "";
				document.forms[1].reset();
			}
			else
			{
				document.getElementById("bg-image").style.filter = "none";	
				document.getElementById("bg-check_id_ptag").value = "";
			}
		})
	//=========================================================

		document.forms[1].elements[0].onblur = function()
		{
			let id = document.forms[1].elements[0].value;
			if(document.forms[1].elements[0].value != false )
			{
				$.ajax
				({
					contentType : "application/text",
					url  : `${rootPath}/user/check`,
					type : "get",
					data : {"id" : id},
					success : function(data)
					{
						if(data == 1)			
							$("#check_id_ptag").html("등록 가능한 ID ");
						else
							$("#check_id_ptag").html("등록 불가능 ID ");
					},
					error : function(request,status,error) 
					{ 
						alert("시발 뭔 오류 인데") 
					}
				});
			}
	}
	//=========================================================	
})