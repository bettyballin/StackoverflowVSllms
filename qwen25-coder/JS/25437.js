// Store the xhr object when making the AJAX call\nvar xhr = $.ajax({\n    url: 'your-url-here',\n    method: 'GET',\n    success: function(data) {\n        console.log('Ajax Call Successful', data);\n    },\n    error: function(jqXHR, textStatus, errorThrown) {\n        if (textStatus === 'abort') {\n            console.log('Ajax call was aborted');\n        } else {\n            console.error('Error in Ajax call', textStatus, errorThrown);\n        }\n    }\n});\n\n// Somewhere later in your code, you can abort the request\nxhr.abort();