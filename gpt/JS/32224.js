$(document).ready(function() {\n    $.get('info.html', {}, function(responseText) {\n        // Convert the response text into a jQuery object\n        var html = $(responseText);\n\n        // Debug code\n        console.log(html.find('ul').html());\n        // End debug code\n    });\n});