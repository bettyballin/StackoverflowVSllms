$('#search').keyup(function(e) {\n  var input_text = $(this).val();\n  if (input_text.length >= 2) { // trigger search when at least 2 characters are entered\n    $('#doSearch').click();\n  }\n});\n\n$('#search').keydown(function(e) {\n  if (e.which == 9) { // tab key\n    $('#doSearch').focus();\n  }\n});