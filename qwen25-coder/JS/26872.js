function CallServer(urlController) {\n    return new Promise(function(resolve, reject) {\n        $.ajax({\n            type: "POST",\n            url: urlController,\n            data: $("form").serialize(),\n            success: function(result) {\n                if (someLogic)\n                    resolve(true);\n                else\n                    resolve(false);\n            },\n            error: function(errorThrown) {\n                reject(false); // or handle error differently\n            }\n        });\n    });\n}\n\nasync function Next() {\n    try {\n        var result = await CallServer("/Signum/TrySave");\n        if (result === true) {\n            document.forms[0].submit();\n        }\n    } catch (error) {\n        console.error("An error occurred:", error);\n    }\n}