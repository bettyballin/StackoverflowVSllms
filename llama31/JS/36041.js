// Choose selecting existing file\n$('#select-file').bind('focus', function() {\n  // Clear any files currently selected in #upload-file\n  $('#upload-file').closest('form').get(0).reset();\n});