$.ajax({\n    type: "POST",\n    url: window.location.protocol + "//" + window.location.host + "/" + method,\n    data: body,\n    success: function (msg) {\n        alert("Data Saved: " + msg);\n    },\n    error: function (msg) {\n        alert("Broken: " + window.location.protocol + "//" + window.location.host + "/" + method + msg.responseText);\n    }\n});