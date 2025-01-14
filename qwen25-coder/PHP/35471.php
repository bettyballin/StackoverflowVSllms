<?php\n$array = ["string1", "string2", "string3", "string4"];\n\n// Filter out elements with even indices\n$filteredArray = array_filter($array, function($value, $key) {\n    return $key % 2 !== 0;\n}, ARRAY_FILTER_USE_BOTH);\n\nprint_r($filteredArray);\n?>