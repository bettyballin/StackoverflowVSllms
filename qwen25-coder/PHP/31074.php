function loop($array, $callback) {\n    for ($x = 0; $x < count($array); $x++) {\n        $callback($array[$x], $x);\n    }\n}\n\n// Usage example:\n$array = [1, 2, 3, 4, 5];\nloop($array, function($value, $index) {\n    echo "Index: $index, Value: $value\n";\n});