$.ajax({\n    url: '/ControllerName/GetString',\n    type: 'GET',\n    success: function(data) {\n        console.log(data); // This will log "This is a string result"\n    },\n    error: function(error) {\n        console.error('An error occurred:', error);\n    }\n});