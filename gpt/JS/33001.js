$.ajax({\n    url: 'https://yourserver.com/api/endpoint',\n    type: 'POST',\n    headers: {\n        'Authorization': 'Bearer YOUR_API_KEY'\n    },\n    data: {\n        // your data here\n    },\n    success: function(response) {\n        console.log('Success:', response);\n    },\n    error: function(xhr, status, error) {\n        console.error('Error:', error);\n    }\n});