$.ajax({\n  url: '/api/data',\n  method: 'GET',\n  success: function(data) {\n    console.log(data);\n  },\n  error: function(xhr, status, error) {\n    console.error(error);\n  }\n});