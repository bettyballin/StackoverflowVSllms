$.ajax({\n    type: 'POST',\n    url: '/DeleteUser',\n    data: { id: 1 },\n    success: function(data) {\n        alert(data);\n    },\n    error: function(xhr, status, error) {\n        alert(xhr.responseText);\n    }\n});