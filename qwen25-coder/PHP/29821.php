<?php\n\nfunction geocodeAddress($address, $apiKey) {\n    $url = 'https://maps.googleapis.com/maps/api/geocode/json?address=' . urlencode($address) . '&key=' . $apiKey;\n    $response = file_get_contents($url);\n    $json = json_decode($response, true);\n\n    if (isset($json['results'][0]['geometry']['location'])) {\n        return [\n            'lat' => $json['results'][0]['geometry']['location']['lat'],\n            'lng' => $json['results'][0]['geometry']['location']['lng']\n        ];\n    }\n\n    return null;\n}\n\n$apiKey = 'YOUR_GOOGLE_MAPS_API_KEY';\n$address = '1600 Amphitheatre Parkway, Mountain View, CA';\n\n$coordinates = geocodeAddress($address, $apiKey);\nif ($coordinates) {\n    echo "Latitude: {$coordinates['lat']}, Longitude: {$coordinates['lng']}";\n} else {\n    echo "Unable to find coordinates for the provided address.";\n}\n\n?>