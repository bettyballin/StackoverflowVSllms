$.ajax({\n    url: 'your-url-here',\n    method: 'GET', // or POST\n    success: function(data) {\n        console.log('Data retrieved:', data);\n    },\n    error: function(xhr, status, error) {\n        console.error('Error fetching data:', error);\n    }\n});