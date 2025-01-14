// Example of directly including Google Maps JavaScript API\nfunction initMap() {\n    var location = {lat: -34.397, lng: 150.644};\n    var map = new google.maps.Map(document.getElementById('map'), {\n        zoom: 8,\n        center: location\n    });\n    var marker = new google.maps.Marker({\n        position: location,\n        map: map\n    });\n}