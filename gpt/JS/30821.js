$.ajax({\n    type: "POST",\n    url: "YourServiceUrl/GetSerializedList",\n    contentType: "application/json; charset=utf-8",\n    dataType: "json",\n    success: function(response) {\n        console.log(response);\n        // Handle the response\n    },\n    error: function(error) {\n        console.error(error);\n    }\n});