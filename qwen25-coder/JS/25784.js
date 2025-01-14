// Global object to store results of AJAX calls based on a key\nvar ajaxCache = {};\n\n$('#getSelectOptions').bind("click", function() {\n    var uniqueKey = 'uniqueKeyForThisRequest'; // This could be an ID or any unique identifier for the request\n    populateSelect(this, uniqueKey);\n});\n\nfunction populateSelect(whatWasClicked, uniqueKey) {\n    var thisSelect = $(whatWasClicked).parents("div").find("select");\n\n    if (ajaxCache[uniqueKey]) {\n        // Use cached data if available\n        $(thisSelect).html(ajaxCache[uniqueKey]);\n        return;\n    }\n\n    var before = function() { $(loading).show(); };\n    var complete = function() { $(loading).hide(); };\n    var data = {'_service': 'myService', '_program': 'myProgram'};\n    var error = function(){ alert("Error"); };\n    \n    // Store the success callback in a variable and pass it correctly\n    var successCallback = function(request) {\n        $(thisSelect).html(request);\n        ajaxCache[uniqueKey] = request; // Cache the result\n    };\n\n    var waitTime = 20000;\n\n    ajaxCall(thisSelect, waitTime, before, complete, data, successCallback, error);\n}\n\nfunction ajaxCall(elementToPopulate, waitTime, whatToDoBeforeAjaxSend,\n                 whatToDoAfterAjaxSend, dataToSendToTheServer,\n                 whatToDoAfterSuccess, whatToDoAfterError) {\n    $.ajax({\n        type: "POST",\n        url: "http://myURL/cgi-bin/broker",\n        dataType: "text",\n        data: dataToSendToTheServer,\n        timeout: waitTime,\n        beforeSend: whatToDoBeforeAjaxSend,\n        error: function(request) { whatToDoAfterError(request); }, // Correct usage of error callback\n        success: function(response) { whatToDoAfterSuccess(response); } // Correct usage of success callback\n    });\n}