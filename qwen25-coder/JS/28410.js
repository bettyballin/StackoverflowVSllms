// Assuming you have an array of geo-locations as latlng objects\nvar locations = [\n  {lat: -34.397, lng: 150.644},\n  {lat: -35.284, lng: 149.129}\n];\n\nfunction initMap() {\n    var map = new google.maps.Map(document.getElementById('map'), {\n        zoom: 8,\n        center: {lat: -34.397, lng: 150.644} // initial random center\n    });\n\n    var bounds = new google.maps.LatLngBounds();\n\n    locations.forEach(function(location) {\n        var marker = new google.maps.Marker({\n            position: location,\n            map: map\n        });\n        \n        // Extend the bounds to include each marker's position\n        bounds.extend(marker.position);\n    });\n\n    // Fit these bounds to the map\n    map.fitBounds(bounds);\n}\n\n// Remember to load your Google Maps script with a callback to this `initMap` functio