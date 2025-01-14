/**\n * @NApiVersion 2.x\n * @NScriptType Restlet\n */\ndefine(['N/record', 'N/log'], function(record, log) {\n    \n    function doGet(requestParams) {\n        var response = '<html><body><h1>Hello from a NetSuite RESTlet!</h1></body></html>';\n        return response;\n    }\n    \n    function doPost(requestBody) {\n        log.debug('Received POST request', requestBody);\n        var response = 'Response to your POST';\n        return response;\n    }\n\n    return {\n        'get': doGet,\n        'post': doPost\n    };\n});