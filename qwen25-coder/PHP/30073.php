$xmlString = '<profile>\n   <name>john</name>\n   <lang>english</lang>\n   <lang>dutch</lang>\n</profile>';\n\n$xml = simplexml_load_string($xmlString);\n\n// Access the name\n$name = (string) $xml->name;\n\n// Initialize an array to hold languages\n$languages = [];\n\n// Iterate over each lang element and add it to the languages array\nforeach ($xml->lang as $language) {\n    $languages[] = (string) $language;\n}\n\necho "Name: " . $name . "\n";\necho "Languages spoken: " . implode(", ", $languages);