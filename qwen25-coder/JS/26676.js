$.ajax({\n    url: "path/to/your/CFC.cfc?method=yourMethod",\n    type: 'POST',\n    data: { param1: value1, param2: value2 },\n    success: function(response) {\n        console.log('Success:', response);\n    },\n    error: function(error) {\n        console.error('Error:', error);\n    }\n});