if (preg_match_all("#<td>\s+(-?\d+\.\d+)\s+</td>#", $output, $coords)) {\n    list($lat, $long) = $coords[1];\n    echo "Latitude: $lat\nLongitude: $long\n";\n}