$('#textbox').select(function() {\n  var selectedText = $(this).val().substring(this.selectionStart, this.selectionEnd);\n  alert(selectedText);\n});\n\n$(document).mousedown(function(event) {\n  if (event.target !== $('#textbox')[0]) {\n    event.preventDefault();\n  }\n});