function getText(id) {\n    var txt = document.getElementById("MyText");\n\n    txt.disabled = "disabled";\n    txt.innerText = "";\n    txt.className = "busy";\n\n    // Append a unique parameter to prevent caching\n    var oRequest = zXmlHttp.createRequest();\n    var url = "get_text.php?id=" + id + "&nocache=" + new Date().getTime();\n    oRequest.open("GET", url, true);\n    oRequest.send(null);\n\n    oRequest.onreadystatechange = function() {\n        if (oRequest.readyState == 4) {\n            if (oRequest.status == 200) {\n                txt.innerText = oRequest.responseText;\n            } else {\n                txt.innerText = oRequest.status + ": " + oRequest.statusText;  \n            }\n\n            txt.disabled = "";\n            txt.className = "";\n\n            oRequest = null;\n        }\n    };\n}