$.ajax({\n    url: 'your-api-endpoint',\n    type: 'POST',\n    data: {\n        // your data here\n        example: 'ÆØÅ'\n    },\n    contentType: 'application/x-www-form-urlencoded; charset=UTF-8',\n    success: function(response) {\n        console.log(response);\n    },\n    error: function(error) {\n        console.error(error);\n    }\n});