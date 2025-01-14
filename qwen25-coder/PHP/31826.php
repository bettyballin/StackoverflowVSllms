<?php\nrequire_once("geoip.inc");\n\n$gi = geoip_open("/path/to/GeoLiteCountry.dat", GEOIP_STANDARD);\n$country_code = @geoip_country_code_by_addr($gi, $_SERVER['REMOTE_ADDR']);\n@geoip_close($gi);\n\nif ($country_code !== 'YOUR_ALLOWED_COUNTRY') {\n    header("HTTP/1.0 403 Forbidden");\n    echo "Access is restricted to a specific country only.";\n    exit();\n}\n\n// Continue with the rest of your script\n?>