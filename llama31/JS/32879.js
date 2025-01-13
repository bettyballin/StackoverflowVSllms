jQuery("#searchfield").keyup(function(e){\n    var searchval = jQuery("#searchfield").val();\n    console.log(searchval);\n\n    jQuery.ajax({\n        type: 'POST',\n        url: 'ajax_handler.php',\n        dataType: 'json',\n        data: {\n            search: searchval\n        },\n        success: function(data){\n            console.log("good");\n            console.log(data.msg);\n\n            // Clear the suggestions list\n            jQuery("#suggestions").empty();\n\n            // Add suggested values to the list\n            jQuery.each(data.msg, function(index, value){\n                jQuery("#suggestions").append("<li>" + value + "</li>");\n            });\n        },\n        error: function(data){\n            console.log("error");\n        }\n    });\n});