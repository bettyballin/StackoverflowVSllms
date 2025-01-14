// Your data array\n$replace = [\n    'address' => '123 Elm St',\n    'fixDate' => '2023-10-15',\n    'measureDate' => '2023-10-14',\n    'builder' => 'John Doe'\n];\n\n// Your template\n$template = "<td>{{address}}</td><td>{{fixDate}}</td><td>{{measureDate}}</td><td>{{builder}}</td>";\n\n// Regex to find all occurrences of {{var}}\n$pattern = '/\{\{(\w+)\}\}/';\n\n// Replace each match with the corresponding value from the array\n$result = preg_replace_callback($pattern, function($matches) use ($replace) {\n    // Check if the key exists in the data array and return it or an empty string otherwise\n    return $replace[$matches[1]] ?? '';\n}, $template);\n\necho $result;