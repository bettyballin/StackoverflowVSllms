var timeout;\ngoogle.maps.event.addListener(map, 'bounds_changed', function() {\n  clearTimeout(timeout);\n  timeout = setTimeout(function() {\n    var bounds = map.getBounds();\n    // Make AJAX request here\n  }, 500);\n});