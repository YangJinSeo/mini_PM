/**
 * check.js
 */
$(function(){
	$("#userId").on("change keyup",function(){
		$.ajax({
			type : "post",
			url : "/login/userIdCheck",
			data : {"userId" : $("#userId").val()},
			dataType : "text",
			success : function(result){
				if(result == "1"){
					$("#idCheck").text("사용중인 아이디입니다.");
					$("#idCheck").css("color","red");
				}else{
					$("#idCheck").text("사용가능한 아이디입니다.");
					$("#idCheck").css("color","blue");
				}
			},
			error:function(){
				alert("서버오류");
			}
		});
	});
	
	
	$("#pmEmpNum").on("change keyup",function(){
			$.ajax({
				type : "post",
				url : "/login/empNumCheck",
				data : {"empNum" : $("#pmEmpNum").val()},
				dataType : "text",
				success : function(result){
					if(result == "1"){
						$("#empNumCheck").text("사용할 수 없는 직원번호입니다. 이미 등록된 직원이거나 인사팀 직원이 아닙니다.");
						$("#empNumCheck").css("color","red");
					}else{
						$("#empNumCheck").text("등록 가능한 직원번호입니다.");
						$("#empNumCheck").css("color","blue");
					}
				},
				error:function(){
					alert("서버오류");
				}
			});
		});
		
	
	$("#empEmail").on("change keyup", function(){
			$.ajax({
				type:"post",
				url:"/login/empEmailCheck",
				dataType:"text",
				data:{"empEmail":$("#empEmail").val()},
				success:function(result){
					if(result == "1"){
						$("#CheckEmpEmail").text("사용중인 이메일입니다.");
						$("#CheckEmpEmail").css("color","red");
					}else{
						$("#CheckEmpEmail").text("사용가능한 이메일입니다.");
						$("#CheckEmpEmail").css("color","blue");
					}
				},
				error:function(){
					alert("서버 오류");
				}
			});
		});
	
	
	
		
		
});/**
 * 
 */