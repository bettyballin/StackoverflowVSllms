$.extend($.expr[':'], {\n  input: function(elem) {\n    return $(elem).is('input, select, textarea, [contenteditable="true"]') && !$(elem).is(':submit, :reset');\n  }\n});