$.ajax({\n      url: 'your-api-endpoint',\n      type: 'GET',\n      success: function(data) {\n          console.log(data);\n      },\n      error: function(error) {\n          console.error('Error:', error);\n      }\n  });