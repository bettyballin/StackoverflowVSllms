$A = array(1, 2, 3, 4, 5, 6, 7, 8);\n$B = array(1, 2, 3, 4);\n\n$result = [];\nforeach ($A as $value) {\n    if (!in_array($value, $B)) {\n        $result[] = $value;\n    }\n}\n\n// $result now contains [5, 6, 7, 8]