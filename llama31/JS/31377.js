resizeIt = function() {\n  var textarea = $('iso_address');\n  var text = textarea.value;\n  var lines = text.split('\n');\n  var maxCols = textarea.cols;\n  var rows = 0;\n\n  lines.each(function(line) {\n    rows += Math.ceil(line.length / maxCols);\n  });\n\n  textarea.rows = rows;\n};