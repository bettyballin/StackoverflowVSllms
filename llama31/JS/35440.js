$('#myForm').keypress(function(event) {\n  if (event.key === 'Enter') {\n    event.preventDefault();\n    $(this).submit();\n  }\n});