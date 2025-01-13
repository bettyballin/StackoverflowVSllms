$output = "Country=UNITED STATES (US) &City=Scottsdale, AZ &Latitude=33.686 &Longitude=-111.87";\n\n// Split the string by the '&' character\n$parts = explode('&', $output);\n\n// Initialize variables for latitude and longitude\n$latitude = '';\n$longitude = '';\n\n// Loop through the parts and find the latitude and longitude\nforeach ($parts as $part) {\n    if (strpos($part, 'Latitude=') !== false) {\n        $latitude = str_replace('Latitude=', '', $part);\n    }\n    if (strpos($part, 'Longitude=') !== false) {\n        $longitude = str_replace('Longitude=', '', $part);\n    }\n}\n\n// Output the latitude and longitude\necho "Latitude: " . $latitude . "\n";\necho "Longitude: " . $longitude . "\n";