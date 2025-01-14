function drawMarker(map, position, html) {\n  var marker = new google.maps.Marker({\n    position: position,\n    map: map\n  });\n\n  var infowindow = new google.maps.InfoWindow({\n    content: html\n  });\n\n  marker.addListener('click', function() {\n    infowindow.open(map, marker);\n  });\n}