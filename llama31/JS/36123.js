somefunction: function(callback){\n    myAjax = new Ajax.Request(postUrl, {\n        method: 'post',\n        postBody: postData,\n        contentType: 'application/x-www-form-urlencoded',\n        onComplete: function(transport){\n            if (200 == transport.status) {\n                callback(transport.responseText);\n            }\n        }\n    });\n}