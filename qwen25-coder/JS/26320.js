$(document).ready(function() {\n    $('#color, #size').change(function() {\n        var color = $('#color').val();\n        var size = $('#size').val();\n\n        $.ajax({\n            url: 'calculate.php',\n            type: 'POST',\n            data: {colorValue: color, sizeValue: size},\n            success: function(response) {\n                $('#totalPrice').text(response);\n            }\n        });\n    });\n});