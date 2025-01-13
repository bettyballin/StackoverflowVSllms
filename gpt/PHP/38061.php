function printArray($array) {\n    foreach ($array as $key => $value) {\n        echo "Key: $key; Value: $value\n";\n    }\n}\n\n$indexedArray = [1, 2, 3];\n$associativeArray = ["key1" => "value1", "key2" => "value2"];\n\nprintArray($indexedArray);\nprintArray($associativeArray);