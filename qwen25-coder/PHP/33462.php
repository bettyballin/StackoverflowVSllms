function array_extract_keys_and_values($srcArray, $arrayOfWantedKeys) {\n    return array_intersect_key($srcArray, array_flip($arrayOfWantedKeys));\n}\n\n$data = array(\n    'personName' => 'John',\n    'personAge' => 99,\n    'personId' => 1,\n    // many more data I don't need here ...\n);\n\n$wanted_keys = ['personName', 'personAge', 'personId'];\n$filteredArray = array_extract_keys_and_values($data, $wanted_keys);\n\necho $filteredArray['personName'];  // Outputs: Joh