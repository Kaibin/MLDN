//初始加载页面时
$(document).ready(function(){
	
	var commenParam = getUrlVars()["commen"];
	var statusParam = getUrlVars()["status"];
	
	var actionUrl;
	var flagname;
	var flagvalue;
	var totalPage;
	if (commenParam != null) {
		$.getJSON("MoreCommenQuestionAction.action?commen="+commenParam,function(data){
			$.each(data.allques,function(i,value){
				$("#tques > tbody:last").append("<tr><td>"+value.title+"</td><td>"+
															value.userid+"</td><td>"+
															value.grade+"</td><td>"+
															value.offerscore+"</td><td>"+
															value.questiontime+"</td><td>"+
															value.questiontime+"</td><tr>");
			     ;
			});
		    actionUrl = data.jspUrl;
		    flagname=data.flagname;
		    flagvalue=data.flagvalue;
//			alert(actionUrl+flagname+flagvalue);
			$('#cp').val(data.pagination.currentPage);
			$("#page").attr("action",data.jspUrl);
			totalPage = data.pagination.totalPage;
			
			if($('#cp').val() == 1){
				alert("!!!!");
				$('#first_page').removeAttr('href');
			}
				
			if($('#cp').val() == totalRecord){
				alert("!!!!");
				$('#last_page').removeAttr('href');
				$('#next_page').removeAttr('href');
			}
		});
		
		
	};
	if (statusParam != null) {
		$.getJSON("MoreStatusQuestionAction.action?status="+statusParam,function(data){
			$.each(data.allques,function(i,value){
				$("#tques > tbody:last").append("<tr><td>"+value.title+"</td><td>"+
															value.userid+"</td><td>"+
															value.grade+"</td><td>"+
															value.offerscore+"</td><td>"+
															value.questiontime+"</td><td>"+
															value.questiontime+"</td><tr>");
			     ;
			});
			actionUrl = data.jspUrl;
		    flagname=data.flagname;
		    flagvalue=data.flagvalue;
//			alert(actionUrl+flagname+flagvalue);
			$('#cp').val(data.pagination.currentPage);
			$("#page").attr("action",data.jspUrl);
			totalPage = data.pagination.totalPage;
			
			if($('#cp').val() == 1){
				alert("!!!!");
				$('#first_page').removeAttr('href');
			}
				
			if($('#cp').val() == totalRecord){
				alert("!!!!");
				$('#last_page').removeAttr('href');
				$('#next_page').removeAttr('href');
			}
		});
		
		
	};
	
	
	$('#first_page').live("click", function(){
		$('#cp').attr("value",1);
		alert($('#cp').val());
		alert(actionUrl+"?"+flagname+"="+flagvalue);
		var params = $('#page').serialize();
		$.ajax({
			url:actionUrl+"?"+flagname+"="+flagvalue,
			type:"POST",
			data:params,
			dataType:"json",
			success:function(data){
				$("#tques>tbody>tr:not(:first)").remove();
				$.each(data.allques,function(i,value){
					$("#tques > tbody:last").append("<tr><td>"+value.title+"</td><td>"+
																value.userid+"</td><td>"+
																value.grade+"</td><td>"+
																value.offerscore+"</td><td>"+
																value.questiontime+"</td><td>"+
																value.questiontime+"</td><tr>");
				     ;
				});
				$('#cp').val(data.pagination.currentPage);
				$("#page").attr("action",data.jspUrl);
			}
		});
	
	});
	
	$('#last_page').live("click", function(){
		$('#cp').attr("value",totalPage);
		alert($('#cp').val());
		alert(actionUrl+"?"+flagname+"="+flagvalue);
		var params = $('#page').serialize();
		$.ajax({
			url:actionUrl+"?"+flagname+"="+flagvalue,
			type:"POST",
			data:params,
			dataType:"json",
			success:function(data){
				$("#tques>tbody>tr:not(:first)").remove();
				$.each(data.allques,function(i,value){
					$("#tques > tbody:last").append("<tr><td>"+value.title+"</td><td>"+
																value.userid+"</td><td>"+
																value.grade+"</td><td>"+
																value.offerscore+"</td><td>"+
																value.questiontime+"</td><td>"+
																value.questiontime+"</td><tr>");
				     ;
				});
				$('#cp').val(data.pagination.currentPage);
				$("#page").attr("action",data.jspUrl);
			}
		});
	
	});
	
	
	
	 $('#next_page').live("click", function(){
		var temp = parseInt($('#cp').val())+1;
		$('#cp').attr("value",temp);
		alert($('#cp').val());
		alert(actionUrl+"?"+flagname+"="+flagvalue);
		var params = $('#page').serialize();
		$.ajax({
			url:actionUrl+"?"+flagname+"="+flagvalue,
			type:"POST",
			data:params,
			dataType:"json",
			success:function(data){
				$("#tques>tbody>tr:not(:first)").remove();
				$.each(data.allques,function(i,value){
					$("#tques > tbody:last").append("<tr><td>"+value.title+"</td><td>"+
																value.userid+"</td><td>"+
																value.grade+"</td><td>"+
																value.offerscore+"</td><td>"+
																value.questiontime+"</td><td>"+
																value.questiontime+"</td><tr>");
				     ;
				});
				$('#cp').val(data.pagination.currentPage);
				$("#page").attr("action",data.jspUrl);
			}
		});
	
	});
	 
	 $('#prior_page').live("click", function(){
			var temp = parseInt($('#cp').val())-1;
			$('#cp').attr("value",temp);
			alert($('#cp').val());
			alert(actionUrl+"?"+flagname+"="+flagvalue);
			
			var params = $('#page').serialize();
			$.ajax({
				url:actionUrl+"?"+flagname+"="+flagvalue,
				type:"POST",
				data:params,
				dataType:"json",
				success:function(data){
					$("#tques>tbody>tr:not(:first)").remove();
					$.each(data.allques,function(i,value){
						$("#tques > tbody:last").append("<tr><td>"+value.title+"</td><td>"+
																	value.userid+"</td><td>"+
																	value.grade+"</td><td>"+
																	value.offerscore+"</td><td>"+
																	value.questiontime+"</td><td>"+
																	value.questiontime+"</td><tr>");
					     ;
					});
					$('#cp').val(data.pagination.currentPage);
					$("#page").attr("action",data.jspUrl);
				}
			});
		
		});
	 
	 $('#keyWord').blur(function() {
		 
		 var kw = $('#keyWord').val();
		  alert(kw);
		  var params = $('#page').serialize();
			$.ajax({
				url:"SearchQuestionAction.action?keyWord="+kw,
				type:"POST",
				data:params,
				dataType:"json",
				success:function(data){
					$("#tques>tbody>tr:not(:first)").remove();
					$.each(data.allques,function(i,value){
						$("#tques > tbody:last").append("<tr><td>"+value.title+"</td><td>"+
																	value.userid+"</td><td>"+
																	value.grade+"</td><td>"+
																	value.offerscore+"</td><td>"+
																	value.questiontime+"</td><td>"+
																	value.questiontime+"</td><tr>");
					     ;
					});
					$('#cp').val(1);
					$("#page").attr("action",data.jspUrl);
					actionUrl = data.jspUrl;
					flagname= "keyWord";
					flagvalue= data.flagvalue;
					totalPage = data.Pagination.totalPage;
					alert($('#cp').val());
					alert("SearchQuestionAction.action?keyWord="+kw);
					
					if($('#cp').val() == 1){
						alert("!!!!");
						$('#first_page').removeAttr('href');
					}
						
					if($('#cp').val() == totalRecord){
						alert("!!!!");
						$('#last_page').removeAttr('href');
						$('#next_page').removeAttr('href');
					}
				}
			});
		  
		  
		  
		});
	
});