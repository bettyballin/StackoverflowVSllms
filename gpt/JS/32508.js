var xmlhttp = new XMLHttpRequest();\nxmlhttp.onreadystatechange = function() {\n    if (xmlhttp.readyState == 4) {\n        if (xmlhttp.status == 200) {\n            element(id).innerHTML = "Online";\n        } else {\n            element(id).innerHTML = "Offline";\n        }\n    }\n};\n\nxmlhttp.onerror = function() {\n    element(id).innerHTML = "Offline";\n};\n\n// Replace 'yourURL' with the actual URL you are checking\nxmlhttp.open("GET", "yourURL", true);\nxmlhttp.send();