$('#foo').submit(function(e) {\n  e.preventDefault();\n  $.post('getdata.php', $(this).serialize(), function(data) {\n    $('#result').html(data);\n  });\n});