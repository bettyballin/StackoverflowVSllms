// Create a Leaflet map\nvar map = L.map('map').setView([37.7749, -122.4194], 13);\n\n// Add a local tile layer (using OpenStreetMap data)\nL.tileLayer('file:///path/to/local/tiles/{z}/{x}/{y}.png', {\n  attribution: '&copy; OpenStreetMap contributors',\n  maxZoom: 18,\n  minZoom: 5\n}).addTo(map);