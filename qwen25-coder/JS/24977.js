$(function() {\n    $( "#slider" ).slider({\n        range: "min",\n        value: 37,\n        min: 1,\n        max: 100,\n        stop: function( event, ui ) {\n            // AJAX call to update the score on the server\n            $.ajax({\n                url: 'update-score.php',\n                type: 'POST',\n                data: { score: ui.value },\n                success: function(response) {\n                    console.log('Score updated:', response);\n                }\n            });\n        }\n    });\n});