$.ajax({\n    url: '/YourController/YourAction',\n    type: 'POST',\n    data: { /* your data */ },\n    success: function(response) {\n        // handle success\n    },\n    error: function(err) {\n        // handle error\n    }\n});