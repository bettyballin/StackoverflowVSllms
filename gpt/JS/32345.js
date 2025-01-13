$(document).ready(function() {\n    $("#tag-input").autocomplete({\n        source: function(request, response) {\n            $.ajax({\n                url: "/tags", // URL to your server-side script\n                type: "GET",\n                data: {\n                    term: request.term\n                },\n                success: function(data) {\n                    response(data);\n                },\n                error: function() {\n                    response([]);\n                }\n            });\n        },\n        minLength: 2 // Minimum number of characters before triggering the autocomplete\n    });\n});