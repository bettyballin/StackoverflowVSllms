////Catches the users to keep them from navigating off the page without saved changes...\nwindow.onbeforeunload = CheckSaveStatus;\nvar isInitialized = true; // Assume changes are saved initially\n\nfunction CheckSaveStatus() {\n    if (!isInitialized) {\n        return "You currently have unprocessed changes for this Simulation.";\n    }\n}\n\nfunction checkIfInstanceIsInitialized() {\n    $.ajax({\n        type: "POST",\n        url: "URL.asmx/CheckIfInstanceIsInitilized",\n        data: "{}",\n        contentType: "application/json; charset=utf-8",\n        dataType: "json",\n        success: function(result) {\n            isInitialized = result.d;\n        },\n        error: function(xmlHttpRequest, status, err) {\n            alert(xmlHttpRequest.statusText + " " + xmlHttpRequest.status + " : " + xmlHttpRequest.responseText);\n        }\n    });\n}\n\n// Call this function whenever you want to check the initialization status\ncheckIfInstanceIsInitialized();