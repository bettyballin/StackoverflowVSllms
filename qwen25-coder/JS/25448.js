$.ajax({\n    url: url + "?name=test",\n    type: "GET",\n    timeout: 10000,\n    dataType: "json",\n    success: function(res) {\n        alert('function successful! returned: ' + JSON.stringify(res));\n    },\n    error: function(xhr) {\n        alert('an error occurred: ' + xhr.responseText);\n    }\n});