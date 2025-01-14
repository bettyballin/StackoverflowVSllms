// Example of an AJAX call using jQuery\n$.ajax({\n    url: '/api/user/data',\n    method: 'GET',\n    headers: {\n        Authorization: 'Bearer YOUR_ACCESS_TOKEN'\n    },\n    success: function(data) {\n        console.log('User data:', data);\n    },\n    error: function(xhr, status, error) {\n        console.error('An error occurred:', xhr.responseText);\n    }\n});