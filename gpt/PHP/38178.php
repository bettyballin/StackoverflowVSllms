$obj = new stdClass();\n$obj->{"foo"} = "bar";\n$obj->{"0"} = "zero";\n$arr = (array)$obj;\n\n// Use foreach loop to print key-value pairs\nforeach ($arr as $key => $value) {\n    echo "$key -- $value\n";\n}