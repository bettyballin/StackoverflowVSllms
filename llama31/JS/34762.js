$.ajax({\n    type: 'POST',\n    url: 'MyPage.aspx/GetData',\n    contentType: 'application/json; charset=utf-8',\n    dataType: 'json',\n    success: function(data) {\n        // handle the data returned from the server\n    }\n});