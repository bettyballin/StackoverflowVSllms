$.ajax({\n  url: '/proxy/path/to/resource',\n  type: 'GET',\n  success: function(data) {\n    // handle success\n  },\n  error: function(xhr, status, error) {\n    // handle error\n  }\n});