$array = [123 => 5, 456 => 3, 789 => 1];\n$lookup = [123 => ' Foo', 456 => 'Bar', 789 => 'Baz'];\n\n$result = replace_keys($array, $lookup);\nprint_r($result);