// Function to simulate server delay using setTimeout\nfunction simulateServerDelay(resolve) {\n    setTimeout(resolve, 6000); // Simulating a delay of 6 seconds\n}\n\n$(document).ready(function() {\n    $.ajax({\n        url: 'your-server-endpoint', // Replace with your actual endpoint\n        method: 'GET',\n        timeout: 5000, // Timeout set for 5 seconds\n        success: function(data) {\n            console.log('Success:', data);\n        },\n        error: function(jqXHR, textStatus, errorThrown) {\n            if (textStatus === 'timeout') {\n                console.error('Request timed out');\n            } else {\n                console.error('Error in request:', textStatus, errorThrown);\n            }\n        },\n        beforeSend: function() {\n            return new Promise(simulateServerDelay); // Simulating delay\n        }\n    });\n});