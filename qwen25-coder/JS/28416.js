function fetchSessionData() {\n       var xhr = new XMLHttpRequest();\n       xhr.open("POST", "YourPage.aspx/GetSessionData", true);\n       xhr.setRequestHeader("Content-Type", "application/json; charset=utf-8");\n       xhr.onreadystatechange = function () {\n           if (xhr.readyState === 4 && xhr.status === 200) {\n               var data = JSON.parse(xhr.responseText);\n               console.log(data.d); // Assuming the WebMethod returns a string, data.d will have it.\n           }\n       };\n       xhr.send(null);\n   }