$('#search').on('input', function() {\n  var input_text = $(this).val();\n  if (input_text.length >= 2) { // trigger search when at least 2 characters are entered\n    $('#doSearch').click();\n  }\n});