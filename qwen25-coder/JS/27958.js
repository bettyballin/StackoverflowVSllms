$.ajax({\n    url: 'https://api.example.com/data',\n    type: 'GET',\n    success: function(response){\n        console.log(response);\n    },\n    error: function(error){\n        console.error('Error:', error);\n    }\n});