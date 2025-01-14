try {\n    var ajaxManager = $.manageAjax({ manageType: 'sync', maxReq: 0 });\n    \n    // setup code calling ajaxManager.add(...)\n    \n    // Example success callback of the first request\n    function onSuccess(data) {\n        if (/* certain criteria met */) {\n            console.log("Aborting queue as per conditions");\n            \n            // Check if there are any queues left before aborting\n            if (ajaxManager && typeof ajaxManager.abort === 'function') {\n                ajaxManager.abort();\n            } else {\n                console.error('No queue to abort or method not available');\n            }\n        } else {\n            console.log("Continuing with the rest of the requests");\n        }\n    }\n\n} catch(error) {\n    console.error('An error occurred:', error);\n}