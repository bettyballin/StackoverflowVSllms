// Include Mootools and SqueezeBox\nMooTools-more.js\n// Initialize SqueezeBox\nvar squeeze = new SqueezeBox({\n  append: $('videoContainer'),\n  overlayOpacity: 0.8,\n  overlayColor: '#000',\n  resizeSpeed: 200,\n  onOpen: function(){\n    // You can add custom logic here\n  }\n});\n\n// Attach click event to the link\n$('showVideo').addEvent('click', function(event){\n  event.stop();\n  squeeze.open();\n});