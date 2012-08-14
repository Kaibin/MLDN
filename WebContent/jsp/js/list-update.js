$(document).ready(function(){
	
	var commen;
	var status;
	var commenParam = getUrlVars()["commen"];
	var statusParam = getUrlVars()["status"];
	    
	if (commenParam != null) {
        commen = commenParam;
        url = "MoreCommenQuestionAction.action?commen="+commen;  
    if (ajaxPostRequest(url, commen)) {
          
            $('#listques').html(xmlHttp.responseText);
        }
       
        
    } else if (statusParam != null) {
            status = statusParam;
            url = "MoreStatusQuestionAction.action";
            if (ajaxPostRequest(url, commem)) {
                
                $('#listques').html(xmlHttp.responseText);
            }
            else {
            
            }
        }
	
	
	 $('#searchForm').submit(function(){
		   alert("!!");
		   $('#nokia').attr("id", "home");
		   var keyWord = $('#keyWord').val();
		   alert(keyWord);
		   url = "SearchQuestionAction.action?keyWord="+keyWord;
		   if (ajaxPostRequest(url, commem)) {
               
               $('#listques').html(xmlHttp.responseText);
           }
	    });
	 $('a[id^=page_]').live("click", function(){
		 alert("%{jspUrl}");
	 });
	 
});



var xmlHttp;

function ajaxPostRequest(url, param){
    if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    }
    else 
        if (window.ActiveXObject) {
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        else {
            return;
        }
    
    xmlHttp.open('POST', url, false);
    xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xmlHttp.send(param);
    
    if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
        return true;
    }
    else {
        return false;
    }
}