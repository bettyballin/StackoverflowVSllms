$.ajax({\n    type: 'POST',\n    url: 'Default.aspx/MyMethod',\n    contentType: "application/json; charset=utf-8",\n    dataType: "json",\n    xhrFields: {\n        withCredentials: true // Ensures cookies are sent\n    },\n    success: function (result) {\n        alert(result.d);\n    }\n});