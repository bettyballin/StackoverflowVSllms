$xmlString = '<object><data type="me">myname</data><data type="you">yourname</data><data type="me">myothername</data></object>';\n$sxml = simplexml_load_string($xmlString);\n$results = $sxml->xpath('//object/data[@type="me"]');\n\nforeach ($results as $result) {\n    echo (string)$result . "\n";\n}