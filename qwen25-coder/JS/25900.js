var xmlhttp;\n\nfunction register() {\n    xmlhttp = GetXmlHttpObject();\n    if(xmlhttp == null) {\n        alert("Your browser does not support AJAX!");\n        return;\n    }\n    var url="register.php";\n    url += "?id="+uniqueid+"&name="+encodeURIComponent(name)+"&passwrd="+encodeURIComponent(passwrd1)+"&email="+encodeURIComponent(email);\n    xmlhttp.onreadystatechange=statechanged;\n    xmlhttp.open("GET", url, true);\n    xmlhttp.send(null); \n}\n\nfunction statechanged() {\n    if(xmlhttp.readyState == 4) {\n        document.getElementById("response").innerHTML = xmlhttp.responseText;\n    }\n}\n\nfunction GetXmlHttpObject() {\n    if(window.XMLHttpRequest) {\n        return new XMLHttpRequest();\n    }\n    if(window.ActiveXObject) {\n        return new ActiveXObject("Microsoft.XMLHTTP");\n    }\n    return null;\n}\n\nfunction testing() {\n    document.getElementById("mainbody").innerHTML += "<br/>This is my first JavaScript!";\n}