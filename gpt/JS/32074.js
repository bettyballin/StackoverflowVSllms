$.ajax({\n    url: 'your_server_script.php',\n    type: 'POST',\n    data: { action: 'save' },\n    success: function(response) {\n        console.log('Server response:', response);\n    },\n    error: function(xhr, status, error) {\n        console.error('AJAX request failed:', status, error);\n    }\n});