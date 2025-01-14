$.ajax({\n    url: 'your-url-here',\n    method: 'GET', // or your HTTP method\n    dataType: 'json', // ensures the response is parsed as JSON\n    success: function(data) {\n        // Ensure data is an array of objects\n        if (Array.isArray(data)) {\n            jQuery.each(data, function(index, itemData) {\n                console.log('TEST1:', itemData.TEST1);\n                console.log('TEST2:', itemData.TEST2);\n                console.log('TEST3:', itemData.TEST3);\n                // Access other properties as needed\n            });\n        } else {\n            console.error('Unexpected data format');\n        }\n    },\n    error: function(jqXHR, textStatus, errorThrown) {\n        console.error('AJAX Error: ' + textStatus + ', ' + errorThrown);\n    }\n});