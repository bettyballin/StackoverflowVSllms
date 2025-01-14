function isArrayAssociative(array $array) {\n    // If array is empty, it's not considered associative\n    if (empty($array)) return false;\n\n    // Check if all keys are integers and starts from 0\n    return array_keys($array) !== range(0, count($array) - 1);\n}\n\n// Example usage:\n$assocArray = ['key' => 'value'];\n$indexedArray = [1, 2, 3];\n\nvar_dump(isArrayAssociative($assocArray)); // bool(true)\nvar_dump(isArrayAssociative($indexedArray)); // bool(false)