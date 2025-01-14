function initMap() {\n    var directionsService = new google.maps.DirectionsService;\n    var directionsDisplay = new google.maps.DirectionsRenderer;\n\n    var mapOptions = {\n        zoom: 12,\n        center: {lat: 35.740066, lng: 139.347582}\n    };\n    var dirMap = new google.maps.Map(document.getElementById('dirMap'), mapOptions);\n\n    directionsDisplay.setMap(dirMap);\n    calculateAndDisplayRoute(directionsService, directionsDisplay);\n}\n\nfunction calculateAndDisplayRoute(directionsService, directionsDisplay) {\n    directionsService.route({\n        origin: {lat: 35.740066, lng: 139.347582}, // Yokota\n        destination: {lat: 35.796532, lng: 139.406645}, // Ruby International\n        travelMode: 'DRIVING'\n    }, function(response, status) {\n        if (status === google.maps.DirectionsStatus.OK) {\n            directionsDisplay.setDirections(response);\n        } else {\n            window.alert('Directions request failed due to ' + status);\n        }\n    });\n}\n\n// Load the Google Maps API\nfunction loadScript() {\n    var script = document.createElement("script");\n    script.type = "text/javascript";\n    script.src = "https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&callback=initMap";\n    document.body.appendChild(script);\n}\nwindow.onload = loadScript;