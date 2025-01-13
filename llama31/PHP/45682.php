function flattenArray(array $array): array\n{\n    $flattened = [];\n    foreach ($array as $item) {\n        if (is_array($item)) {\n            $flattened = array_merge($flattened, flattenArray($item));\n        } else {\n            $flattened[] = $item;\n        }\n    }\n    return $flattened;\n}\n\n// Example usage\n$multiDimensionalArray = [\n    'a', 'b', ['c', 'd', ['e', 'f']], 'g'\n];\n\n$flattenedArray = flattenArray($multiDimensionalArray);\nprint_r($flattenedArray);