$.ajax({\n  url: '/your-url',\n  dataType: 'html',\n  success: function(data) {\n    // Insert HTML into the page\n  },\n  statusCode: {\n    401: function(xhr) {\n      // Handle 401 error here\n    }\n  }\n});