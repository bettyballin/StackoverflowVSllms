$(function() {\n    $.ajax({\n        type: 'POST',\n        url: 'Links_ajax.php',\n        data: 'category='+category,\n        success: function(data){\n            $("#response").html(data);\n            // Attach event listener to the links\n            $("#response a").on("click", requestCustomerInfo);\n        }\n    });\n});