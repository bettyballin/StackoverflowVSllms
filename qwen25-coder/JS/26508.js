function recordScore(str) {\n    if (str.length == 0) return;\n\n    var xmlHttp = GetXmlHttpObject();\n    if (xmlHttp == null) {\n        alert("Your browser does not support AJAX!");\n        return;\n    } \n\n    var url = "http://hellworld3.appspot.com/findcountry";\n    var params = "screenname=" + document.getElementById("screenname1").value + "&score=" + document.getElementById("score1").value;\n    alert("params: " + params);\n    xmlHttp.open("POST", url, true);\n\n    xmlHttp.onreadystatechange = function() {\n        // Corrected typo here:\n        alert("entered call back function. readyState value is: " + xmlHttp.readyState + ". Response Text is: " + xmlHttp.responseText);\n\n        if (xmlHttp.readyState == 4) { \n            document.getElementById("message").innerHTML = xmlHttp.responseText;\n        }\n    }\n    xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");\n    xmlHttp.send(params);\n}