<script type="text/javascript">\n     function load() {\n       var map = new GMap2(document.getElementById("map"));\n       map.setCenter(new GLatLng(0, 0), 2); // Default center and zoom level\n       map.setMapType(G_HYBRID_MAP);\n\n       map.addControl(new GLargeMapControl());\n       map.addControl(new GScaleControl());\n       map.addControl(new GMapTypeControl());\n\n       // Iterate over the mapsData array\n       for (var i = 0; i < mapsData.length; i++) {\n         var mapEntry = mapsData[i];\n         var coordinates = mapEntry.Coordinates.split(",");\n         var latLng = new GLatLng(parseFloat(coordinates[0]), parseFloat(coordinates[1]));\n         var marker = new GMarker(latLng);\n         var html = "<b>" + mapEntry.MarkerTitle + "</b><br/>" + mapEntry.MarkerField;\n         \n         map.addOverlay(marker);\n         GEvent.addListener(marker, "click", (function(marker, html) {\n           return function() {\n             marker.openInfoWindowHtml(html);\n           };\n         })(marker, html));\n       }\n     }\n\n     // Ensure the load function is called when the window loads\n     window.onload = load;\n   </script>