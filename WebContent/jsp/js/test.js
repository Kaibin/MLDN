$(function() {
	    $("#flex").flexigrid({
		        url : 'MoreCommenQuestionAction.action',
		        dataType : 'json',
		        colModel : [{
			            display : '����',
			            name : 'title',
			            width : 50,// �ü��� Ҫ��IE����
			            sortable : true,
			            align : 'center'
		            }, {
			            display : '�û�ID',
			            name : 'userid',
			            width : 100,
			            sortable : true,
			            align : 'center'
		            }, {
			            display : '�û��ȼ�',
			            name : 'grade',
			            width : 100,
			            sortable : true,
			            align : 'center'
		            }, {
			            display : '����ʱ��',
			            name : 'questiontime',
			            width : 100,
			            sortable : true,
			            align : 'center'
		            }, {
			            display : '���',
			            name : 'clickcount',
			            width : 100,
			            sortable : true,
			            align : 'center'
		            }, {
			            display : '����',
			            name : 'offerscore',
			            width : 100,
			            sortable : true,
			            align : 'center'
		            }],
		       
		        sortname : "title",
		        sortorder : "asc",
		        usepager : true,
		        title : '��Ʒ��Ϣ',
		        useRp : true,
		        rp : 10,
		        showTableToggleBtn : true,
		        width : 700,
		        height : 263
	        });
	    
	    var dd = $("#flex").flexigrid.attr("url");
	    alert(dd);
		
    });