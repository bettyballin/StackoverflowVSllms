$.ajax({\n  url: 'http://www.google.com/cse',\n  data: {\n    cx: 'MY_UNIQUE_KEY',\n    client: 'google-csbe',\n    output: 'json',\n    q: 'query+terms',\n    callback: 'myCallback'\n  },\n  dataType: 'jsonp',\n  success: function(data) {\n    // Process the JSON data\n  }\n});\n\nfunction myCallback(data) {\n  // Process the JSON data\n}