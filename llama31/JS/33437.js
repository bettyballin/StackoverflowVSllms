var xhr = null;\n\nfunction myAjaxFunction() {\n  if (xhr && xhr.readyState != 4) {\n    xhr.abort();\n  }\n  xhr = $.ajax({\n    type: 'GET',\n    url: '/my-url',\n    success: function(data) {\n      // do something with data\n    }\n  });\n}