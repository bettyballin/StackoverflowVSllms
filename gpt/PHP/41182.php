<?php\nfunction getValue($array, $key) {\n    $currentElement = current($array);\n    return isset($currentElement[$key]) ? $currentElement[$key] : null;\n}\n\n// Example usage:\n$arr = [\n    ['item' => 'first', 'value' => 1],\n    ['item' => 'second', 'value' => 2],\n    ['item' => 'third', 'value' => 3]\n];\n\necho getValue($arr, 'item'); // Outputs: first\n\n// Move the internal pointer and get the next element\nnext($arr);\necho getValue($arr, 'item'); // Outputs: second\n?>