Event.observe(window, 'load', function() {\n  var col1Height = $('col1').getHeight();\n  var col2Height = $('col2').getHeight();\n  var maxHeight = Math.max(col1Height, col2Height) + 130;\n  $('main').setStyle({'height': maxHeight + 'px'});\n});