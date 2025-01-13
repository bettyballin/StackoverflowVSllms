const locations = [\n  { lat: 37.7749, lng: -122.4194 },\n  { lat: 37.8024, lng: -122.4056 },\n  { lat: 37.7948, lng: -122.4061 },\n  // Add more locations here...\n];\n\nconst bounds = new google.maps.LatLngBounds();\nlocations.forEach((location) => {\n  bounds.extend(location);\n});\n\nconst map = new google.maps.Map(document.getElementById('map'), {\n  center: bounds.getCenter(),\n  zoom: 15,\n});\n\nmap.fitBounds(bounds);\n\n// Add markers to the map\nlocations.forEach((location) => {\n  new google.maps.Marker({\n    position: location,\n    map: map,\n  });\n});