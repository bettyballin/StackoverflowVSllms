$.ajax({\n    url: '/api/node/500/field_want_this_field',\n    dataType: 'json',\n    success: function(response){\n        var ajaxresult = response.data;\n        $someplace.append(ajaxresult);\n    },\n    error: function() {\n        console.error("Error fetching field data.");\n    }\n});