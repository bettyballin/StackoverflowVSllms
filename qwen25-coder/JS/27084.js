$.get('textes.html #nicolas', function(data) {\n    $('#right').append(data);\n    $.get('textes.html #antoine', function(data2) {\n        $('#right').append('<hr>').append(data2);\n    });\n});