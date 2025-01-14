function deleteItem(layer, url) {\n    var xmlHttp = GetXmlHttpObject();\n    if (xmlHttp == null) {\n        alert("Your browser is not supported?");\n        return;\n    }\n    xmlHttp.onreadystatechange = function() {\n        if (xmlHttp.readyState == 4) {\n            console.log(xmlHttp.responseText); // Log the response for debugging\n            if (xmlHttp.responseText === 'result=true') {\n                var row = document.getElementById(layer);\n                row.parentNode.removeChild(row);\n            } else {\n                alert('Deletion failed or something went wrong.');\n            }\n        } else if (xmlHttp.readyState == 1) {\n            document.getElementById(layer).innerHTML = "loading";\n        }\n    }\n    xmlHttp.open("GET", url, true);\n    xmlHttp.send(null);\n}