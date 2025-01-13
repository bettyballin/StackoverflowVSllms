window.onbeforeunload = CheckSaveStatus;\n\nfunction CheckSaveStatus(callback) {\n  $.ajax({\n    type: "POST",\n    url: "URL.asmx/CheckIfInstanceIsInitilized",\n    data: "{}",\n    contentType: "application/json; charset=utf-8",\n    dataType: "json",\n    success: function(result) {\n      callback(result.d);\n    },\n    error: function(xmlHttpRequest, status, err) {\n      alert(xmlHttpRequest.statusText + " " + xmlHttpRequest.status + " : " + xmlHttpRequest.responseText);\n    }\n  });\n}\n\nCheckSaveStatus(function(isInitialized) {\n  if (isInitialized) {\n    return "You currently have unprocessed changes for this Simulation.";\n  }\n});