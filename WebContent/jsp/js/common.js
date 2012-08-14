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

function getUrlVars(){
    var vars = [], hash;
    var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
    for (var i = 0; i < hashes.length; i++) {
        hash = hashes[i].split('=');
        vars.push(hash[0]);
        vars[hash[0]] = hash[1];
    }
    return vars;
}