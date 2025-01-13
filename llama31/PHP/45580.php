$weights = [0.25, 0.4, 0.2, 0.15];\n$values = [\n    [5, 10, 15],\n    [20, 25, 30],\n    [35, 40, 45],\n    [50, 55, 60]\n];\n\n$result = array_map(function($column) use ($weights, $values) {\n    return array_sum(array_map(function($value, $weight) {\n        return $value * $weight;\n    }, $column, $weights));\n}, array_map(null, ...$values));\n\nprint_r($result);