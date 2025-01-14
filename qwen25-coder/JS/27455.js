function getName(refId) {\n    var resp = '';\n    new Ajax.Request('/servlet/GetName', {\n        method: 'post',\n        parameters: { \n            'requestType': 'ref',\n            'value': refId\n        },\n        onSuccess: function(transport) {\n            try {\n                // Debugging logs\n                console.log('Response Text:', transport.responseText);\n                var trimmedResponse = (String(transport.responseText)).trim();\n                console.log('Trimmed Response:', trimmedResponse);\n\n                setName(trimmedResponse); // Ensure setName is defined somewhere\n            } catch (e) {\n                console.error('Error in onSuccess callback:', e);\n            }\n        },\n        onFailure: function() {\n            console.error('Request failed');\n        }\n    });\n}