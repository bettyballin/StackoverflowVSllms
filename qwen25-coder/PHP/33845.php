$array = ['a', 'b', 'c', 'd'];\n\n$index = 0;\nforeach ($array as $value) {\n    echo $index . ': ' . $value . PHP_EOL;\n    ++$index;\n}