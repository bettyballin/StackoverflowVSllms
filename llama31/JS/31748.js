function ajaxModify(controller, parameters, div_id) {\n    var div = $(div_id);\n\n    var request = new Ajax.Request (\n        controller, \n        {\n            method: "post",\n            parameters: parameters,\n            onSuccess: function(data) {\n                div.innerHTML = data.responseText;\n                // Evaluate scripts if any\n                var scripts = div.getElementsByTagName('script');\n                for (var i = 0; i < scripts.length; i++) {\n                    eval(scripts[i].text);\n                }\n            },\n            onFailure: function() {\n                div.innerHTML = "Information Temporarily Unavailable";  \n            }\n        }\n    );\n}