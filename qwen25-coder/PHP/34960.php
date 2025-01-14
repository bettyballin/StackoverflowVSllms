function deepCloneArray(&$array) {\n    $newArray = [];\n    foreach ($array as &$value) {\n        if (is_array($value)) {\n            // Recursively clone sub-arrays\n            $newArray[] = deepCloneArray($value);\n        } else {\n            // Clone the value, handle objects if necessary\n            $newArray[] = is_object($value) ? clone $value : $value;\n        }\n    }\n    return $newArray;\n}\n\n// Usage\n$results[] = deepCloneArray($array);