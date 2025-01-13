$.ajax({\n    url: 'your-data-endpoint', // Your data URL\n    method: 'GET',\n    dataType: 'json',\n    success: function(data) {\n        // Assuming 'data' is the array of data items\n        populateWebGrid(data);\n    },\n    error: function(xhr, status, error) {\n        console.error('Data loading error:', error);\n    }\n});