$(document).ready(function() {\n    $("#autocompleteInput").autocomplete({\n        source: function(request, response) {\n            $.ajax({\n                url: "/your-server-endpoint/query", // Replace with your server endpoint URL\n                dataType: "json",\n                data: {\n                    term: request.term // Sending the user input to the server\n                },\n                success: function(data) {\n                    response($.map(data.items, function(item) {\n                        return {\n                            label: item.label,\n                            value: item.value\n                        };\n                    }));\n                }\n            });\n        },\n        minLength: 2, // Minimum length of input before suggestion starts\n        select: function(event, ui) {\n            // Handle selection event if needed\n            $("#autocompleteInput").val(ui.item.label);\n            return false;\n        }\n    });\n});