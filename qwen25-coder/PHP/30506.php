$array = ['jim' => null];\n\n$key = 'jim';\n\n// This will be false because the value is null\nif (isset($array[$key])) {\n    echo "Key exists and value is not null.\n";\n}\n\n// This will be true because the key exists, even though the value is null\nif (array_key_exists($key, $array)) {\n    echo "Key exists.\n";\n}