$('#interceptMe').click(function(event) {\n    // Prevent the default action of the link\n    event.preventDefault();\n\n    // Make the AJAX call\n    $.get('/Ajax/Call', goesIn, function(comesOut) {\n        $('#changeMe').html(comesOut);\n    }, "html");\n});