<?php\n$array = [\n    0 => 'Apple',\n    2 => 'Orange',\n    5 => 'Pear',\n    8 => 'Pear'\n];\n\n$maxIndex = max(array_keys($array));\n$defaultValue = ''; // You can change this to NULL or any other default value\n\nfor ($i = 0; $i <= $maxIndex; $i++) {\n    if (!isset($array[$i])) {\n        $array[$i] = $defaultValue;\n    }\n}\n\nksort($array); // Sort the array by keys\nprint_r($array);\n?>