$.ajax({\n       method: "get",\n       url: "getPage.php",\n       data: $data,\n       dataType: 'json',\n       timeout: 2000,\n       cache: true, // Force jQuery to consider caching\n       success: function(result) {\n           handleContent(result);\n       }\n   });