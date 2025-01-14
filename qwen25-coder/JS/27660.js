$(document).ready(function() {\n    // Bind the ajaxSend event for all Ajax requests\n    $(document).ajaxSend(function(event, jqXHR, settings) {\n        console.log("URL being sent: " + settings.url);\n        console.log("Data being sent:", settings.data);\n\n        // If you need to stop the request, you can throw an error or return false from another function,\n        // but remember that returning false here won't cancel the request.\n    });\n\n    $("#submit").bind("click", function() {\n        var url = "http://myServer/cgi-bin/broker";\n        var data = {\n            'service': myService,\n            'program': myProgram,\n            'section': mySection,\n            'start': '09/08/08',\n            'end': '09/26/08'\n        };\n\n        // Convert data object to query string and construct full URL\n        var queryString = $.param(data);\n        console.log("Constructed URL: " + url + "?" + queryString);\n\n        // Optionally, you can decide here whether to proceed with the request or not.\n        if (queryString.includes('yourCondition')) {\n            return;  // This will prevent the Ajax request from happening\n        }\n\n        $.post({\n            url: url,\n            data: data,\n            dataType: "json",\n            error: function(request) {\n                $("#updateHTML").removeClass("hide");\n                $("#updateHTML").html(request.statusText);\n            },\n            success: function(data) {\n                $("#updateHTML").removeClass("hide");\n                $("#updateHTML").html(JSON.stringify(data));  // Assuming you want to show the JSON response\n            }\n        });\n    });\n});