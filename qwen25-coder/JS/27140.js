// Create a new GMap2 object and attach it to a div element with id "map"\nvar map = new GMap2(document.getElementById("map"));\nmap.setCenter(new GLatLng(37.4419, -122.1419), 13);\n\n// Load KML data from a cross-domain URL\nvar kml = new GGeoXML("http://example.com/example.kml");\n\n// Add the KML layer to the map\nmap.addOverlay(kml);