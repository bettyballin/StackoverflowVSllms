function login() {\n    var xmlhttp = GetXmlHttpObject();\n    if (xmlhttp == null) {\n        alert("Your browser does not support AJAX!");\n        return;\n    }\n    var url = "login.php";\n    url = url + "?id=" + encodeURIComponent(username) + "&passwrd=" + encodeURIComponent(passwrd);\n    xmlhttp.onreadystatechange = stateChangedLogin;\n    xmlhttp.open("GET", url, true);\n    xmlhttp.send(null);\n}\n\nfunction stateChangedLogin() {\n    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {\n        var responseText = xmlhttp.responseText;\n        if (responseText.includes("<font color='red'>Your User Name or Password is incorrect. Please try again.</font>")) {\n            document.getElementById("response").innerHTML = responseText;\n        } else {\n            // Change the URL without reloading\n            window.history.pushState({}, '', '/abc.html/login.php');\n            document.getElementById("mainbody").innerHTML = responseText;\n        }\n    }\n}