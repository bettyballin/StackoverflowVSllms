// Sending data to the server and receiving a response\n$.ajax({\n    url: 'your-server-endpoint.php',\n    type: 'POST',\n    data: { key1: 'value1', key2: 'value2' },\n    dataType: 'json',\n    success: function(response) {\n        // Handle the response received from the server\n        console.log(response);\n        // Example: Accessing data from the response\n        var receivedData = response.key; // Assuming the server returns a JSON object\n    },\n    error: function(jqXHR, textStatus, errorThrown) {\n        console.error('Error: ' + textStatus + ' - ' + errorThrown);\n    }\n});