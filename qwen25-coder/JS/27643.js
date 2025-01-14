// Controller role: JavaScript/jQuery making an AJAX call\n$.ajax({\n    url: 'your-server-endpoint', // Communication with Model\n    method: 'GET',\n    success: function(data) {\n        // Update View (DOM) based on the server's response data\n        $('#content').html(data);\n    },\n    error: function() {\n        console.error('Failed to fetch data');\n    }\n});