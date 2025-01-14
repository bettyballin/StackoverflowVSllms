map.addListener('bounds_changed', function() {\n    var bounds = map.getBounds();\n    var ne = bounds.getNorthEast();\n    var sw = bounds.getSouthWest();\n\n    $.get('/your-data-endpoint', {neLat: ne.lat(), neLng: ne.lng(), swLat: sw.lat(), swLng: sw.lng()}, function(data) {\n        data.forEach(function(point) {\n            var marker = new google.maps.Marker({\n                position: {lat: point.lat, lng: point.lng},\n                map: map\n            });\n            // Optional: Add more properties to the marker\n        });\n    });\n});