ew Ajax.Request('testurl', {\n    method: 'post',\n    parameters: {param1:"A", param2:"B", param3:"C"},\n    onSuccess: function(response) {\n        fnSccs("additionalArg", response);\n    },\n    onFailure: fnFail\n});