$('.link').click(function(e) {\n  e.preventDefault(); // Prevent default action of the link\n  $.getScript('https://www.google.com/uds/api?file=uds.js&v=1.0', function() {\n    $('body').append('<p>GOOGLE API (UDS) is loaded</p>');\n  }).fail(function() {\n    console.error("Failed to load the Google API script.");\n  });\n});