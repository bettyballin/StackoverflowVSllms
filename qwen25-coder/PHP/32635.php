$arrayObject = new ArrayObject([1, 2, 3, 4]);\n$valueToCheck = 3;\n\n$exists = false;\nforeach ($arrayObject as $value) {\n    if ($value === $valueToCheck) {\n        $exists = true;\n        break;\n    }\n}\n\nif ($exists) {\n    echo "Value exists in the ArrayObject.";\n} else {\n    echo "Value does not exist in the ArrayObject.";\n}