$(document).ready(function() {\n    $("#submitButton").click(function() {\n        $.ajax({\n            type: "POST",\n            url: "/YourController/YourActionMethod",\n            data: { param1: 'value' },\n            success: function(response) {\n                alert('Success: ' + response);\n            },\n            error: function(xhr, status, error) {\n                alert('Error: ' + error);\n            }\n        });\n    });\n});