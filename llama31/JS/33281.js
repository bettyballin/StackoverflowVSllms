$(document).ready(function() {\n    $.get('info.html', {}, function(html) {\n        var parsedHtml = $.parseHTML(html);\n        console.log($(parsedHtml).find('ul').html());\n    });\n});