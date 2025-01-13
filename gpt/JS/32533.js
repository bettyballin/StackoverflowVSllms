var isRequestInProgress = false;\n\nfunction fetchData() {\n    if (!isRequestInProgress) {\n        isRequestInProgress = true;\n\n        $.ajax({\n            url: 'your-url-here',\n            method: 'GET',\n            success: function(data) {\n                // Process your data here\n            },\n            error: function(jqXHR, textStatus, errorThrown) {\n                // Handle any errors\n            },\n            complete: function() {\n                isRequestInProgress = false;\n            }\n        });\n    }\n}\n\n// Set the interval to call fetchData\nsetInterval(fetchData, 5000); // Adjust the interval as needed