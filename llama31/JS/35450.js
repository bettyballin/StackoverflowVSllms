$('#loading-message').show();\n$.getJSON('/your-url', function(data) {\n  // Process your data here\n  // ...\n  $('#loading-message').hide();\n});