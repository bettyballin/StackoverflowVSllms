function CallServer(urlController) {\n    var returnValue = false;\n    $.ajax({\n        type: "POST",\n        url: urlController,\n        async: false,\n        data: $("form").serialize(),\n        success:\n            function(result) {\n                if (someLogic){\n                    returnValue = true;\n                    return;\n                }\n            },\n        error:\n            function(errorThrown) {\n                alert("Error occured: " + errorThrown);\n            }\n        });\n\n        return returnValue;\n}