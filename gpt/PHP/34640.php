$array = ['jim' => null];\n\n// Using isset\nif (isset($array['jim'])) {\n    echo "Key 'jim' exists and is not null.";\n} else {\n    echo "Key 'jim' does not exist or is null.";\n}\n\n// Using array_key_exists\nif (array_key_exists('jim', $array)) {\n    echo "Key 'jim' exists.";\n} else {\n    echo "Key 'jim' does not exist.";\n}