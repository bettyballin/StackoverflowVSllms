$.ajax({\n    type: 'GET',\n    url: "http://localhost:3000/proxy?url=http://www.remote-url.com",\n    dataType: 'html',\n    success: function(data) {\n        $('#put_here').empty().append(data);\n    }\n});