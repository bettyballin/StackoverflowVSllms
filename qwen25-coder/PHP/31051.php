<?php\nrequire 'path/to/GMap.php';\n\n$gmap = new GMap();\n$gmap->setZoom(12);\n$gmap->disableScrollWheel();\n$gmap->addMarker(new GMapPoint(38.6354, -90.2796, "St Louis"));\n\n?>\n<script type="text/javascript" src="https://maps.google.com/maps/api/js?key=YOUR_API_KEY&sensor=false"></script>\n<div id="the_map"><?php echo $gmap->getHTML(); ?></div>