<?php\n\n$input = "{ 1, 3, 1, 2, }, { 2, 3, 2, 1, }, { 3, 3, 2, 2, }, { 1, 2, 3, 1, },";\n\n// Remove spaces and split the string by '}, {' to get each group\n$groups = preg_split('/\s*},\s*\{/', trim($input, '{}'));\n\n// Initialize an array to hold the final arrays\n$resultArrays = [];\n\nforeach ($groups as $group) {\n    // Split each group by comma to get individual numbers\n    $numbers = explode(',', $group);\n    // Trim whitespace from each number and convert it to integer\n    $resultArrays[] = array_map('intval', array_map('trim', $numbers));\n}\n\n// Output the result\nprint_r($resultArrays);\n\n?>