$array_with_keys = ['a', 'b', 'c'];\n$array_with_values = [1, 2, 3];\n\n$mapped_array = array_combine($array_with_keys, $array_with_values);\n\nprint_r($mapped_array);