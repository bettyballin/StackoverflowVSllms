<?php\n$array = array(\n    1 => '1233',\n    2 => '12334',\n    3 => 'Hello',\n    4 => 'hello',\n    5 => 'U'\n);\n\n// Convert all strings to lowercase for case-insensitive comparison\n$lowercaseArray = array_map('strtolower', $array);\n\n// Count the occurrences of each value\n$valueCounts = array_count_values($lowercaseArray);\n\n// Filter the original array to get only duplicates (case-insensitive)\n$duplicates = array_filter($array, function($value) use ($lowercaseArray, $valueCounts) {\n    return $valueCounts[strtolower($value)] > 1;\n});\n\nprint_r($duplicates);\n?>