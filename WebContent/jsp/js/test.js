$(function() {
	    $("#flex").flexigrid({
		        url : 'MoreCommenQuestionAction.action',
		        dataType : 'json',
		        colModel : [{
			            display : '标题',
			            name : 'title',
			            width : 50,// 得加上 要不IE报错
			            sortable : true,
			            align : 'center'
		            }, {
			            display : '用户ID',
			            name : 'userid',
			            width : 100,
			            sortable : true,
			            align : 'center'
		            }, {
			            display : '用户等级',
			            name : 'grade',
			            width : 100,
			            sortable : true,
			            align : 'center'
		            }, {
			            display : '提问时间',
			            name : 'questiontime',
			            width : 100,
			            sortable : true,
			            align : 'center'
		            }, {
			            display : '点击',
			            name : 'clickcount',
			            width : 100,
			            sortable : true,
			            align : 'center'
		            }, {
			            display : '分数',
			            name : 'offerscore',
			            width : 100,
			            sortable : true,
			            align : 'center'
		            }],
		       
		        sortname : "title",
		        sortorder : "asc",
		        usepager : true,
		        title : '商品信息',
		        useRp : true,
		        rp : 10,
		        showTableToggleBtn : true,
		        width : 700,
		        height : 263
	        });
	    
	    var dd = $("#flex").flexigrid.attr("url");
	    alert(dd);
		
    });