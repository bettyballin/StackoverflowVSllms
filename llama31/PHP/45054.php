function isAssociative(array $array): bool {\n    return $array !== array_values($array);\n}\n\n// Testing\n$array1 = [1, 2, 3]; // not associative\n$array2 = ['a' => 1, 'b' => 2]; // associative\n\nvar_dump(isAssociative($array1)); // false\nvar_dump(isAssociative($array2)); // true