$fetched = file_get_contents("http://example.com");\nif (preg_match('/zip=([0-9]+)/', $fetched, $matches)) {\n    $zip = $matches[1];\n    echo "Zip code is: " . $zip;\n} else {\n    echo "No zip code found.";\n}