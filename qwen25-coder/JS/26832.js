function refresh_context() {\n    $("#ajax-context").html("Searching...");\n    $.ajax({\n        url: "/ajax/ldap_search.php",\n        type: "GET",\n        data: {cn: $("#username").val()},\n        dataType: 'xml',\n        success: function(xml) {\n            $("#ajax-context").html($("display", xml).text());\n            $("#context").val($("context", xml).text());\n        },\n        error: function(){\n            $("#ajax-context").html("Error");\n        }\n    });\n}\n\n$(document).ready(function() {\n    $("#username").blur(refresh_context);\n});