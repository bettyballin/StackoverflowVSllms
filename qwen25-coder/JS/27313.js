function check_username(username) {\n    var httpRequest;\n    make_request();\n    function stateck() { \n        if(httpxml.readyState == 4) {  \n            if (httpxml.responseText.includes("Username Ok")) { // Use includes method\n                UserNameOk = true;\n            } else {\n                UserNameOk = false;\n            }\n            checkCanSubmit();\n            document.getElementById("user_div").innerHTML = httpxml.responseText;\n        }\n    }\n\n    httpRequest.onreadystatechange = stateck; // Ensure correct variable name is used\n    user_url = "ajax_username.php?username=" + encodeURIComponent(username.value); // Use encodeURIComponent for URL safety\n    httpRequest.open("GET", user_url, true);\n    httpRequest.send(null);\n}\n\nfunction checkCanSubmit() {\n    if (UserNameOk && PasswordOk && EmailOk) {\n        document.getElementById("button").disabled = false;\n    } else {\n        document.getElementById("button").disabled = true;\n    }\n}